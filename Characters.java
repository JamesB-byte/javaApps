import java.util.Scanner;
import java.util.Random;


/*
I really enjoy classic RPG's. 
While learning how classes work I decided to write a program that createes characters for a RPG.
Its a simple program but I was able to understand how classes workt in Java.

This program will ask the user for their name, race and class. Then it will randomly generate stats for them. 

*/



public class Characters

{

//List of variables

public static String userName, userRace, userClass;
public static int userStr, userDex,userCon, userInt,userWis,userChar;

// Setup for object of Characters
public Characters(String userName, String userRace, String userClass, int userChar, int userWis, int userInt, int userCon, int userDex, int userStr)

{
	Random randomNumber = new Random();
	
	this.userName = userName;
	this.userRace = userRace;
	this.userClass = userClass;	
	this.userChar = userChar;
    this.userWis = userWis;
	this.userInt = userInt;
	this.userCon = userCon;
	this.userDex = userDex;
	this.userStr = userStr; 
	
	for(int i = 2; i < 15; i ++ )
		
	{
	Characters.userStr = randomNumber.nextInt(i);
	Characters.userDex = randomNumber.nextInt(i);
	Characters.userCon = randomNumber.nextInt(i);
	Characters.userInt = randomNumber.nextInt(i);
	Characters.userWis = randomNumber.nextInt(i);
	Characters.userChar = randomNumber.nextInt(i);
	
	}
}


//select your characters name
public static String selectName()

{


Scanner charName = new Scanner(System.in);
System.out.println("Enter your name: ");
userName = charName.next();
return userName;


}
///USERS SELECT THEIR RACE

public static String selectRace()

{
Scanner charRace = new Scanner(System.in);

System.out.println("");
System.out.println("Please select your race.");
System.out.println("");
System.out.println("1. Elf");
System.out.println("2. Human");
System.out.println("3. Dwarf");
System.out.println("");

userRace = charRace.next();

switch(userRace)
{

case "1":
userRace = "Elf";
return userRace;


case "2":
userRace = "Human";
return userRace;


case "3":
userRace = "Dwarf";
return userRace;


default:
System.out.println("Unknown Selection");
selectRace();

}

return userRace;

}

// USERS SELECT THEIR CLASS 

public static String selectClass()

{
Scanner charClass= new Scanner(System.in);

System.out.println("");
System.out.println("Please select your class.");
System.out.println("");
System.out.println("1. Warrior");
System.out.println("2. Rogue");
System.out.println("3. Mage");
System.out.println("");

userClass = charClass.next();

switch(userClass)
{

case "1":
userClass = "Warrior";
return userClass;


case "2":
userClass = "Rogue";
return userClass;


case "3":
userClass = "Mage";
return userClass;


default:
System.out.println("Unknown Selecion");
selectClass();

}

return userClass;
}

//main class 
public static void main(String[] args){

selectName();
selectRace();
selectClass();



Characters playerOne = new Characters( userName, userRace, userClass, userStr, userDex, userWis,  userChar, userInt, userChar);

System.out.printf("Name: %s \n", playerOne.userName); 
System.out.printf("Race: %s \n", playerOne.userRace);
System.out.println("");

System.out.println("Stats \n");
System.out.println("**********");
System.out.printf("Strength: %d \n", playerOne.userStr);
System.out.printf("Dexterity: %d \n", playerOne.userDex);
System.out.printf("Wisdom: %d \n", playerOne.userWis);
System.out.printf("Charisma: %d \n", playerOne.userChar);
System.out.printf("Intelligence: %d \n", playerOne.userInt);


}

}













