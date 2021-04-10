
public class Ticket {

	private String date;
	private String seat;
	private String time;
	

	public Ticket(String date, String seat, String time) {
		super();
		this.date = date;
		this.seat = seat;
		this.time = time;
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
