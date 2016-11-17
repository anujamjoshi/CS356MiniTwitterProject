import java.util.ArrayList;

import javax.swing.DefaultListModel;
/**
 * This class uses the Visitor programming type to define a method to go
 * through user's messages and count the number of positive messages
 * to be used during the admin control panel implementation
 */

public class PositiveMessages implements Visitor {
    /**
     * count of the number of positive words in each message
     */
    private int numPositive =0;
    /**
     * count of the number of  words in each feed
     */
    private int numWords =0;
    /**
     * this is a list of positive words
     */
    String [] positiveWordsList = {"good","great","excellent", "adore", "beautiful", "love", "happy", "nice", "amazing", "together"};
    /**
     * list of all words to check
     */
    ArrayList <String> words = new ArrayList<>();
    /**
     * Go to the user and get the newsfeed and then separate it into words and add each word into the array list of words
     * then goes through that list and adds the number of positive words
     * @param u
     */
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User){
            DefaultListModel<String> news =((User) u).getNewsfeed();
            for (Object s: news.toArray()){
                String[] temp =((String) s).split(" ");
                for (String t:temp){
                    words.add(t.toLowerCase());
                }
                
            }
        }
        numWords= words.size();
        addPositiveCount();
        
    }
    /**
     * go through the words list and then check to see if there are any positive words in it
     */
    private void addPositiveCount(){
        for(String positive: positiveWordsList){
            if (words.contains(positive)){
                words.remove(positive);
                numPositive++;
            }
        }
    }
    /**
     *  get the percentage 
     */
    public double getPercent(){
        if(numWords>0){
            return numPositive*100/numWords;
        }
        popUpWindow p = new popUpWindow();
        
        p.infoBox("Can't get Percentage", "Error");
        return 0;
    }
    
}
