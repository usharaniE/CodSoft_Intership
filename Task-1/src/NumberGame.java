
import java.util.Scanner;
import java.util.Random;
//////////////////////////////////////////////////////////////////////////////
//                                                                           
// Class name: NumberGame
// Description: This class implements a simple number guessing game.
//              The player tries to guess a randomly generated number
//              within a specified range. The game provides hints and 
//              tracks the number of attempts and total score. 
//
/////////////////////////////////////////////////////////////////////////////

public class NumberGame {
   //Entry point function
    public static void main(String[] args)  {
       Scanner sc=new Scanner(System.in);
       Random random=new Random();
         
       int minRange = 1;
       int maxRange = 100;
       int totalRounds = 3; // no.of rounds to play
       int maxAttempts =10 ; //max no of attemps per round
       int totalScore = 0;

       //ANSI escape codes are used to change the text colors in the console output
       // Here a brief explanation of ANSI escape codes 
       // - "\u001B[32m":sets the Text color into Green. 
       // - "\u001B[33m":sets the Text color into yellow.
       // - "\u001B[31m" :sets the Text color into red.
       // - "\u001B[0m" :sets the Text color into a default.


       //Display welcome Message in green color text
   
       System.out.println("\u001B[32m*****************************************\u001B[0m");
       System.out.println("\u001B[32m   Welcome to the Guess the Number Game *\u001B[0m");
       System.out.println("\u001B[32m     Can u guess the secret number?     *\u001B[0m");   
       System.out.println("\u001B[32m*****************************************\u001B[0m");
       
       
       //Loop through the rounds
        for(int round = 1; round <= totalRounds; round++){
            int secretNumber = random.nextInt(maxRange -minRange + 1)+ minRange;
            int attempts = 0;

            //Allow the player to guessthe number within the limited no of attemps

            while(attempts < maxAttempts){
                //User input and  change the text color into yellow
                System.out.println("\u001B[33m* Round " + round +" - Attempt" +(attempts + 1) + "/" + maxAttempts +"Enter your guess : \u001B[0m");
                int guess =sc.nextInt();
                attempts++;

                //check if guess is correct , Too high (or) Too low
                if(guess == secretNumber){
                    
                    System.out.println("\u001B[32m* Congratulations! you Guessed the number in " + attempts+ " attempts. *\u001B[0m*");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                
                }
                else if(guess < secretNumber){
                    //Display hint mesg in red color text
                    System.out.println("\u001B[31m* Higher! Try again");
                }
                else {
                    //Display hint mesg in red color text
                    System.out.println("\u001B[31m* Lower! Try again");
                }
            }
            // Check if the player has run out of attempts
            if(round < totalRounds) {
                //User input and  change the text color into yellow
                System.out.println("\u001B[33m* Do You want to paly the next round? (yes/no): \u001B[0m*");
                String playAgain =sc.next().toLowerCase();
                if(!playAgain.equals("yes")){
                    break;
                }
            }
        }
        //Display the mesg game over and total score in Green color text
        System.out.println("\u001B[32m*****************************************\u001B[0m");
        System.out.println("\u001B[32m   Game Over                            *\u001B[0m");
        System.out.println("\u001B[32m     Total Score: "+totalScore+ "         *\u001B[0m");   
        System.out.println("\u001B[32m*****************************************\u001B[0m");

        //Close the Scanner
        sc.close();
            }




            }
        
    

