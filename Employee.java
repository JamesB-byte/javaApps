
// Imported scanner for user input
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/* Week 4 Salary comparison program - By James

This program calculates the users salary bonus based of the number 
of sales they entered then prints the output. 
Afterwards it compares their sales with the sales of a coworker.
 */


// Employee Class created 
public class Employee {
      
    // List of global variables 
     private static double salary = 50000;
     public static double sales = 0 ;
     public static int targetSales = 125000;
     public static double incentive = .05 * sales;
     public static double targetGoal = .8 * targetSales;
     public static double[] employeeSales; 
     final static String name = "Johnson" ;
     final static String nameToo = "James";
     
     
     
//Beginning of incentive chart     
 public static void bonusChart()
 
 {
       
          System.out.printf("Incentive Chart\n");
          System.out.printf("*-------------------------*\n");
          System.out.printf("*    Sales : Bonus        *\n");
          System.out.printf("*-------------------------*\n");
          
          
          //  basic variables used to generate numbers to create chart
          double x = targetSales * .8;
          
          double y = x * .05;
          
          
          for(int i = 1; i <36; i = i+=2 )
          {
                     
          System.out.printf("$%.2f : $%.2f\n",x,y);
          
          if(x < targetSales)
          {
          
          x = x + 5000;
          y = x * .05;
          }
          else 
          {
          x = x + 5000;
          y = x * .1;
          }
          
          
          }
          
          System.out.printf("*-------------------------*\n");     
       // End of incentive chart 
       getAnnualSales();
     
 }
 
 
 //// Ask user to enter their annual sales AND update incentive amount based on sales

 public static void getAnnualSales()
 
 {
     
      Scanner annualSales = new Scanner(System.in);
     
          System.out.print("Enter your annual sales? \n");
          Employee.sales = Employee.sales + annualSales.nextInt();
          
     
          Employee.incentive = .05 * Employee.sales;
          annualSales.close();
          checkSales();
          
          
     
 }
 
 // This method checks the employee sales to see if they meet requirement for bonus
 public static void checkSales()

 {
     
          
         // Sales must be minimum 80% of target goal not to exceed 100% of target goal to get incentive 
         if(Employee.sales >= targetSales * .8 && Employee.sales <= targetSales)
         
         {
         System.out.printf("Total sales:$%.2f \n" ,Employee.sales);
         Employee.salary = Employee.salary + Employee.incentive;
         System.out.println("Total incentive: " + incentive);
         }
         
         //If sales are greater than the target goal the incentive is increased not to exceed 50% of target goal
                  
         else if (Employee.sales > targetSales && Employee.sales < targetSales + (targetSales * .5) )
         
         {
             System.out.printf("Total sales:$%.2f \n" ,Employee.sales);
         
             Employee.incentive = Employee.incentive * 2;
             if (Employee.incentive > 18500){ Employee.incentive = 18500;}
            
                 
             Employee.salary = Employee.salary + Employee.incentive;
             System.out.printf("Total incentive: $%.2f \n",incentive);
         }
         
         // if sales exceed over 50% of target goal employee receives maximum incentive
         
         else if (sales >  targetSales + (targetSales * .5))
         
         
         {
             System.out.printf("Total sales:$%.2f \n" ,sales);
             
             Employee.incentive = 18500;
                     
             Employee.salary = Employee.salary + Employee.incentive;
             System.out.printf("Total incentive: $%.2f \n",incentive);
         }
         
         
         // if sales does not meet 80% of target goal, no incentive is awarded
         
         else
         
         {
         Employee.incentive = 0; 
         System.out.println("No Bonus \n"); 
         }
     
 }
 
 //// Generate random sales amount for additional sales person and returns amount
 public static double genEmpSales()
 
 {
     
        
        Random randomNumber = new Random();
           double JohnsonSales = randomNumber.nextInt(155000-50000);
           return JohnsonSales ;  
               
       
           
 }

 

public static void main(String args[]) {

             ArrayList<Double> employeeSales = new ArrayList<Double>();
         
         bonusChart();
         
         
         
         
         //Print out the total salary                    
         System.out.printf("Total salary:$%.2f \n \n", salary);
         System.out.printf("*-----------------------------* \n");
         System.out.printf("*    COMPARISON CHART         *\n");
         System.out.printf("*-----------------------------* \n");
         
            //Place user sales and additional sales person sales into array called "employeSales"
        employeeSales.add(sales);
        employeeSales.add(genEmpSales());         
         
         
          
        //Print both user sales and coworkers sales
        System.out.printf(name + " sales = $%.2f \n", employeeSales.get(1));
        System.out.printf(nameToo + " sales = $%.2f \n \n", employeeSales.get(0)); 
          
               
            
           
        // Used if-else statement to compare sales between workers and printed output
        if(employeeSales.get(0) > employeeSales.get(1) )
        
        {
        System.out.println("You have higher sales than " + name);
        System.out.println(name + " is very sad about that!");
        }
           
           
        else if(employeeSales.get(0) < employeeSales.get(1))
           
        {
        
        double subtract = employeeSales.get(1) - employeeSales.get(0);
           
        System.out.println(name + " has higher sales than you.");
        System.out.printf("You need $%.2f in order to match him.", subtract);
        System.out.println(" Get to work!");
           
        }
                  
            
                        
            
     }
    }


