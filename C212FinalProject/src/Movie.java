import java.util.ArrayList;

/*Jackson Miller
 * jm122
 * Enoch Wang
 * enocwang
 * 4/30/2021
 * FinalPoject
 */

public class Movie {
	
	private String genre;
	private String title;
	private ArrayList<Double> ratings;
	private ArrayList<Ticket> listOfTickets;
	private double rating;
	private boolean running;
	
	public Movie(String genre, String title, boolean running) {
		this.genre = genre;
		this.title = title;
		this.rating = -1;
		this.running = running;
		this.listOfTickets = new ArrayList<Ticket>();
	}
	
	public Movie(String genre, String title, double rating) {
		this.genre = genre;
		this.title = title;
		this.rating = rating;
		this.listOfTickets = new ArrayList<Ticket>();
	}
	
	public Movie() {
		this.listOfTickets = new ArrayList<Ticket>();
	}
	
	public boolean getRunning() {
		return running;
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
	
	public void addTicket(Ticket t) {
		listOfTickets.add(t);
	}
	
	public void printTickets() {
		for(int i = 0; i < listOfTickets.size(); i++) {
			String ticketInfo = "Title: " + listOfTickets.get(i).getMovie().getTitle() + " Date: " + listOfTickets.get(i).getTime() + 
					" Seat: " + listOfTickets.get(i).getSeat() + " Time: " + listOfTickets.get(i).getTime();
			System.out.println(ticketInfo);
		}
	}
	
	public void setRating(double userRating) {
		
		if(rating == -1) {
			rating = 0;
		}
		
		ratings.add(userRating);
		
		int total = 0;
		
		for(int i = 0; i < ratings.size(); i++) {
			total += ratings.get(i);
		}
		
		rating = total / ratings.size();
	}
	
	public double getRating() {
		return rating;
	}
	
	public boolean checkRating() {
		if(rating == -1) {
			return false;
		}
		
		return true;
	}
	
	
	
	

}
