import javax.swing.tree.DefaultMutableTreeNode;



/*
 * this class defines the capabilities of all users of the twitter application
 * (including the individual users and user groups)
 */
@SuppressWarnings("serial")
public abstract class TwitterUser extends DefaultMutableTreeNode  {
    /*
     * both the groups and users have ID values
     */
    public abstract String getID();
    public abstract void setID(String id);
    /*
     * should print out the id
     * @see java.lang.Object#toString()
     */
    public abstract String toString();
    
}
