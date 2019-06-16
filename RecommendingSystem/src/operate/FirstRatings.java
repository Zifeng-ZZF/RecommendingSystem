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
		ArrayList<Movie> arrayList = loadMovies("src/data/ratedmovies_short.csv");
		
		//1. number of movies
		System.out.println("There are " + arrayList.size() + "movies in the list.");
		
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
				if(genre.equals("Comedy"))
					count ++;
			}
		}
		System.out.println("There are " + count + " comedy movie(s).");
		
		//4. Movie greater than 150 mins
		
		//5. Maximum of movies by any director
	}
	
	public ArrayList<Rater> loadRaters(String filename) {
		return null;
	}
	
	public void testLoadRaters() {
		
	}
}
