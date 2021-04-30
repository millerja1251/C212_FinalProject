

/*Jackson Miller
 * jm122
 * Enoch Wang
 * enocwang
 * 4/30/2021
 * FinalPoject
 */

public class Ticket {

	private String date;
	private String seat;
	private String time;
	private Movie movie;
	

	public Ticket(Movie movie, String date, String seat, String time) {
		this.movie = movie;
		this.date = date;
		this.seat = seat;
		this.time = time;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
}
