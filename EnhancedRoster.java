/**
 * @author Yewon Lee
 * Class that adds, delete, and display the slots of roster
 */
import java.util.Scanner;
public class EnhancedRoster<T> extends Roster<T>{

    // Instance Variable for waitlist
    LinkedList<String> waitList;

    // Constructor 
    public EnhancedRoster() {
        super();
        waitList = new LinkedList<String>();
    }

    /**
     * Add student to the waitlist
     * @param student is the name to add to the waitlist
     */
    public void addToWaitList(String student){
        waitList.add(student);
    }

    /**
     * @return the first student on the waitlist
     */
    public String getWLStudent(){
        return waitList.get(0);
    }

    /**
     * Check if the String argument exists on the roster
     * @param student is the name to be checked
     * @return 
     */
    public boolean IsNameOnRoster(String student){
        for (int i = 0; i < roster.size(); i++) {
            if(student.equals(roster.get(i))){
                return true;
            }
        }
            return false;
        
    }

    /**
     * Check if the String argument exists on the waitlist
     * @param student is the name to be checked
     * @return
     */
    public boolean IsNameOnWL(String student){
        for (int i = 0; i < waitList.size(); i++) {
            if(student.equals(waitList.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Display String representation of waitlist
     * @return waitlist
     */
    public String displayWL(){
        return waitList.toString();
    }

    /**
     * @return the length of waitlist 
     */
    public int getWLSize(){
        return waitList.size();
    }

    /**
     * Remove String argument from waitlist
     * @param target is the student to be removed from waitlist
     */
    public void removeWLStudent(String target){
        for (int i = 0; i < waitList.size(); i++) {
            if (target.equals(waitList.get(i))){
                waitList.delete(i);
                return;
            }
        }
    }

    /**
     * Method Tester
     * @param args
     */
    public static void main(String[] args) {

        // Instantiate roster 
        EnhancedRoster<String> rosterTester = new EnhancedRoster<String>();

        // Instantiate waitlist
        EnhancedRoster<String> waitList = new EnhancedRoster<String>();

        //Let the user decides number of slots on roster
        Scanner scan = new Scanner(System.in);
        System.out.println("How many spots does this class have?");
        String maxSpot = scan.nextLine();
        int rounds = Integer.parseInt(maxSpot);

        String userChoice = "";

        // Loop until the user quits the program
        while (userChoice.equals("q") == false) {

            //Add student to the roster
            if (userChoice.equals("a")) {

                Scanner scan3 = new Scanner(System.in);
                System.out.println("Name to Add: ");
                String studentName = scan3.nextLine();

                //Check if the user is not giving the same name that is already on the roster or waitlist
                if (rosterTester.IsNameOnRoster(studentName) || waitList.IsNameOnWL(studentName)){
                    System.out.println("The name already exists on the roster");
                }
                else {
                    //Add student to the roster if the roster has slots left
                    if (rosterTester.getSize() < rounds) {
                        rosterTester.addStudent(studentName);
                    //Add student to the waitlist if the roster is full
                    } else if (rosterTester.getSize() == rounds){
                        waitList.addToWaitList(studentName);
                    }
                }
            }
            
            // Remove student from the roster
            else if (userChoice.equals("r")){

                Scanner scan5 = new Scanner(System.in);
                System.out.println("Name to Remove: ");
                String target = scan5.nextLine();

                // Check if the roster is empty
                if (rosterTester.getSize() == 0) {
                    System.out.println("The roster is empty");
                // Check if the name is on the roster
                } else if (rosterTester.IsNameOnRoster(target)){
                    rosterTester.removeStudent(target);
                // Check if the name is on the waitlist
                } else if (waitList.IsNameOnWL(target)) {
                    waitList.removeWLStudent(target);
                } else {
                // Notify the name to be removed does not exist both on the roster and the waitlist
                    System.out.println("The name does not exist on the list");
                }

                //If there's a student in waitlist, add the first student of the waitlist to roster
                if (waitList.getWLSize() > 0 && rosterTester.getSize() < rounds) {
                    target = waitList.getWLStudent();
                    rosterTester.addStudent(target);
                    waitList.removeWLStudent(target);
                }
            } 
            
            // Display roster and waitlist
            else if (userChoice.equals("d")){
                System.out.println("Roster: "+ rosterTester.display() + "\n" + "Wait List: " + waitList.displayWL());
            }
            
            // Ask user for the next choice
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Enter [a/r/d/q]: (a)dd, (r)emove, (d)isplay, (q)uit");
            userChoice = scan3.nextLine();
                
        }
        
        // Notify the end of the program
        System.out.println("You've reached the end of the program");
        System.out.println("Roster: "+ rosterTester.display() + "\n" + "Wait List: " + waitList.displayWL());

    }
}
