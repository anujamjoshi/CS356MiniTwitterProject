/**
 * This class uses the Visit programming type to define a method to go to each
 * user and count the number of messages
 * to be used during the admin control panel implementation
 */
public class Messages implements Visitor {
    int numMessages = 0;
    
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User) {
            numMessages += ((User) u).getNewsfeed().size();
        }
    }
    
    public int getNumMessages() {
        return numMessages;
    }
    
}
