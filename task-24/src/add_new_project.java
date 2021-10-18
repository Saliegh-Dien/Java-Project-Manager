import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//the above are the imports required for this class
//======================================================================================================================

//this class is to add a new project in  a line in text file
public class add_new_project {
    //method to add project
    public static void project_add() throws IOException {

        //initializing variables for later use
        int proj_num;
        String proj_name;
        String build_type;
        String address;
        String ERF;
        double fee = 0;
        double paid = 0;
        String deadline;
        String completion_status = "incomplete";

        int proj_id = 0;

//----------------------------------------------------------------------------------------------------------------------
        try {
            Scanner x = new Scanner(new File("PoisedText.txt"));
            x.useDelimiter(",|\n");
            //below explains use delimiter for scanners with strings, I learnt how to scan selectively with this method
            //https://www.geeksforgeeks.org/scanner-usedelimiter-method-in-java-with-examples/

            //below is a while loop to read through file whilst sorting each index correctly into correct variable/category
            //(21 per line)
            while (x.hasNext()) {
                proj_id = x.nextInt();
                String project_name = x.next();
                String building_type = x.next();
                String proj_address = x.next();
                String ERF_no = x.next();
                String proj_fee = x.next();
                String fee_paid = x.next();
                String due_date = x.next();
                String status = x.next();

                String customer_name = x.next();
                String customer_tele_num = x.next();
                String customer_email = x.next();
                String customer_address = x.next();

                String architect_name = x.next();
                String architect_tele_num = x.next();
                String architect_email = x.next();
                String architect_address = x.next();

                String contractor_name = x.next();
                String contractor_tele_num = x.next();
                String contractor_email = x.next();
                String contractor_address = x.next();
            }
//======================================================================================================================
            //this section takes user input and prints asking for specific information
            System.out.println("Project ID number cannot be lower than: " + proj_id + "\nThose numbers have already been taken");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter project ID number: ");
            proj_num = input.nextInt();

            //in case user inputs a project number that already exists
            if (proj_num < proj_id) {
                System.out.println("Invalid input\nProject ID number already exists");
            }

            //if user inputted valid input the program will continue
            else {
                System.out.println("Enter project name: ");
                proj_name = input.next();

                System.out.println("Enter type of building: ");
                build_type = input.next();

                System.out.println("Enter address: ");
                address = input.next();

                System.out.println("Enter ERF number: ");
                ERF = input.next();

                //try catch block in case of input type error
                try {
                    System.out.println("Enter total fee: ");
                    fee = input.nextDouble();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input");
                    add_new_project.project_add();
                }
                //try catch block in case of input type error
                try {
                    System.out.println("Enter total paid to date: ");
                    paid = input.nextDouble();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input");
                    add_new_project.project_add();
                }

                System.out.println("Enter project deadline: \neg.: [06-07-2022]\nEnter in format [dd-MM-yyyy]: ");
                deadline = input.next();

//======================================================================================================================
                //the following section will print all information on the new project to give user an overview of what they typed
                System.out.println("\n//==========================================================================================");
                System.out.println("PROJECT INFORMATION:\nproject number: " + proj_num);
                System.out.println("project name: " + proj_name);
                System.out.println("building type: " + build_type);
                System.out.println("physical address: " + address);
                System.out.println("ERF number: " + ERF);
                System.out.println("total fee: R" + fee);
                System.out.println("amount of fee paid to date: R" + paid);
                System.out.println("project deadline: " + deadline);
                System.out.println("//==========================================================================================\n");

//===================================================================================================================
                // FOR: customer.java
                //this section creates an object
                //asks user for required data to create the object

                System.out.println("Enter customer name: ");
                String customer_name = input.next();

                System.out.println("Enter customer telephone number: ");
                String customer_tele_num = input.next();

                System.out.println("Enter customer email address: ");
                String customer_email = input.next();

                System.out.println("Enter customer address: ");
                String customer_address = input.next();

                customer customers = new customer(customer_name, customer_tele_num, customer_email, customer_address);
                //above line creates the object using given data from user

//===================================================================================================================
                // FOR: architect.java
                //this section creates an object
                //asks user for required data to create the object

                System.out.println("Enter architect name: ");
                String architect_name = input.next();

                System.out.println("Enter architect telephone number: ");
                String architect_tele_num = input.next();

                System.out.println("Enter architect email address: ");
                String architect_email = input.next();

                System.out.println("Enter architect address: ");
                String architect_address = input.next();

                architect architects = new architect(architect_name, architect_tele_num, architect_email, architect_address);
                //above line creates the object using given data from user

//===================================================================================================================
                // FOR: contractor.java
                //this section creates an object
                //asks user for required data to create the object

                System.out.println("Enter architect name: ");
                String contractor_name = input.next();

                System.out.println("Enter architect telephone number: ");
                String contractor_tele_num = input.next();

                System.out.println("Enter architect email address: ");
                String contractor_email = input.next();

                System.out.println("Enter architect address: ");
                String contractor_address = input.next();

                contractor contractors = new contractor(contractor_name, contractor_tele_num, contractor_email, contractor_address);
                //above line creates the object using given data from user

//====================================================================================================================

                //this section writes into PoisedText adding the new project into a new line of file
                FileWriter PoisedText_writer = new FileWriter("PoisedText.txt", true);
                PoisedText_writer.write(proj_num + "," + proj_name + "," + build_type + "," + address + "," + ERF + ","
                        + fee + "," + paid + "," + deadline + "," + completion_status + customers + architects + contractors + "\n");

                PoisedText_writer.close();
                //closes file writer
            }
        }
        catch(Exception e){
            System.out.println("error - could not read file");
        }
    }
}
