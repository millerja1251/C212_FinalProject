import java.util.ArrayList;

public class User {

	private String name;
	private String username;
	private String password;
	private ArrayList<Ticket> historyOfTickets;
	
	
	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public void updateHistory(Ticket t){
		//Udpdate the history of the user by adding a ticket and adding it to the list of tickets
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Rates a movie
	public void rateMovie(Movie m, double rating) {
		
	}
	
	public void bookMovie() {
		
	}
	
	public ArrayList<Ticket> getHistory(){
		return historyOfTickets;
	}
}
