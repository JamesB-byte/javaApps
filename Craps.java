import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/*

This is a classic game of craps

*/

public class CrapsGame
{
// global variables
private static int playerBet;
private static int playerMoney = 2000;
private static int number;
private static int firstDice;
private static int secondDice;
private static int point;
private static int diceTotal;
private static int dice;


//Rules of Craps
public static void header(){

	System.out.println("*==========================================================*");
    System.out.println("To start a round, the player makes a come out roll.        *");
	System.out.println("If the come out roll is a 2, 3, or 12, then the round ends.*");
	System.out.println("If the come out roll is a 7 or 11, player wins the bet.    *");
	System.out.println("If the roll is 4, 5, 6, 8, 9, or 10 it becomes the point   *");
	System.out.println("If the point is rolled before rolling 7 or 11,player wins. *");
	System.out.println("*==========================================================*");


}
// Starts by checking if any money is available, if yes, the dice are rolled and betting begins
public static void Starter()
{

	if(CrapsGame.playerMoney <= 0)
	{
	System.out.println("\n");
	System.out.println("Oh, Im sorry. You're all out of money!");
	
	
	Scanner userInput = new Scanner(System.in);
	System.out.println("Do you want to play again? Y/N");
	
	char c = userInput.next().charAt(0);
	
	 if (c == 'y'|| c == 'Y')
	 	{
	 		CrapsGame.playerMoney = 2000;	

	 		CrapsGame.Starter();
	 			 			
	 	}
	 		
	 			
	 else
	 			
	 	{
	 		System.out.println("Thanks for playing!");
	 		System.exit(0);
	 	}		
	}
	
	
	while(CrapsGame.playerMoney > 0)
	{
		CrapsGame.firstDice = diceShuffle();
		CrapsGame.secondDice = diceShuffle();
		CrapsGame.Betting();
		CrapsGame.ComeOut();
	}		
	
		
}

//This generates a random number fore the dice
public static int diceShuffle()
{

           
           Random randomNumber = new Random();
           int diceNumber = randomNumber.nextInt(6-1+1)+1;
           return diceNumber ;  
}


//Betting begins here. 
public static void Betting()
{
	System.out.printf("\n");
	System.out.println("*============*");
    	System.out.printf( "You have $%d \n", CrapsGame.playerMoney);
    	System.out.println( "Minimum: $1  ");
    	System.out.println( "Maximum: None");
    	System.out.println( "*============*");
    	System.out.println( "\n");
    	
    	try
    	{
    		Scanner userInput = new Scanner(System.in);
    	
    	 	System.out.print("How much do you want to bet?" );
    	 	CrapsGame.playerBet = userInput.nextInt();
    	 	if(CrapsGame.playerBet > CrapsGame.playerMoney)
    	 	{
    	 		System.out.println( "");
                System.out.println( "You cant bet more than you have.");
                System.out.println( "Betting maximum amount available");
                CrapsGame.playerBet = CrapsGame.playerMoney;
                   	 		
    	 	}
    	 	   	
    	
    	}
    	catch(Exception e)
    	{
    	System.out.println("Please enter a numeric value.");
    	CrapsGame.Starter();
    	}


}

// This is the come out roll. This will check if the user is a winner, loser or moves to the point method

public static void ComeOut()

{

while(true)
{

	 
	ArrayList<Integer> numBox = new ArrayList<Integer>(Arrays.asList(7,11));
	ArrayList<Integer> numBox2 = new ArrayList<Integer>(Arrays.asList(2,3,12));
	ArrayList<Integer> numBox3 = new ArrayList<Integer>(Arrays.asList(4,5,6,8,9,10));
	
	
	CrapsGame.diceTotal = CrapsGame.firstDice + CrapsGame.secondDice;
	
	System.out.println("Lets Begin!");
	System.out.println("");
	Scanner userInput = new Scanner(System.in);
	System.out.println("Press any button to roll your dice.");
	userInput.nextLine();
	System.out.println("");
	
	System.out.println( "*=================================================*");
        System.out.printf( "Your dice rolls are %d and %d for a total of %d \n" ,CrapsGame.firstDice, CrapsGame.secondDice, CrapsGame.diceTotal);
        System.out.println( "*=================================================*");
	
	if(numBox.contains(CrapsGame.diceTotal))
	{
	    System.out.println("");
            System.out.println( "$$$$$$$$");
            System.out.println( "Winner!$");
            System.out.println( "$$$$$$$$");
            CrapsGame.playerMoney = CrapsGame.playerMoney + (CrapsGame.playerBet* 2);
            CrapsGame.firstDice = 0;
            CrapsGame.secondDice = 0;
            CrapsGame.Starter();            
	}
	else if(numBox2.contains(CrapsGame.diceTotal))
	{
	CrapsGame.playerMoney = CrapsGame.playerMoney - CrapsGame.playerBet;
            System.out.println( "");
            System.out.println( "!!!!!!");
            System.out.println( "Craps!");
            System.out.println( "!!!!!!");
            CrapsGame.Starter();
            
	}
	
	else if(numBox3.contains(CrapsGame.diceTotal))
	{
	CrapsGame.point = CrapsGame.diceTotal;
	if(CrapsGame.point > 0)
	{
	CrapsGame.dicePoints();
	}
	
	
	}

}

}
// If the user doesnt win or lose the user will continue to roll until either the point is made and the user wins or they lose.

public static void dicePoints()
{
    System.out.println( "*==============*");
    System.out.printf( "The point is %d *\n" , CrapsGame.point);
    System.out.println( "*==============*");
    
    while(true)
    {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Hit any button to roll again! ");
    userInput.nextLine();
    
    CrapsGame.firstDice =  CrapsGame.diceShuffle();
    CrapsGame.secondDice = CrapsGame.diceShuffle();
    CrapsGame.diceTotal = CrapsGame.firstDice + CrapsGame.secondDice;
    
    System.out.println( "*=================================================*");
    System.out.printf( "Your dice rolls are %d and %d for a total of %d\n" ,CrapsGame.firstDice, CrapsGame.secondDice, CrapsGame.diceTotal);
    System.out.println( "*=================================================*");
    
    if(CrapsGame.diceTotal == CrapsGame.point)
    {
	    CrapsGame.playerMoney = CrapsGame.playerMoney + CrapsGame.playerBet ;
    	    System.out.println( "$$$$$$$$");
    	    System.out.println( "Winner!$");
    	    System.out.println( "$$$$$$$$");
            CrapsGame.firstDice = 0;
            CrapsGame.secondDice = 0;
            CrapsGame.Starter();
            
    
    }
    
    else if(CrapsGame.diceTotal == 7 || CrapsGame.diceTotal == 11)
    {
    CrapsGame.playerMoney = CrapsGame.playerMoney - CrapsGame.playerBet;
    System.out.println( "");
    System.out.println( "!!!!!!");
    System.out.println( "Craps!");
    System.out.println( "!!!!!!");
    CrapsGame.Starter();
    
    }

    }


}


// main method
public static void main(String args[])

{
CrapsGame.header();
CrapsGame.Starter();


}



}

