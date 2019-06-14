package starter.files;


/**
 * People who rate movie
 * 
 * @author Zifeng Zhang
 * @version (a version number or a date)
 */

import java.util.*;

public class Rater {
	
    private String myID;
    private ArrayList<Rating> myRatings;

    public Rater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating(String item) {
        for(int i=0; i < myRatings.size(); i++){
            if (myRatings.get(i).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        for(int i=0; i < myRatings.size(); i++){
            if (myRatings.get(i).getItem().equals(item)){
                return myRatings.get(i).getValue();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i < myRatings.size(); i++){
            list.add(myRatings.get(i).getItem());
        }
        
        return list;
    }
}
