
public class Movie {
	
	private String genre;
	private String title;
	private String releaseDate;
	
	public Movie(String genre, String title, String releaseDate) {
		this.genre = genre;
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
	

}
