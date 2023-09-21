/** -----------------------------------------------------
*Assignment 1
* Question: part II
* Written by: ibrahim daami 40155608
* -----------------------------------------------------
*/
import java.util.Scanner;
public class playLadderAndSnake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int p;
     System.out.println("Enter the # of players for your game – Number must be between 2 and 4 inclusively:");
     Scanner keyboard =new Scanner(System.in);
     p = keyboard.nextInt();
     boolean ok = false;
     int attempts = 0;
     if(p<2||p>4) {
    	 do {
    		 attempts++;
    		 System.out.println("Bad Attempt "+ attempts+" - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
    		 p = keyboard.nextInt();
    		 if(attempts == 3) {
        		 System.out.println("Bad Attempt 4! You have exhausted all your chances. Program will terminate! ");
        		 System.exit(0);
        	 }
    	 }while(p<2||p>4);
    	
     }
     LadderAndSnake game = new LadderAndSnake(p);
     game.play();
	
	
	
	}

}
