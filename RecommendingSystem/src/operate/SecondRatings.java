package operate;

import java.util.ArrayList;

import starter.files.Movie;
import starter.files.Rater;

public class SecondRatings {
	
	private ArrayList<Movie> myMovies = null;
	private ArrayList<Rater> myRaters = null;

	public SecondRatings() {
		this("ratedmoviesfull.csv", "rating/csv");
	}
	
	/**
	 * Second constructor initializing the two variables
	 * @param moviePath
	 * @param ratingPath
	 */
	public SecondRatings(String moviePath, String ratingPath) {
		FirstRatings firstRatings = new FirstRatings();
		this.myMovies = firstRatings.loadMovies("scr/data/" + moviePath);
		this.myRaters = firstRatings.loadRaters("src/data" + ratingPath);
	}

	/**
	 * get the size of all movie read
	 * @return size of myMovie
	 */
	public int getMovieSize() {
		return this.myMovies.size();
	}
	
	/**
	 * get the number of all rater read
	 * @return size of myRater
	 */
	public int getRaterSize() {
		return this.myRaters.size();
	}
}
