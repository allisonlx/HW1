import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Polynomial> polynomials = new ArrayList<>();

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String termChoice;
        int choice;


        do {
            Polynomial p = new Polynomial();
            boolean newTerm = true;

            mainMenu();
            choice = keyboard.nextInt();
            keyboard.nextLine();


            switch (choice) {

                case 1:
                    do {
                        System.out.println("\nWould you like to enter a new term? (Y/N) ");
                        termChoice = keyboard.nextLine();
                        if (termChoice.equalsIgnoreCase("Y")) {
                            newTerm = true;
                            System.out.print("\nNew Term: ");
                            p.addTerm(new Term(keyboard.nextLine()));
                        } else if (termChoice.equalsIgnoreCase("N")) {
                            newTerm = false;
                        } else {
                            System.out.println("Error: Please enter a valid choice.");
                        }

                    } while (newTerm);

                    System.out.println("\n\nYour polynomial: ");
                    System.out.println(p);
                    polynomials.add(p);
                    break;

                case 2:
                    displayPolynomials();
                break;

                case 3:
                break;

                default:
                    System.out.println("ERROR: Enter a valid choice.");
            }
        } while (choice != 3);
    }




    public static void mainMenu(){
        System.out.println("\nPlease choose an option from the menu:");
        System.out.println("\t1) Create a new polynomial");
        System.out.println("\t2) View saved polynomials");
        System.out.println("\t3) Exit");
    }



    public static void displayPolynomials(){
        int i = 1;
        System.out.println("~~~ List Of Polynomials ~~~");
        for (Polynomial p : polynomials){
            System.out.println(i + ") " + p);
            i++;
        }
    }
}
