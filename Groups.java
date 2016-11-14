/**
 * This class uses the Visit programming type to define a method to go 
 * through the entire tree and count the number of groups
 * to be used during the admin control panel implementation 
 */
public class Groups implements Visitor{
	int numGroups = 0;

	@Override
	public void visit(TwitterUser u) {
		if (u instanceof UserGroup){
			numGroups ++;
		}
	}
	
	public int getNumMessages(){
		return numGroups;
	}
	

}

