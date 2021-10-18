import java.io.*;
import java.util.*;
//the above are the imports required for this class
//======================================================================================================================
//below is where I got the base idea of this method
//https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
//this class is to view each project as an object, this part I found hard and used several websites and reading in order
//to understand a few things like: System.arraycopy()
class project_viewer {

    public static void view_as_object() throws FileNotFoundException {
        Scanner x = new Scanner(new File("PoisedText.txt"));
        x.useDelimiter("[,|\n]");
        //use delimiter for scanning strings, able to scan selectively

        Project[] projects = new Project[0];
        //above initiates creation of new array object for later use
//----------------------------------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------------------------------

            //below is the actual creating/adding part of each new project made from existing data
            Project newProject = new Project(proj_num, proj_name, building_type, address, ERF, fee, paid, due_date, status,
                    customer_name, customer_tele_num, customer_email, customer_address, architect_name, architect_tele_num,
                    architect_email, architect_address, contractor_name, contractor_tele_num, contractor_email, contractor_address);

            projects = addProject(projects, newProject);
            //uses addProject() method to create a new project
        }

        //this for loop will allow me to create a new project object for EVERY project/line
        for (Project project : projects) {
            System.out.println(project);
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public static Project[] addProject(Project[] projects, Project project_to_add) {
//this section/piece of code(3 lines) is the part I needed help with mostly and this was acquired from:
//https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
//https://www.geeksforgeeks.org/system-arraycopy-in-java/
//https://www.tutorialspoint.com/java/lang/system_arraycopy.htm
//above is where I learnt about system.arraycopy to better understand it, explains how to use the method very basically
//this method basically copies an array from the specified source array, beginning at specific start position to
//specific destination position of the array, so basically I will be using existing data to create the objects
        Project[] newProjects = new Project[projects.length + 1];
        System.arraycopy(projects, 0, newProjects, 0, projects.length);
        //object source array = projects
        //object destination array = newProjects
        //the number of elements to be copied is the total of 'projects.length' which is obviously an int length
        newProjects[newProjects.length - 1] = project_to_add;
        //project_to_add, the -1 to length is for indexing purposes to prevent "IndexOutOfBounds" error

        return newProjects;
    }
//----------------------------------------------------------------------------------------------------------------------
//initiation of the object called 'project'
    public static class Project {

        //the object's attributes
        String proj_num;
        String proj_name;
        String building_type;
        String address;
        String ERF;
        String fee;
        String paid;
        String due_date;
        String status;
        String customer_name;
        String customer_tele_num;
        String customer_email;
        String customer_address;
        String architect_name;
        String architect_tele_num;
        String architect_email;
        String architect_address;
        String contractor_name;
        String contractor_tele_num;
        String contractor_email;
        String contractor_address;

//======================================================================================================================
    //the object's constructor
    public Project(String proj_num, String proj_name, String building_type, String address,
                       String ERF, String fee, String paid, String due_date, String status, String customer_name,
                       String customer_tele_num, String customer_email, String customer_address, String architect_name,
                       String architect_tele_num, String architect_email, String architect_address, String contractor_name,
                       String contractor_tele_num, String contractor_email, String contractor_address) {

        this.proj_num = proj_num;
        this.proj_name = proj_name;
        this.building_type = building_type;
        this.address = address;
        this.ERF = ERF;
        this.fee = fee;
        this.paid = paid;
        this.due_date = due_date;
        this.status = status;
        this.customer_name = customer_name;
        this.customer_tele_num = customer_tele_num;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.architect_name = architect_name;
        this.architect_tele_num = architect_tele_num;
        this.architect_email = architect_email;
        this.architect_address = architect_address;
        this.contractor_name = contractor_name;
        this.contractor_tele_num = contractor_tele_num;
        this.contractor_email = contractor_email;
        this.contractor_address = contractor_address;
    }

//======================================================================================================================

        //the following is a text block, displaying all projects, 1  by 1, printing in user-friendly format
        public String toString() {
            return String.format("""
                            ============================================================================================
                            proj_num: %s\r
                            proj_name: %s\r
                            building_type: %s\r
                            address: %s\r
                            ERF: %s\r
                            fee: %s\r
                            paid: %s\r
                            due_date: %s\r
                            status: %s\r
                            --------------------------------------------------------------------------------------------
                            customer:
                            name: %s\r
                            telephone number: %s\r
                            email: %s\r
                            address: %s\r
                            --------------------------------------------------------------------------------------------
                            architect:
                            name: %s\r
                            telephone number: %s\r
                            email: %s\r
                            address: %s\r
                            --------------------------------------------------------------------------------------------
                            constructor:
                            name: %s\r
                            telephone number: %s\r
                            email: %s\r
                            address: %s\r
                            ============================================================================================
                            """,
                    proj_num, proj_name, building_type, address, ERF, fee, paid, due_date, status, customer_name,
                    customer_tele_num, customer_email, customer_address, architect_name, architect_tele_num,
                    architect_email, architect_address, contractor_name, contractor_tele_num, contractor_email,
                    contractor_address);
            //the above is the data that will be placed at the %s, in correct order/position
        }
    }
}
