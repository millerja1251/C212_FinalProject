import java.util.ArrayList;

/*Jackson Miller
 * jm122
 * Enoch Wang
 * enocwang
 * 4/30/2021
 * FinalPoject
 */

public class User {

	private String name;
	private String username;
	private String password;
	private ArrayList<Ticket> historyOfTickets;
	private ArrayList<Ticket> currentTicket;
	
	
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User() {}
	
	
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public void getCurrentTickets(){
		String ticket = "";
		for(int i = 0; i < currentTicket.size(); i++) {
			ticket = (i + 1) + ". Title: " + currentTicket.get(i).getMovie().getTitle() + " Date: " + currentTicket.get(i).getTime() + 
			" Seat: " + currentTicket.get(i).getSeat() + " Time: " + currentTicket.get(i).getTime();
			
			System.out.println(ticket);
		}
	}

	public void updateHistory(Ticket t){
		//Udpdate the history of the user by adding a ticket and adding it to the list of tickets
		historyOfTickets.add(t);
	}
	
	public void addCurrentTicket(Ticket t) {
		if(currentTicket == null) {
			currentTicket = new ArrayList<Ticket>();
		}
		
		currentTicket.add(t);
	}
	
	public void bookMovie() {
		
	}
	
	public ArrayList<Ticket> getHistory(){
		return historyOfTickets;
	}
	
	public ArrayList<Ticket> getCurrentTicketList(){
		return currentTicket;
	}
	
}

