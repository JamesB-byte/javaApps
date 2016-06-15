import java.util.Random;


public class Weapons{
//how to create objects 


// define variables
public static int magazineSize;
public static int reloadSpeed;
public static int accuracy;
public static int damage;
public static int fireRate;

String name;


// Class to create a weapon object along with all its attributes
public Weapons(int magazineSize, int reloadSpeed,int accuracy, String name, int damage, int fireRate)

{
this.magazineSize = magazineSize;
this.reloadSpeed = reloadSpeed;
this.accuracy = accuracy;
this.damage = damage;
this.fireRate = fireRate;
this.name = name;

// assign random stats for each item
for(int i = 1; i <10; i++ )

{

Random randomNumber = new Random();
Weapons.magazineSize = randomNumber.nextInt(3000-100);
Weapons.reloadSpeed = randomNumber.nextInt(3000-100);
Weapons.accuracy = randomNumber.nextInt(3000-100);
Weapons.damage = randomNumber.nextInt(3000-100);
Weapons.fireRate = randomNumber.nextInt(3000-100);

}

}



// MAIN CLASS; Print weapon with random stats
public static void main(String[] args)

{

Weapons handgun = new Weapons(magazineSize,reloadSpeed,accuracy, "Colt 45", damage, fireRate);

System.out.printf("Name: %s \n", handgun.name);

System.out.printf("Magazine Size: %d \n", handgun.magazineSize);

System.out.printf("Reload Speed: %d \n", handgun.reloadSpeed);

System.out.printf("Accuracy: %d \n", handgun.accuracy);

System.out.printf("Fire Rate: %d \n", handgun.fireRate);

System.out.printf("Damage: %d \n", handgun.damage);

}

}


