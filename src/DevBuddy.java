// Steps to run in dev env
// 1. javac src/DevBuddy.java -d out
// 2. java -cp out DevBuddy <command>
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DevBuddy {
    public static void main(String[] args) throws IOException, InterruptedException {
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

    private static void handleInit(String[] args) throws IOException, InterruptedException {
        if(args.length < 3){
            System.out.println("Usage: java DevBuddy init <project-type> <project-name>");
            return;
        }

        String projectType = args[1];
        String projectName = args[2];

        switch(projectType.toLowerCase()) {
            case "python":
                System.out.println("Initialising Python project: " + projectName);
                ProjectCreator.createPythonProject(projectName);
                break;
            case "react":
                System.out.println("Initialising React project: " + projectName);
                ProjectCreator.createReactProject(projectName);
                break;
            case "java":
                System.out.println("Initialising Java project: " + projectName);
                ProjectCreator.createJavaProject(projectName);
                break;
                default:
                System.out.println("Unknown project type: " + projectType);
        }
    }

    private static void handleHelp(){
        System.out.println("Commands:\ninit\nhelp");
    }
}
