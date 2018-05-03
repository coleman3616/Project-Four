import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;
public class GolferScoresTree {
   public static void main(String[]args){
         int value = 0;
         String x = "";
         String n = " ";//name
         int r = 0;//number of rounds
         double s = 0;//score
         int h = 0;//handicap
         TreeBag league = new TreeBag();
         Scanner input = new Scanner(System.in);
         System.out.println(".........................................................");
         System.out.println("Welcome! This program runs a database for a golf league.");
         System.out.println("Press any key to proceed.");
         System.out.println(".........................................................");
         x = input.nextLine();
         //reading file stuffs goes here
        File file = new File("E:\\Csc103\\Projects\\Project Four\\Final\\golferinfo.txt");
        try{
        Scanner read = new Scanner(file);
        while(read.hasNext()){
            n = " ";//name
            r = 0;//number of rounds
            s = 0;//score
            h = 0;//handicap
            Golfer obj = null;
            n = read.next();
            r = read.nextInt();
            h = read.nextInt();
            s = read.nextDouble();
            obj = new Golfer(n,r,s,h);
            league.add(obj);
        }
         read.close();
        }catch(FileNotFoundException e){
            System.out.println("File was not found");
        }catch(Exception e){
            System.out.println("File was not found");
        }
        
         boolean done = false;
            while(done == false){
               Golfer temp = null;//reusable 
               String name = "";//for adding
               System.out.println("Select an option below.");
               System.out.println(".........................................................");
               System.out.println("1. Display listing to screen of all golfers stats(ordered by lastname)");
               System.out.println("2. Display the golfers in current tree format(Use displayAsTree )");
               System.out.println("3. Find and display one individual golfers stats");
               System.out.println("4. Update an individual golfers stats(by adding an additional score)");
               System.out.println("5. Remove a golfer from the Database");
               System.out.println("6. Add a new golfer to the Database");
               System.out.println("7. Quit and update datafile");
               System.out.println(".........................................................");              
               value = inputInt(0,7);
                switch(value){
                 
                  case 1://displays golfers in order by lastnname
                        try{
                        league.display();
                        }catch(IllegalStateException e){
                           System.out.println(e.getMessage());
                        }catch(Exception e){
                           System.out.println("Error.");
                        }
                        System.out.println("Press any key to proceed.");
                        x = input.next();//makes it easier to read output
                        break;
                  case 2://display as tree
                        try{
                        league.displayAsTree();
                        }catch(IllegalStateException e){
                           System.out.println(e.getMessage());
                        }catch(Exception e){
                           System.out.println("Error.");
                        }
                        System.out.println("Press any key to proceed.");
                        x = input.next();//makes it easier to read output  
                        break;
                  case 3://get score for a player
                        System.out.println("Type in the name of Golfer to get their score.");
                        name = input.next();
                        temp = new Golfer(name);
                        temp = (Golfer)league.retrieveRecursively(league.getRoot(), temp);
                        if(temp != null)
                           System.out.println(temp.toString());
                        else
                           System.out.println("Golfer doesn't exist");
                        System.out.println("Press any key to proceed.");
                        x = input.next();//makes it easier to read output
                        break;
                  case 4://update score
                        System.out.println("Type in the name of the Golfer you want to update their score.");
                        name = input.next();
                        temp = new Golfer(name);
                        temp = (Golfer)league.retrieveRecursively(league.getRoot(), temp);
                        System.out.println("Type in the score you would like to add.");
                        double score = input.nextDouble();
                        try{
                        temp.addScore(score);
                        }catch(Exception e){
                           System.out.println("Invalid number");
                        }
                        System.out.println("Press any key to proceed.");
                        x = input.next();//makes it easier to read output
                        break;
                  case 5://remove a node
                        System.out.println("Type in the name of the Golfer that you want to remove from the database.");
                        name = input.next();
                        name = name.toLowerCase();
                        temp = new Golfer(name);
                        boolean removed = league.remove(temp);
                        if(removed == true) 
                           System.out.println("Successfully removed");
                        else
                           System.out.println("No Golfer with that name in the database");
                           System.out.println("Press any key to proceed.");
                        x = input.next();//makes it easier to read output
                        break; 
                  case 6://adds a new golfer
                        System.out.println("Please enter the last name of the golfer.");
                        name = input.next();
                        temp = new Golfer(name);
                        league.add(temp);
                        break;
                  case 7://exits loop
                        done = true;
                        System.out.println("Thank you for using this program!");
                        System.out.println("And have a fun running your league!");
                        break;          
                  
               
               }
            
            }
            try{
               league.output();
            }catch(Exception e){
               System.out.println("Tree is empty");
            }

         }
/***********************
*inputInt method asks the user for a integer between the parameters of lowRange and highRange 
*and throws exception if inputted value is out of specified range or is an input mismatch
* @param lowRange
*  lowRange is an integer value that determines the minimal value for the integer inputted 
*@param highRange
*  highRange is an integer that determines the maximum value possible for the integer inputted
* @precondition
*   lowRange and highRange need to be integers and lowRange must be less than highRange
* @postcondition
*   A integer will be inputted and checked to see if it is the right data type and if it is in specified range
*The user will need to input value until it meets the requirements and once it does will be returned
* @exception InputMismatchException
*   Indicates that the user typed in the wrong data type
* @exception Exception
*   Indicates that the inputted number is not in specified range
***********************/
   public static int inputInt(int lowRange, int highRange)
   {
      Scanner input = new Scanner(System.in);
      boolean done = false;
      int number = 0;
      while(done == false)
      {
         try{
            input = new Scanner(System.in);
            number = input.nextInt();
            if(lowRange > number || highRange < number)
            {
              System.out.println("Number has to be in the valid range");
               
            }else{
            	 done = true;
            }
           
         }catch(InputMismatchException e)
         {
            System.out.println("Input Mismatch");
         }catch(Exception e)
         {
            e.getMessage();
         }
      }
      return number;
   }
   public static void UpdateFile(TreeBag league){
    File file = new File("E:\\Csc103\\Projects\\Project Four\\Unfinished\\Project-Four\\src\\golferinfo.txt");
    try{
      PrintWriter write = new PrintWriter(file);    
      write.print("");
      write.close();
      }catch(FileNotFoundException e){
            System.out.println("File was not found");
      }catch(Exception e){
            System.out.println("File was not found");
      }
   }   
   public static void deleteFileContent(){
      File file = new File("E:\\Csc103\\Projects\\Project Four\\Unfinished\\Project-Four\\src\\golferinfo.txt");
      try{
      Scanner read = new Scanner(file); 
      PrintWriter write = new PrintWriter(file);    
      while(read.hasNext()){
         write.print("");
      }
      read.close();
      write.close();
      }catch(FileNotFoundException e){
            System.out.println("File was not found");
      }catch(Exception e){
            System.out.println("File was not found");
      }
   
   }
   
}