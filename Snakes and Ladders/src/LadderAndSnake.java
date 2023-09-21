/** -----------------------------------------------------
*Assignment 1
* Question: part I
* Written by: ibrahim daami 40155608
* -----------------------------------------------------
*/
import java.util.Scanner;
public class LadderAndSnake {
//this is a program that simulates the snakes and ladders game
//attributes
	private static String[][] board = new String[11][11];
	private int numplayers;
	
//constructor
	public LadderAndSnake(int p) {
		numplayers = p;
	}
//default constructor
	public LadderAndSnake() {
		
	}
//Mutator method
	public void setNumberOfPlayers(int p) {
		numplayers = p;
	}
//Accessor method
	public int getNumberOfPlayers() {
		return numplayers;
	}
//Method that will simulate the rolling of a dice, used later on
	public int flipDice() {
		return (int) ((Math.random() * (6 - 1)) + 1);
	}
//Engine of the game
	public void play() {
//Making sure we don't get needless errors
		if (numplayers <= 1)
				System.out.println("nope");
		else {
	//Initial array to store the players in
		String[] players = new 	String[numplayers];
		//Array to store the deciding scores
		int[] scores = new int[numplayers] ;
	//final array used to store the players
		String[] order = new String[numplayers];
	//Welcome message
		System.out.println("Hello and welcome to a Ladder and snakes simulator designed by Ibrahim Daami\n\n");
		System.out.println("Game is played by " + numplayers + " players");
		System.out.println("Now deciding which player will start");
	//Storing the players in the initial array
		Scanner keyboard =new Scanner(System.in); 
		for (int i=0;i<numplayers;i++) {
			System.out.print("Please enter your name: ");
			 
			players[i] = keyboard.next();
			scores[i] = flipDice();
			System.out.println(players[i]+" got a dice value of " + scores[i]);
		}
	//Now to order the players in descending order while not taking into account any ties 	
		for(int i = 0; i<scores.length;i++) {
			for(int j = i+1; j<scores.length;j++) {
				
				if(scores[i]<=scores[j]) {
				
					String a = players[i];
					players[i] = players[j];
					players[j] = a;
					int o = scores[i];
					scores[i] = scores[j];
					scores[j] = o;
				}
			}
		
		}
	//Now Ordering the the players and solving any ties and storing them in the final order array that will be used 
		boolean dr = false;
		for(int i = 0; i<scores.length;i++) {
			for(int j = i+1; j<scores.length;j++) {
				if (scores[i]==scores[j]) {
				do {
					System.out.println("A tie was achieved between " + players[i] + " and "+players[j]+ ". Attempting to break the tie:");
					scores[i] = flipDice();
					System.out.println("Player " + i +" got a dice value of " + scores[i]);
					scores[j] = flipDice();
					System.out.println("Player " + j +" got a dice value of " + scores[j]);
					
					if (scores[i] != scores[j])
						dr = true;
				}while(!dr);
				}
				if(scores[i]<scores[j]) {
					String a = players[i];
					players[i] = players[j];
					players[j] = a;
					int o = scores[i];
					scores[i] = scores[j];
					scores[j] = o;
				}
			}
		}
		System.out.print("Reached final decision on order of playing: ");
		for (int i = 0;i<scores.length;i++) {
			order[i] = players[i];
			System.out.print(order[i] + "\t");
		}
		//a is going to be the value each player rolled, evidently it'll be reset to 0 after each turn
			int a = 0;
		//pos is the array that will determine where exactly each player is on the 2d array/board	
			int[] pos = new int[numplayers];
			boolean game = false;
			while(!game) {
				for(int i = 0; i<order.length;i++) {
				a = flipDice();	
				
				pos[i] += a;
		 //all cases on the first line will be sorted here
				if (pos[i]<=10) {
					board[0][pos[i]] = order[i];
					System.out.println("\n"+order[i] + " got a dice value of " + a + ", now in square" + pos[i]);
				}
		//the rest of the cases will be sorted here		
				if (pos[i]>10 && pos[i]<100) {
					board[pos[i]/10][pos[i]%10] = order[i];
					System.out.println(order[i] + " got a dice value of " + a + ", now in square" + pos[i]);
				}
		//the next statements will be concerning the snake and ladder parts		
				if(pos[i]==1) {
					board[3][8] = order[i];
					pos[i]=38;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 1 then up to square 38");
				}
				if(pos[i]==4) {
					board[1][4] = order[i];
					pos[i] = 14;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 4 then up to square 14");
				}
				if(pos[i]==9) {
					board[3][1] = order[i];
					pos[i] = 31;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 9 then up to square 31");
				}
				if(pos[i]==16) {
					board[0][6] = order[i];
					pos[i] = 6;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 16 then down to square 6");
				}
				if(pos[i]==28) {
					board[8][4] = order[i];
					pos[i] = 84;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 28 then up to square 84");
				}
				if(pos[i]==21) {
					board[4][2] = order[i];
					pos[i] = 42;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 21 then up to square 42");
				}
				if(pos[i]==36) {
					board[4][4] = order[i];
					pos[i] = 44;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 9 then up to square 31");
				}
				if(pos[i]==48) {
					board[3][0] = order[i];
					pos[i] = 30;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 48 then down to square 30");
				}
				if(pos[i]==51) {
					board[6][7] = order[i];
					pos[i] = 67;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 51 then up to square 67");
				}
				if(pos[i]==64) {
					board[6][0] = order[i];
					pos[i] = 60;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 64 then down to square 60");
				}
				if(pos[i]==71) {
					board[9][1] = order[i];
					pos[i] = 91;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 71 then up to square 91");
				}
			//Square 80 is a special case where the player wins	
				if(pos[i] == 80 ) {
					System.out.println(order[i]+" won the game!\nThank you for playing, closing the game");
					System.exit(0);
					game = true;
				}
				if(pos[i]==93) {
					board[6][8] = order[i];
					pos[i] = 68;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 93 then down to square 68");
				}
				if(pos[i]==95) {
					board[2][4] = order[i];
					pos[i] = 24;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 95 then down to square 24");
				}
				if(pos[i]==97) {
					board[7][6] = order[i];
					pos[i] = 76;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 97 then down to square 76");
				}
				if(pos[i]==98) {
					board[7][8] = order[i];
					pos[i] = 78;
					System.out.println(order[i] + " got a dice value of "+ a + ", gone to square 98 then down to square 78");
				}
			//This how you're supposed to win, by getting EXACTLY 100	
				if(pos[i]==100) {
					System.out.println(order[i]+" won the game!\nThank you for playing, closing the game");
					System.exit(0);
					game = true;
				}
			//Added little details to the message if the player rebounded back to a square with a snake	
				if(pos[i]>100) {
					pos[i]=pos[i]-(pos[i]-100);
					board[pos[i]/10][pos[i]%10] = order[i];
					if(pos[i]==93) {
						board[6][8] = order[i];
						pos[i] = 68;
						System.out.println(order[i] + " got a dice value of "+ a + ", gone back to square 93 then down to square 68");
					}
					if(pos[i]==95) {
						board[2][4] = order[i];
						pos[i] = 24;
						System.out.println(order[i] + " got a dice value of "+ a + ", gone back to square 95 then down to square 24");
					}
					if(pos[i]==97) {
						board[7][6] = order[i];
						pos[i] = 76;
						System.out.println(order[i] + " got a dice value of "+ a + ", gone back to square 97 then down to square 76");
					}
					if(pos[i]==98) {
						board[7][8] = order[i];
						pos[i] = 78;
						System.out.println(order[i] + " got a dice value of "+ a + ", gone back to square 98 then down to square 78");
					}
					else
				//All none special squares will go as usual		
						System.out.println(order[i] + " got a dice value of " + a + ", now in square" + pos[i]);
						
				}
				
				
				
				
				
				
				
				}
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
