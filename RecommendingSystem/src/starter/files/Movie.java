package starter.files;

public class Movie {
	
	private String id = null;
	private String title = null;
	private int year = 0;
	private String genres = null;
	private String director = null;
	private String country = null;
	private int minutes = 0;
	private String poster = null;

	public Movie(String id, String title, int year, String genres, 
			String director, String country, int minutes, String poster) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genres = genres;
		this.director = director;
		this.country = country;
		this.minutes = minutes;
		this.poster = poster;
	}
	
	public String toString() {
		return id + " " + title + " " + year + " " + genres + " "
	+ director + " " + country + " " + minutes + " " + poster;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getGenres() {
		return genres;
	}

	public String getDirector() {
		return director;
	}

	public String getCountry() {
		return country;
	}

	public int getMinutes() {
		return minutes;
	}

	public String getPoster() {
		return poster;
	}

}
