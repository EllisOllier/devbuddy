import java.io.IOException;

public class Commands {
    static void handleHelp(){
        System.out.println("Commands:\ninit\nhelp");
    }

    static void handleInit(String[] args) throws IOException, InterruptedException {
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

    static void handleRepo(String[] args) {
        if(args.length < 2){
            System.out.println("Usage: java DevBuddy repo <subcommand>");
            return;
        }

        String subcommand = args[1];

        switch(subcommand.toLowerCase()) {
            case "init":
                handleRepoInit(args);
                break;
            case "ignore":
                handleRepoIgnore(args);
                break;
            case "log":
                handleRepoCommitLog(args);
                break;
            case "status":
                handleRepoStatus(args);
                break;
            default:
                System.out.println("Unknown subcommand: " + subcommand);
        }
    }

    static void handleRepoInit(String[] args) {
        String message = args[0];
        // Get current user dir
        // run git init
        // run git add and add all files in directory
        // run git commit -m <message>
    }

    static void handleRepoIgnore(String[] args) {
        // Get current dir
        // Check for .gitignore file (maybe check for *.gitignore in case someone gives it a name)
        // Append file from args to .gitignore file
    }

    static void handleRepoCommitLog(String[] args) {
        // Check current dir
        // Get repo name from current dir path
        // Check all commit history for given repo
    }

    static void handleRepoStatus(String[] args) {
        // Run git status in current dir
        // Output command output to terminal
    }
}
