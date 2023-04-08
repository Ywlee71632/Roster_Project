/**
 * @author Yewon Lee
 * Class that adds, delete, and display the slots of roster
 */
import java.util.Scanner;
public class Roster<T> {
    
    /**
     * instance variable that will work as a roster
     */
    LinkedList<String> roster = new LinkedList<String>();

    /**
     * @return the size of roster
     */
    public int getSize(){
        return roster.size();
    }

    /**
     * add the argument to the roster
     * @param student is the argument to be added 
     */
    public void addStudent(String student){

        // Add student at the first slot of the roster is empty
        if (roster.isEmpty()) {
            roster.add(0, student);
        // Until the roster reaches the end, add student to the roster if the name of (i)th slot is lexicographically less than student
        } else {
            for(int i = 0; i < roster.size(); i++) {
                if (student.compareTo(roster.get(i)) < 0) {
                    roster.add(i, student);
                    return;
                }
            }
            // add student to the last of roster if all of other names are lexicographically greater than student
            roster.add(student);
        }
    }
    
    /**
     * remove the argument from the roster
     * @param target is the argument to be removed
     */
    public void removeStudent(String target){

        // loop through the roster until the method finds the target from the roster
        for (int i = 0; i < roster.size(); i++) {
            if (target.equals(roster.get(i))){
                //remove the target from the roster
                roster.delete(i);
                //stop looping
                return;
            }
        }
    }

    /**
     * @return the String representation of roster
     */
    public String display(){
        // call toString method to show String representation of the roster
        return roster.toString();
    }

    /**
     * Method Tester
     * @param args
     */
    public static void main(String[] args) {

        EnhancedRoster<String> rosterTester = new EnhancedRoster<String>();

        //Let the user decides number of slots on roster
        Scanner scan = new Scanner(System.in);
        System.out.println("How many spots does this class have?");
        String maxSpot = scan.nextLine();
        int rounds = Integer.parseInt(maxSpot);

        String userChoice = "";

        
        //Run the roster program until the user chooses to quit the program or all the spots get filled
         
        while (userChoice.equals("q") == false && rosterTester.getSize() < rounds) {

            //Add student to the roster
            if (userChoice.equals("a")) {

                Scanner scan3 = new Scanner(System.in);
                System.out.println("Name to Add: ");
                String studentName = scan3.nextLine();

                rosterTester.addStudent(studentName);
                
            }

            //Remove student from the roster
            else if (userChoice.equals("r")){

                Scanner scan5 = new Scanner(System.in);
                System.out.println("Name to Remove: ");
                String target = scan5.nextLine();

                rosterTester.removeStudent(target);
                
            } 
            
            //Display the roster
            else if (userChoice.equals("d")){
                System.out.println("Roster: "+ rosterTester.display());
            }
            
            //Update the input from the user
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Enter [a/r/d/q]: (a)dd, (r)emove, (d)isplay, (q)uit");
            userChoice = scan3.nextLine();
        }
    
        //Notify the user that the slots are all filled
        if (rosterTester.getSize() == rounds) {
            System.out.println(" - All of the spots in roster are filled - ");
        }

        //Notify the end of the program
        System.out.println("You've reached the end of the program");
        System.out.println("Roster: " + rosterTester.display());

    }
}


