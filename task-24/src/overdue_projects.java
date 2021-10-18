import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//the above are the imports required for this class

//======================================================================================================================
//this class is to check if a project is overdue

class dates {
    public static void overdue_projects() throws ParseException, FileNotFoundException {

        Scanner x = new Scanner(new File("PoisedText.txt"));
        x.useDelimiter("[,\n]");
        //above scans text file
        //useDelimiter, to scan selectively

        int overdue_projects_counter = 0;
        //counter for overdue projects

        //below is a while loop to read through file whilst sorting each index correctly into correct variable/category
        //(21 per line)
        while (x.hasNext()) {
            String proj_num = x.next();
            String proj_name = x.next();
            String building_type = x.next();
            String address = x.next();
            String ERF = x.next();
            String fee = x.next();
            String paid = x.next();
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

//======================================================================================================================
            Date current_date = new Date();
            SimpleDateFormat date_form = new SimpleDateFormat("dd/MM/yyyy");
            //above gets the current date into variable and gets the desired format into variable, separately

            //below states that if the project is incomplete and due date is has already passed current date
            //then display the project and +1 to overdue projects counter
            if (date_form.parse(due_date).before(current_date) && status.equals("incomplete")) {
                System.out.println("Project name: " + proj_name + "||Project ID number: " + proj_num + "\nStatus: OVERDUE ["
                        + due_date + "]\n");

                overdue_projects_counter++;
            }
        }
        System.out.println("Overdue projects count: " + overdue_projects_counter);
        //prints amount of projects overdue
    }
}
