import java.io.*;
import java.text.ParseException;
import java.util.*;
//the above are the imports required for this class
//======================================================================================================================

//main class is to call other methods in classes to execute according to user input
public class main_class {
    public static void main(String[] args) throws IOException, ParseException {

        //the following will display a user-friendly menu
        System.out.println("""
                MAIN MENU
                a - To add new project
                f - To finalise a project/mark as complete
                v - To view all projects
                o - To view overdue projects only
                e - To edit projects""");

        Scanner input = new Scanner(System.in);
        String main_input = input.next();
        //the above takes the user's input

//======================================================================================================================
        switch (main_input) {
            case "a" -> add_new_project.project_add();
            case "f" -> generate_invoice.create_invoice();
            case "v" -> project_viewer.view_as_object();
            case "o" -> dates.overdue_projects();
            case "e" -> editing_projects.project_info_updater();
            //calls said method within proper class according to user's input from main menu
        }
    }
}
