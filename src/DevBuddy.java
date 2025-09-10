// Steps to run in dev env
// 1. javac src/DevBuddy.java -d out
// 2. java -cp out DevBuddy <command>
import java.nio.file.*;
import java.io.IOException;

public class DevBuddy {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Usage: java DevBuddy <command> [subcommand]");
            return;
        }

        String command = args[0];

        switch(command){
            case "init":
                handleInit(args);
                break;
            case "help":
                handleHelp();
                break;
                default:
                    System.out.println("Unknown command: " + command);
        }
    }

    private static void handleInit(String[] args){
        if(args.length < 3){
            System.out.println("Usage: java DevBuddy init <project-type> <project-name>");
            return;
        }

        String projectType = args[1];
        String projectName = args[2];

        switch(projectType.toLowerCase()) {
            case "python":
                System.out.println("Initialising Python project: " + projectName);
                break;
            case "react":
                System.out.println("Initialising React project: " + projectName);
                break;
            case "java":
                System.out.println("Initialising Java project: " + projectName);
                break;
                default:
                System.out.println("Unknown project type: " + projectType);
        }
    }

    private static void handleHelp(){
        System.out.println("Commands:\ninit\nhelp");
    }

    private void createReactProject(String[] args){
        String projectName = args[2];

        // Check that node is installed with "node -v"
        // If node is installed run "npx create-react-app <projectName>
        // Alert the user if successful
        // Alert the user of any errors
    }

    private void createPythonProject(String[] args){
        String projectName = args[2];

        // Check for python version (check how)
        // create directory with <projectName>
        // add main.py file to directory (cd into new directory?)
        // add readme.md to directory (could ask question if user wants it)
    }

    private void createJavaProject(String[] args){
        String projectName = args[2];

        // check jvm is installed (i think)
        // create directory with <projectName>
        // create src directory in root directory
        // add Main.java to src directory
        // add readme.md to directory
    }
}
