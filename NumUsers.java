/**
 * This class uses the Visit programming type to define a method to go
 * through the entire tree and count the number of users
 * to be used during the admin control panel implementation
 */
public class NumUsers implements Visitor {
    int count =0;
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User){
            count++;
        }
        
    }
    public int getCount(){
        return count; 
    }
    
}
