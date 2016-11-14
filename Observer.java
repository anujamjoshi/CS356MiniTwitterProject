/*
 * This is the interface to implement the Observer Pattern
 */

public interface Observer {
    /**
     * Sets the subject for the observer
     * @param s
     */
    public void setSubject(Subject s);
    /**
     * get the subject's update
     * @param s
     */
    public void update(Subject s);
    
}
