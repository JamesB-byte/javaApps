import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;



/* 
Red dog is a card game of chance.

The game only uses three cards at a time, which are ranked as in poker, with aces high. Suit is irrelevant. A wager is placed, and two cards are placed face up on the table, with three possible outcomes:

If the cards are consecutive in number (for example, a four and a five, or a jack and a queen), the hand is a push and the player's wager is returned.
If the two cards are of equal value, a third card is dealt. If the third card is of the same value, then the payout for the player is 11:1, otherwise the hand is a push.
If neither of the above is the case (for example, a three and an eight), then a spread is announced which determines the payoff (a 4-card spread, in this example), and a third card will be dealt. 
Before dealing the third card, the player has the option to double his bet. If the third card's value falls between the first two, the player will receive a payoff according to the spread; otherwise the bet is lost.

*/

public class RedDog{


public static int playerBet;
public static int playerMoney = 2000;

public static String firstCard;
public static String secondCard;
public static String thirdCard;

public static String firstSuit;
public static String secondSuit;
public static String thirdSuit;

public static int FirstCardINT;
public static int SecondCardINT;
public static int ThirdCardINT;

static String[] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
static String[] RoyalFam = {"Ace","2","3","4","5","6","7","8","9","10", "Jack", "Queen","King"};



// This function sets up the main game
private static void mainProgram()
{
drawCard();
playerBet = betting();

currentStanding();

playerBet = doubleBet();


}

//  Draw a card 
private static void drawCard()
{

firstCard = NumCard();
secondCard = NumCard();
firstSuit = SuitCard();
secondSuit = SuitCard();
thirdCard = NumCard();
thirdSuit = SuitCard();

}

//randomly select card from Ace - King
private static String NumCard()

{

String number;
 
Random randomNumber = new Random();

int x = randomNumber.nextInt(13);
number = RoyalFam[x];
return number;
}



// Apply a suit to that card 
private static String SuitCard()
{
String suit;
 
Random randomNumber = new Random();

int x = randomNumber.nextInt(4);
suit = Suits[x];
return suit;


}



//player betting
private static int betting() 

{

System.out.println( "\n");
System.out.println("*============*");
System.out.printf("You have $%d \n",  playerMoney);
System.out.println( "Minimum: $1 ");
System.out.println( "Maximum: None");
System.out.println("*============*");
System.out.println("\n");


try
{
Scanner userInput = new Scanner(System.in);

System.out.println("How much do you want to bet?");

int betting = userInput.nextInt();

	if (betting > playerMoney)
	{
	System.out.println("");
	System.out.println("You cant bet more than you have.");
	System.out.println("Betting maximum amount available.");
	return playerMoney;

	}

return betting;

}
catch (Exception e)
    	{
    	System.out.println("Please enter a numeric value.");
    	betting();
    	}
return playerMoney;

}

private static void currentStanding()

{
	FirstCardINT = Arrays.asList(RoyalFam).indexOf(firstCard ) + 1;
	SecondCardINT = Arrays.asList(RoyalFam).indexOf(secondCard) + 1;
        ThirdCardINT = Arrays.asList(RoyalFam).indexOf(thirdCard) + 1;
	
	
	System.out.println("\n");
	System.out.println("    Current standings");
	System.out.println ("*==========================*");
	System.out.printf ("      Your bet: $%d       \n" , playerBet);
	System.out.println ("*==========================*");
	System.out.printf ("   First draw: %s of %s    \n" , firstCard, firstSuit);
	System.out.printf ("  Second draw: %s of %s   \n " , secondCard, secondSuit);
	System.out.println ("*==========================*");

	if (SecondCardINT == FirstCardINT - 1)
		{
	    System.out.printf( "\n");
	    System.out.println ("*-----------*");
	    System.out.println ("*  PUSH!    *");
	    System.out.println ("* New round *");
	    System.out.println ("*-----------*");
	    mainProgram();
	   }
	   
	 else if (SecondCardINT == FirstCardINT + 1)
		{
	    System.out.printf( "\n");
	    System.out.println ("*-----------*");
	    System.out.println ("*  PUSH!    *");
	    System.out.println ("* New round *");
	    System.out.println ("*-----------*");
	    mainProgram();
	   }
	

}


// Ask the user of they want to double their bet

private static int doubleBet()
{

Scanner userInput =  new Scanner(System.in);

System.out.println("Do you want to double your bet? Y/N ");
	try {
	char c = userInput.next().charAt(0);
	
	 if (c == 'y'|| c == 'Y')
	 	{
	 	  playerBet = playerBet *2;	
	 	   if (playerBet > playerMoney)
	 		{
	 	
	
			System.out.println("");
			System.out.println("You cant bet more than you have.");
			System.out.println("Betting maximum amount available.");
			return playerMoney;
			}
	 	  }
	 	  
	else if (c == 'n'|| c == 'N')
	 		{
	 			return playerBet;
	 			
	 		}

	 	
	
}
catch (Exception e)
    	{
    	System.out.println("Please enter Y or N.");
    	doubleBet();
    	}
    	return playerBet;
}


public static void main(String args[])

{

    System.out.println("**********************************************************************");
    System.out.println("Place your bet and dealer places two cards on the table face up.");
    System.out.println( "");
    System.out.println("A third card is dealt.");
    System.out.println("If it falls between the first two cards the player WINS according to spread.");
    System.out.println( "If the two cards are consecutive then the hand is a push.");
    System.out.println("Any matching of 3 wins the Jackpot 11:1");
    System.out.println("");
    System.out.println("*This game uses multiple decks*");
    System.out.println( " ");
    System.out.println( "Spread | Payout");
    System.out.println("---------------|");
    System.out.println("1 card | 5 to 1|");
    System.out.println("2 card | 4 to 1|");
    System.out.println( "3 card | 2 to 1|");
    System.out.println("4+ card| 1 to 1|");
    System.out.println( "----------------");
    System.out.println("**********************************************************************");
    
while (playerMoney > 0)
{
	mainProgram();
	System.out.println("The last card has been drawn.");
	System.out.println("Press any key to view last card.");

	Scanner userInput = new Scanner(System.in);

	userInput.nextLine();

	System.out.println("Your last card is " + thirdCard);
}



 
}


}

