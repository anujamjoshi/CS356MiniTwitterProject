import javax.swing.tree.DefaultTreeModel;


/**
 * This interface allows for the basic methods of the structure needed to be defined
 */
public interface TreeDataStructure {
    
    
    /**
     * This method adds the user or user group into the structure to store it
     * @param parent
     * @param child
     * @return true if it is added successfully
     */
    public  boolean addNode(TwitterUser parent, TwitterUser child);
    /**
     * checks to see if the User/ User group with id s is in the tree
     * @param userID
     * @return true if it is
     */
    public  boolean contains(String userID);
    
    /**
     * goes through the entire tree and gets the Twitter User
     * @param userID
     * @return
     */
    public  TwitterUser getTwitterUser(String userID);
    public DefaultTreeModel getModel();
    
}
