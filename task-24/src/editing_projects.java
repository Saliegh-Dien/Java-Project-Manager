import java.io.*;
import java.util.*;
public class editing_projects {
//the above are the imports required for this class
//======================================================================================================================

//this class is to edit/update information in existing projects
    public static void project_info_updater(){

        String filepath = "PoisedText.txt";
        //filepath, later needed
        System.out.println("To edit project\nEnter project number: ");
        Scanner input = new Scanner(System.in);
        String search_key = input.next();
        //above asks user to select project to edit
//----------------------------------------------------------------------------------------------------------------------
        //this section will be the new data to replace old data of the selected project

        System.out.println("Enter updated amount paid: ");
        String new_paid = input.next();

        System.out.println("Enter new due date: ");
        String new_due_date = input.next();
//----------------------------------------------------------------------------------------------------------------------

        editRecord(filepath, search_key, new_paid, new_due_date);
        //calls said method
    }
    public static void editRecord(String filepath, String search_key, String new_paid, String new_due_date){

        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        //above files and file paths required

        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter(",|\n");
            //to scan selectively

            //below is a while loop to read through file whilst sorting each index correctly into correct variable/category
            //(21 per line)
            while (x.hasNext()){
                String proj_num = x.next();
                String proj_name = x.next();
                String type = x.next();
                String address = x.next();
                String ERF = x.next();
                String fee = x.next();
                String paid = x.next();
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

                //below is the new/edited project line of information
                if(proj_num.equals(search_key)){
                    fw.write(proj_num + "," + proj_name + "," + type + "," + address + "," + ERF + "," + fee + "," +
                            new_paid + "," + new_due_date + "," +  completion_status + "," + customer_name + "," + customer_tele_num
                            + "," + customer_email + "," + customer_address + "," + architect_name + "," + architect_tele_num
                            + "," + architect_email + "," + architect_address + "," +  contractor_name + "," + contractor_tele_num
                            + "," + contractor_email + "," + contractor_address + "\n");
                }
                //below is the other project lines of information to be written again(not the edited, but everything else)
                else{
                    fw.write(proj_num + "," + proj_name + "," + type + "," + address + "," + ERF + "," + fee + "," +
                            paid + "," + due_date + "," +  completion_status + "," + customer_name + "," + customer_tele_num
                            + "," + customer_email + "," + customer_address + "," + architect_name + "," + architect_tele_num
                            + "," + architect_email + "," + architect_address + "," + contractor_name + "," + contractor_tele_num
                            + "," + contractor_email + "," + contractor_address + "\n");
                }
            }
//======================================================================================================================
            //below is the section that closes scanners, writers, deletes old file and renames new file
            x.close();
            pw.flush();
            pw.close();

            oldFile.delete();
            File poised = new File(filepath);
            newFile.renameTo(poised);
        }
        catch(Exception e){
            System.out.println("error\ncould not read/write into file");
        }
    }
}
// https://www.youtube.com/watch?v=TpyRKom0X_s
//the above video taught me the above method that I used in this task with editing text files
