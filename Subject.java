/*
 * This is the interface to implement the Observer Pattern for the subject aspect of the pattern
 */
public interface Subject {
    
    /**
     * Sets the observer for the subject
     * @param o
     */
    public void setObserver(Observer o);
    
    /**
     * notifies the observer of any changes made
     */
    public void notifyObservers();
    /**
     * gets the update from the observer object
     * @param o
     * @return new state
     */
    public String getUpdate(Observer o);
    
}
