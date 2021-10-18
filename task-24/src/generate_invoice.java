import java.io.*;
import java.text.*;
import java.util.*;
//the above are the imports required for this class
//======================================================================================================================

//this class is to generate an invoice on txt file, write completed tasks onto a txt file, mark a task as complete
class generate_invoice {
    public static void create_invoice(){

        //below asks user to select project according project ID number
        String filepath = "PoisedText.txt";
        System.out.println("Enter project number: ");
        Scanner input = new Scanner(System.in);
        String search_key = input.next();

        //asks user to mark this specific task as complete
        System.out.println("Project completion status\nEnter y to proceed: ");
        String new_completion_status = input.next();

        //asks user to enter y to mark as complete the after calls method
        if(new_completion_status.equals("y")){
            new_completion_status = "complete";
        }

        editRecord(filepath, search_key, new_completion_status);
        //calls required method
    }
//======================================================================================================================
    //this section initiates method creation and file paths
    public static void editRecord(String filepath, String search_key, String new_completion_status){

        String completed_tasks = "completed_tasks.txt";
        String tempFile = "temp.txt";

        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        File completed_file = new File(completed_tasks);

//======================================================================================================================
        //buffered print writer for temFile which is later renamed to PoisedTexts.txt
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter tempFile_to_PoisedTexts_writer = new PrintWriter(bw);
//----------------------------------------------------------------------------------------------------------------------
            //buffered print writer for completed_tasks.txt
            FileWriter finalised_writer = new FileWriter(completed_file, true);
            BufferedWriter bw2 = new BufferedWriter(finalised_writer);
            PrintWriter completed_tasks_writer = new PrintWriter(bw2);
//----------------------------------------------------------------------------------------------------------------------
            //buffered print writer for invoice.txt
            String invoice_file = "invoice.txt";
            FileWriter invoice = new FileWriter(invoice_file, true);
            BufferedWriter bw3 = new BufferedWriter(invoice);
            PrintWriter invoice_writer = new PrintWriter(bw3);
//----------------------------------------------------------------------------------------------------------------------

            Scanner x = new Scanner(new File(filepath));
            //above reads PoisedText.txt
            x.useDelimiter(",|\n");
            //useDelimiter to scan selectively

            try {
                //below is a while loop to read through file whilst sorting each index correctly into correct variable/category
                //(21 per line)
                while (x.hasNext()) {
                    String proj_num = x.next();
                    String proj_name = x.next();
                    String type = x.next();
                    String address = x.next();
                    String ERF = x.next();
                    int fee = x.nextInt();
                    int paid = x.nextInt();
                    String due_date = x.next();
                    String completion_status = x.next();

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

                    //below states if project ID number equals the search key user entered:
                    //write the following into text file
                    if (proj_num.equals(search_key)) {
                        Date current_date = new Date();
                        //today's date, needed for date marked as completed
                        SimpleDateFormat date_form = new SimpleDateFormat("dd/MM/yyyy");
                        //format for date stored into variable

                        int total = fee - paid;
                        //calculation for fee still owed

                        //below creates the sentence to write
                        String complete = "Project ID number: " + proj_num + "\nProject name: " + proj_name + "\nBuilding type: " +
                                type + "\nAddress: " + address + "\nERF: " + ERF + "\nFee: " + fee + "\nAmount paid: " + paid +
                                "\nDue date: " + due_date + "\nProject status: " + completion_status + "\nCustomer details\nname: "
                                + customer_name + "\ntelephone number: " + customer_tele_num + "\nemail: " + customer_email +
                                "\naddress: " + customer_address + "\nArchitect details\nname: " + architect_name + "\ntelephone number: "
                                + architect_tele_num + "\nemail: " + architect_email + "\naddress: " + architect_address +
                                "\nContractor details\nname: " + contractor_name + "\ntelephone number: " + contractor_tele_num
                                + "\nemail: " + contractor_email + "\naddress: " + contractor_address + "\n";

                        //below writes into text file the above declared sentence plus current date in desired format
                        completed_tasks_writer.print(complete + "Completion date: " + date_form.format(current_date) +
                                "\n------------------------------------------------------------------------------------\n");
//----------------------------------------------------------------------------------------------------------------------

                        //invoice generate/written only if there is still money client owes to poised
                        if (total > 0) {
                            invoice_writer.print("Customer details: \n" +
                                    "name: " + customer_name + "\ntelephone number: " + customer_tele_num + "\nemail: " + customer_email +
                                    "\naddress: " + customer_address + "\nRemaining amount due: R" + total +
                                    "\n------------------------------------------------------------------------------------\n");
                        }
                    }
//----------------------------------------------------------------------------------------------------------------------
                    //writes the new data of PoisedText.txt (everything except the project that was just marked as complete)
                    else {
                        String incomplete_projects = proj_num + "," + proj_name + "," + type + "," + address + "," + ERF + "," + fee + "," +
                                paid + "," + due_date + "," + completion_status + "," + customer_name + "," + customer_tele_num
                                + "," + customer_email + "," + customer_address + "," + architect_name + "," + architect_tele_num
                                + "," + architect_email + "," + architect_address + "," + contractor_name + "," + contractor_tele_num
                                + "," + contractor_email + "," + contractor_address + "\n";

                        tempFile_to_PoisedTexts_writer.print(incomplete_projects);
                    }
                }
//======================================================================================================================
                //this section just closes scanners, print writers, deletes old file(poised) and renames temp to PoisedText.txt
                x.close();

                tempFile_to_PoisedTexts_writer.flush();
                tempFile_to_PoisedTexts_writer.close();
                completed_tasks_writer.flush();
                completed_tasks_writer.close();
                invoice_writer.flush();
                invoice_writer.close();

                oldFile.delete();
                File poised = new File(filepath);
                newFile.renameTo(poised);
            }
//----------------------------------------------------------------------------------------------------------------------

            catch (Exception e) {
                System.out.println("error\ncould not successfully write into txt file(s)");
                //in case something goes wrong with file writing
            }
        }
        catch( Exception e){
            System.out.println("error\ncould not read file");
            //in case something goes wrong with file reading
        }
    }
}
