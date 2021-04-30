import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Jackson Miller
 * jm122
 * Enoch Wang
 * enocwang
 * 4/30/2021
 * FinalPoject
 */

public class MovieBookingClient {

	//Have a main method that has a while loop which keeps a menu up depending on 
	//whether the user or admin is selected
	
	public static void main(String[] args) {
		
		//Need to read in all of the files and allocate the information to the instance variables
		
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		ArrayList<User> users = new ArrayList<User>();
		Map<String, String> userInfo = new HashMap<String, String>();
		
		
		File userFile = new File("users.txt");
		
		try {
			Scanner userScanner = new Scanner(userFile);
			
			while (userScanner.hasNextLine()) {
				String line = userScanner.nextLine();
				String[] info = line.split(" ");
				
				User previousUser = new User(info[0] , info[1], info[2]);
				users.add(previousUser);
				
				userInfo.put(info[1], info[2]);
			}
			
			userScanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File movies = new File("movies.txt");
		
		try {
			Scanner moviesScanner = new Scanner(movies);
			
			while (moviesScanner.hasNextLine()) {
				String line = moviesScanner.nextLine();
				String[] info = line.split(" ");
				
				double rating = Double.valueOf(info[2]);
				
				Movie previousMovie = new Movie(info[0], info[1], rating);
				movieList.add(previousMovie);
				
			}
			
			moviesScanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the movie theater booking system");
		System.out.println("Please enter whether you are an Admin or a User:");
		
		String userSelection = scan.nextLine();
		
		if(userSelection.equals("Admin")) {
			
			System.out.println("Please enter the admin username and password:");
			
			System.out.println("Username: ");
			String username = scan.nextLine();
			System.out.println("Password: ");
			String password = scan.nextLine();
			
			Admin adminUser = new Admin();
			
			if(username.equals(adminUser.getUsername()) && password.equals(adminUser.getPassword())) {
				System.out.println("Welcom Admin");
				System.out.println();
				
				int option = 0;
				
				while(option != 3) {
					System.out.println("Please select an option: ");
					System.out.println("1. Post new movie");
					System.out.println("2. Edit details of a movie");
					System.out.println("3. Sign out");
					
					option = scan.nextInt();
					
					if(option == 1) {
						System.out.println("What is the name of the movie: ");
						String movieName = scan.next();
						System.out.println("What is the genre of the movie");
						String movieGenre = scan.next();
						System.out.println("Is the movie currently running? True/False");
						String movieRunningString = scan.next();
						
						boolean movieRunning = false;
						if(movieRunningString.equals("True")) {
							movieRunning = true;
						}
						
						Movie newMovie = new Movie(movieGenre, movieName, movieRunning);
						
						movieList.add(newMovie);
						
						System.out.println("The movie has been added!");
					}
					
					if(option == 2) {
						System.out.println("Here are the list of current movies: ");
						for(int i = 0; i < movieList.size(); i++) {
							System.out.println("Title: " + movieList.get(i).getTitle() + " Genre: " + movieList.get(i).getGenre());
						}
						
						System.out.println("Pick a movie that you would like to see the tickets for: ");
						String choice = scan.next();
						
						for(int i = 0; i < movieList.size(); i++) {
							if(choice.equals(movieList.get(i).getTitle())) {
								movieList.get(i).printTickets();
							}
						}
						
						System.out.println("Do you want to delete a movie? Yes/No");
						String deleteChoice = scan.next();
						
						if(deleteChoice.equals("Yes")) {
							System.out.println("What is the name of the movie that you would like to delete: ");
							String movie = scan.next();
							
							for(int i = 0; i < movieList.size(); i++) {
								if(movieList.get(i).getTitle().equals(movie)) {
									
									if(movieList.get(i).getRunning() == false) {
										movieList.remove(i);
										System.out.println("The movie has been removed!");
									}
									else {
										System.out.println("The movie is currently running you cannot remove it");
									}
								}
							}
						}
						
					}
					
				}
				
				if(option == 3) {
					
					System.out.print("You have successfully been logged out!");
				}
				
			}
			
		}
		
		if(userSelection.equals("User")) {
			
			System.out.println("Do you already have an account with the Movie Booking System?");
			System.out.println("Yes or No");
			String answer = scan.nextLine();
			
			if(answer.equals("Yes")) {
				System.out.println("Please enter your username and password");
				System.out.println("Username:");
				String userUsername = scan.nextLine();
				System.out.println("Password:");
				String userPassword = scan.nextLine();
				
				User currentUser = new User();
				
				for(int i = 0; i < users.size(); i++) {
					if(users.get(i).getUsername() == userUsername ) {
						currentUser = users.get(i);
					}
				}
				
				if(userInfo.containsKey(userUsername) && (userInfo.containsValue(userPassword))) {
					
					int option = 0;
					
					while(option != 4) {
						
						System.out.println("Welcom user what would you like to do today");
						System.out.println("1. View my history");
						System.out.println("2. Browse movies");
						System.out.println("3. View Tickets");
						System.out.println("4. Sign Out");
						System.out.println("5. Delete Account");
						System.out.println("Please select an option: ");
						System.out.println();
						
						option = scan.nextInt();
						
						if(option == 1) {
							System.out.println("Here is the history of movies you have watched: ");
							
							ArrayList<Ticket> history = currentUser.getHistory();
							
							if(history == null) {
								System.out.println("You don't have a history go purchase a ticke and watch a movie to have one");
							}
							else {
								for(int i = 0; i < history.size(); i ++) {
									String ticketInfo = "Title: " + history.get(i).getMovie().getTitle() + " Date: " + history.get(i).getTime() + 
											" Seat: " + history.get(i).getSeat() + " Time: " + history.get(i).getTime();
									System.out.println(ticketInfo);
								}
								
								System.out.println("Do you want to rate a previous movie that you have watched? Yes/No");
								String choice = scan.next();
								
								if(choice.equals("Yes")) {
									System.out.println("Please enter the title of the movie that you want to rate: ");
									String name = scan.next();
									
									for(int i = 0; i < movieList.size(); i++) {
										if(movieList.get(i).getTitle().equals(name)) {
											System.out.println("Please enter a rating for the movie: ");
											double userRating = scan.nextDouble();
											movieList.get(i).setRating(userRating);
											System.out.println("You just rated " + movieList.get(i).getTitle() + " a " + userRating);
										}
									}
								}
							}
							
							System.out.println("Have you watched the any of the previouse movies before?");
							currentUser.getCurrentTickets();
							
							int choiceTwo = scan.nextInt();
							
							for(int i = 0 ; i < currentUser.getCurrentTicketList().size(); i++) {
								if(i == choiceTwo) {
									currentUser.getCurrentTicketList().remove(i);
									currentUser.getHistory().add(currentUser.getCurrentTicketList().get(i));
								}
							}
						}
						
						if(option == 2) {
							
							System.out.println("Here are the list of all the movies available: ");
							for(int i = 0; i < movieList.size(); i++) {
								if(movieList.get(i).checkRating()) {
									System.out.println(movieList.get(i).getTitle() + " Rating: " + movieList.get(i).getRating());
								}
								else {
									System.out.println(movieList.get(i).getTitle() + " Rating : No Ratings Available");
								}
							}
							
							System.out.println("Do you want to search through the movies? Yes/No");
							String choiceOne = scan.next();
							
							if(choiceOne.equals("Yes")) {
								System.out.println("What do you want to search by?");
								System.out.println("1. Title");
								System.out.println("2. Genre");
								System.out.println("3. Rating");
								int choiceTwo = scan.nextInt();
								
								if(choiceTwo == 1) {
									System.out.println("Please enter a title: ");
									String title = scan.next();
									
									System.out.println("Here are the list of movies with the Title: " + title);
									for(int i = 0; i < movieList.size(); i++) {
										if(movieList.get(i).getTitle().contains(title)) {
											System.out.println(movieList.get(i).getTitle());
										}
									}
								}
								
								if(choiceTwo == 2) {
									System.out.println("Please enter a Genre: ");
									String genre = scan.next();
									
									System.out.println("Here are the list of movies with the Genre: " + genre);
									for(int i = 0; i < movieList.size(); i++) {
										if(movieList.get(i).getGenre().contains(genre)) {
											System.out.println(movieList.get(i).getGenre());
										}
									}
								}
								
								if(choiceTwo == 3) {
									System.out.println("Enter a minimun Rating: ");
									double rating = scan.nextDouble();
									
									for(int i = 0; i < movieList.size(); i++) {
										if(movieList.get(i).getRating() >= rating) {
											System.out.println(movieList.get(i).getTitle());
										}
									}
								}
								
								System.out.println("Would you like to purchase a ticket for a movie? Yes/No");
								String choice = scan.next();
								
								if(choice.equals("Yes")) {
									System.out.println("Enter the name of the movie:");
									String string = scan.next();
									
									for(int i = 0; i < movieList.size(); i++) {
										if(movieList.get(i).getTitle().equals(string)) {
											System.out.println("Please enter the seat number that you want in the genaric form 1A");
											String seat = scan.next();
											System.out.println("Please enter the date you want the ticket: ");
											String date = scan.next();
											System.out.println("Please enter the time you want to see the movie: ");
											String time = scan.next();
											
											Ticket newTicket = new Ticket(movieList.get(i), seat, date, time);
											currentUser.addCurrentTicket(newTicket);
											movieList.get(i).addTicket(newTicket);
										}
									}
										
								}
								else {
									System.out.println("Too bad to hear :(");
								}
							}
							
						}
						
						if(option == 3) {
							
							ArrayList<Ticket> currentTickets = currentUser.getCurrentTicketList();
							
							System.out.println("Here are your current tickets");
							
							for(int i = 0; i < currentTickets.size(); i++) {
								String ticketInfo = "Title: " + currentTickets.get(i).getMovie().getTitle() + " Date: " + currentTickets.get(i).getTime() + 
										" Seat: " + currentTickets.get(i).getSeat() + " Time: " + currentTickets.get(i).getTime();
								System.out.println(ticketInfo);
							}
							
						}
						
						if(option == 5) {
							
							for(int i = 0; i < users.size(); i++) {
								if(users.get(i).getUsername().equals(userUsername)) {
									System.out.println(users.get(i).getUsername());
									users.remove(i);
								}
							}
						}
						
					}
					
					if(option == 4) {
						System.out.println("You have been succesfully logged out!");
					}
					
				}
				
			}
			
			if(answer.equals("No")) {
				
				System.out.println("Would you like to create an account Yes/No: ");
				String decision = scan.next();
				
				if(decision.equals("Yes")) {
					
					System.out.println("Please enter your name: ");
					String name = scan.next();
					
					System.out.println("Please enter a username: ");
					String username = scan.next();
					
					if(userInfo.containsKey(username)) {
						System.out.println("Please enter a different username: ");
						username = scan.next();
					}
					
					System.out.println("Please enter a password:");
					String passwordOne = scan.next();
					System.out.println("Please enter the passowrd again to confirm: ");
					String passwordTwo = scan.next();
					
					if(passwordOne.equals(passwordTwo)) {
						System.out.println("Thank you your account has been created please go back to sign in");
						userInfo.put(username, passwordTwo);
						User newUser = new User(name, username, passwordTwo);
						users.add(newUser);
					}
					
				}
				
				if(decision.equals("No")) {
					System.out.println("Thank you for using the movie booking system hope you will come back!");
				}
			}
			
		}
		
		try {
			PrintWriter writer = new PrintWriter("users.txt");
			for(int i = 0; i < users.size(); i++) {
				writer.println(users.get(i).getName() + " " + users.get(i).getUsername() + " " + users.get(i).getPassword());
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PrintWriter writerTwo = new PrintWriter("movies.txt");
			
			for(int i = 0; i < movieList.size(); i++) {
				writerTwo.println(movieList.get(i).getGenre() + " " + movieList.get(i).getTitle() + " " + movieList.get(i).getRating());
			}
			
			writerTwo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
		
	}
	
}
