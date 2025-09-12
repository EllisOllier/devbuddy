import java.io.IOException;

public class Commands {
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

    static void handleHelp(){
        System.out.println("Commands:\ninit\nhelp");
    }
}
