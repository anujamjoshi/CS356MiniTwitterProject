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
	 * get the subject's update but doesn't tell how to push the update 
	 * @param s
	 */
	public void getUpdate(Subject s);

}

