package operate;

import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;

import starter.files.Movie;
import starter.files.Rater;

/**
 * Read data from CSV files
 * @author zzf
 *
 */
public class FirstRatings {

	public static void main(String[]args) {
		FirstRatings test = new FirstRatings();
//		ArrayList<Movie> testArr = test.loadMovies("src/data/ratedmovies_short.csv");
//		for(Movie movie : testArr) {
//			System.out.println(movie);
//		}
//		test.testLoadMovies();
//		test.testLoadRaters();
	}

	/**
	 * Read movies from CSV file
	 * @param filename
	 * @return an ArrayList of movies
	 */
	public ArrayList<Movie> loadMovies(String filename) {
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			Reader fileReader = new FileReader(new File(filename));
			CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader(); //skip the first record but as header
			CSVParser csvParser = new CSVParser(fileReader, format);
			
			for(CSVRecord record : csvParser) {
				Movie movie = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"), 
						record.get("director"), record.get("country"), record.get("minutes"), record.get("poster"));
				movies.add(movie);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return movies;
	}
	
	/**
	 * Test the method "loadMovies"
	 * 1. Count the number of movies
	 * 2. Print the list of movies
	 * 3. Count movies in genre "Comedy"
	 * 4. Count movies greater than 150 mins
	 * 5. The maximum of movies by any director and the director
	 */
	public void testLoadMovies() {
		ArrayList<Movie> arrayList = loadMovies("src/data/ratedmoviesfull.csv");
		
		//1. number of movies
		System.out.println("There are " + arrayList.size() + " movies in the list.");
		
		//2. Listing the movies
		System.out.println("Here is a list of the movies:");
		for(Movie movie : arrayList) {
			System.out.println(movie);
		}
		
		//3. Count comedy movies
		int count = 0;
		for(Movie movie : arrayList) {
			String[] genres = movie.getGenres().split(",");
			for(String genre : genres) {
				if(genre.trim().toLowerCase().equals("comedy"))
					count ++;
			}
		}
		System.out.println("There are " + count + " comedy movie(s).");
		
		//4. Count movies that are greater than 150 mins
		count = 0;
		for(Movie movie : arrayList) {
			int minutes = movie.getMinutes();
			if(minutes > 150)
				count ++;
		}
		System.out.println("There are " + count + " movie(s) greater than 150 minutes.");
		
		//5. Maximum of movies by any director
		//5.1 Find the unique set of directors
		Set<String> directorsSet = new HashSet<>();
		HashMap<String,Integer> map = new HashMap<>();
		for(Movie movie : arrayList) {
			String[] directors = movie.getDirector().split(",");
			for(String director : directors)
				directorsSet.add(director);
		}
		
		//5.2 Match directors with the total number of their movies
		for(String director : directorsSet) {
			count = 0;
			for(Movie movie : arrayList) {
				if(movie.getDirector().contains(director))
					count ++;
			}
			map.put(director, count);			
		}
		
		//5.3 find the max number of movies
		int max = 0;
		for(String director : map.keySet()) {
			int val = map.get(director);
			if(val >= max)
				max = val;
		}
		
		//5.4 find the directors with maximum movies
		System.out.println("The directors with maximum number of " + max + " movies are: ");
		for(String director : map.keySet()) {
			int val = map.get(director);
			if(max == val) {
				System.out.print("   " + director + ";");
			}
		}
	}
	
	/**
	 * Read raters and their rating into ArrayList
	 * Raters have to be orderred according to rate_id
	 * @param filename
	 * @return List of raters
	 */
	public ArrayList<Rater> loadRaters(String filename) {
		ArrayList<Rater> raters = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(new File(filename));
			CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
			CSVParser csvParser = new CSVParser(fileReader, format);
			Set<String> idSet = new HashSet<>();
			Rater rater = null;
			for(CSVRecord record : csvParser) {
				String raterId = record.get("rater_id");
				if(!idSet.contains(raterId)) {
					idSet.add(raterId);
					rater = new Rater(raterId);
					raters.add(rater);
				}
				rater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return raters;
	}
	
	/**
	 * Test the method "loadRaters()"
	 * 1. Print total number of raters
	 * 2. Print raterID + number of ratings + ratings + movie
	 * 3. Find the number of ratings of a specified rater (rater_id)
	 * 4. The maximum number of ratings by any rater and the raters
	 * 5. Find the number of raters a specified movie has
	 * 6. Find the number of movies rated by all the raters
	 */
	public void testLoadRaters() {
		ArrayList<Rater> raters = loadRaters("src/data/ratings.csv");
		//1. number of rater
		System.out.println("There are " + raters.size() + " raters in the list.");
		
		//2. rater info
		for(Rater rater : raters) {
			System.out.println("ID: " + rater.getID() + ", " + rater.getItemsRated().size() + " ratings:");
			for(String item : rater.getItemsRated()) {
				System.out.println("   item " + item + " has rating " + rater.getRating(item));
			}
		}
		
		//3. Find the number of ratings of a specified rater (rater_id)
		String raterID = "193";
		Rater temp = null;
		for(Rater rater : raters) {
			if(rater.getID().equals(raterID))
				temp = rater;
		}
		System.out.println("There are " + temp.numRatings() + " ratings of rater " + raterID);
		
		//4. Maximum number of ratings
		int max = 0;
		int count = 0;
		for(Rater rater : raters) {
			if(rater.numRatings() > max)
				max = rater.numRatings();
		}
		
		System.out.println("Maximum: " + max);
		for(Rater rater : raters) {
			if(rater.numRatings() == max) {
				count ++;
				System.out.println(rater.getID() + " has maximum number of ratings, ");
			}
		}
		System.out.println("Total " + count + " raters have maximum ratings number.");
		
		//5. Find number of raters/ratings of certain movie
		String movieID = "1798709";
		count = 0;
		for(Rater rater : raters) {
			for(String item : rater.getItemsRated()) {
				if(item.equals(movieID)) {
					count ++;
					break;
				}
			}
		}
		System.out.println("Movie " + movieID + " has " + count + " ratings.");
		
		//6. Find the number of movies rated by all raters / find the total number of movies being rated
		Set<String> set = new HashSet<>();
		for(Rater rater : raters) {
			for(String item : rater.getItemsRated()) {
				set.add(item);
			}
		}
		System.out.println("Total " + set.size() + " movies are rated.");
	}
}
