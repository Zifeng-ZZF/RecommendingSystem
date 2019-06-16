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

	public Movie(String id, String title, String year, String genres, 
			String director, String country, String minutes, String poster) {
		this.id = id.trim();
		this.title = title.trim();
		this.year = Integer.parseInt(year.trim());
		this.genres = genres;
		this.director = director;
		this.country = country;
		this.minutes = Integer.parseInt(minutes.trim());
		this.poster = poster;
	}
	
	public String toString() {
		return "Movie [" + "id=" + id + ", " + "title=" + title + ", " + "year=" + year + ", " + "genres=" + genres + ", "
	+ "director=" + director + ", " + "country=" + country + ", " + "minutes=" + minutes + ", " + "poster=" + poster +"]";
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
