import java.util.ArrayList;


@SuppressWarnings("serial")
public class User extends TwitterUser implements Observer, Subject {
    // all users have an id, a list of followers and following, and a list of newsfeed
    private String id;
    private ArrayList<Observer> followers = new ArrayList<>();
    private ArrayList <Subject> following = new ArrayList<>();
    private ArrayList <String> newsfeed = new ArrayList<>();
    private boolean updatedFeed=false;
    private String message;
    private UserGroup group;
    
    /**
     * Constructor
     */
    public User(String id){
        setID(id);
        updatedFeed=false;
        group=null;
        
        
    }
    /**
     * if the user gets added into a group then it needs to be set
     */
    public void addGroup(UserGroup g){
        if (group ==null){
            group = g;
        }
        else{
            System.out.println("already in group, can't add another group");
        }
    }
    public UserGroup getGroup(){
        return group;
    }
    /**
     * tweet the message that @this is posting
     */
    public void tweet(String m ){
        this.message= m;
        updatedFeed=true;
        newsfeed.add("-me: "+message); // adds to own newsfeed
        notifyObservers();// tell observers to update newsfeed themselves
    }
    /**
     * @return the followers
     */
    public ArrayList<Observer> getFollowers() {
        return followers;
    }
    
    /**
     * @return the following
     */
    public ArrayList<Subject> getFollowing() {
        return following;
    }
    
    
    /**
     * @return the newsfeed
     */
    public ArrayList<String> getNewsfeed() {
        return newsfeed;
    }
    /**
     * follows another user
     * adds the user u to the following list (subject list)
     * adds the current user to the following list of the passed in user (observer list)
     */
    public void follow(User u){
        setSubject(u);
        u.setObserver(this);
    }
    
    /*
     *Updating the Twitter User methods
     */
    @Override
    public String getID() {
        
        return id;
    }
    
    @Override
    public void setID(String id) {
        this.id = id;
        
    }
    
    @Override
    public String toString() {
        return this.getID();
    }
    /*
     * override all Observer methods all of the user's followers have this action
     */
    @Override
    public void setSubject(Subject s) {
        following.add(s);
        
    }
    /**
     * when the user has created an update, add it into the news feed of the user it is following
     */
    @Override
    public void update(Subject s) {
        String update = getUpdate(this);
        newsfeed.add("-"+s.toString()+": "+update);
        
    }
    
    /*
     * override all Subject methods
     */
    @Override
    public void setObserver(Observer o) {
        followers.add(o);
        
    }
    
    
    @Override
    public void notifyObservers() {
        /*
         * when you add a new message, update the follower's newsfeeds 
         */
        if(updatedFeed){
            updatedFeed=false;
            for (Subject o: following){
                // for each observer get the message to update and add it to the respective newsfeed. 
                update(o);
            }
            
        }
        
        
    }
    
    @Override
    public String getUpdate(Observer o) {
        return this.message;
    }
    
}
