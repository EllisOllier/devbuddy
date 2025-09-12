// Steps to run in dev env
// 1. javac src/DevBuddy.java -d out
// 2. java -cp out DevBuddy <command>
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DevBuddy {
    public static void main(String[] args) throws IOException {
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

    private static void handleInit(String[] args) throws IOException {
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
                createJavaProject(args);
                break;
                default:
                System.out.println("Unknown project type: " + projectType);
        }
    }

    private static void handleHelp(){
        System.out.println("Commands:\ninit\nhelp");
    }

    private static void createReactProject(String[] args){
        String projectName = args[2];

        // Check that node is installed with "node -v"
        // If node is installed run "npx create-react-app <projectName>
        // Alert the user if successful
        // Alert the user of any errors
    }

    private static void createPythonProject(String[] args){
        String projectName = args[2];

        // Check for python version (check how)
        // create directory with <projectName>
        // add main.py file to directory (cd into new directory?)
        // add readme.md to directory (could ask question if user wants it)
    }

    private static void createJavaProject(String[] args) throws IOException {
        String projectName = args[2];

        // Create root project folder with projectName at the users current directory (user.dir)
        // Specify root path for project
        Path root = Paths.get(System.getProperty("user.dir"), projectName);
        // Create root path
        Files.createDirectories(root);
        // Create /src directory in root directory
        // Specify directory being created in root
        Path srcDir = root.resolve("src");
        // Create src directory
        Files.createDirectories(srcDir);
        // Add Main.java to src
        Path mainFile = srcDir.resolve("Main.java");
        // Add Main class to Main.java
        Files.writeString(mainFile, "public class Main { }");
        // Add readme.md to directory
        Path readmeFile = root.resolve("README.md");
        // Add default text to readme.md
        Files.writeString(readmeFile, "Add information about Java project");
    }
}
