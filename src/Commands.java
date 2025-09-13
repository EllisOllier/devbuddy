import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    static void handleRepo(String[] args) throws IOException, InterruptedException {
        if(args.length < 2){
            System.out.println("Usage: java DevBuddy repo <subcommand>");
            return;
        }

        String subcommand = args[1];

        switch(subcommand.toLowerCase()) {
            case "init":
                handleRepoInit();
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

    static void handleRepoInit() throws IOException, InterruptedException {
        try{
            // Run git init
            ProcessBuilder gitInit = new ProcessBuilder("git", "init");
            Process runGitInit = gitInit.start();
            int gitInitExitCode =  runGitInit.waitFor();
            // run git add and add all files in directory
            File root = new  File(System.getProperty("user.dir"));
            File[] files = root.listFiles();
            // Convert array to a mutable list
            // checks files array is not null
            assert files != null; // checks array at runtime (false throws AssertionError)

            List<File> fileList = new ArrayList<>(Arrays.asList(files));
            // Remove files called .DS_Store or .git and remove from array
            fileList.removeIf(file -> file.getName().equals(".git") || file.getName().equals(".DS_Store"));
            // Convert back to array if needed
            File[] filteredFiles = fileList.toArray(new File[0]);

            // run git add for each file and output success/ failure
            // git add is used instead of git add . to remove .git and .DS_Store
            for (File file : filteredFiles) {
                ProcessBuilder addFile = new ProcessBuilder("git", "add", file.getName());
                Process addFileProcess = addFile.start();
                int exitCode = addFileProcess.waitFor();
                // Alert use of success/failure
                if (exitCode == 0) {
                    System.out.println("Added " + file.getName());
                } else {
                    System.out.println("Failed to add " + file.getName());
                }
            }
            // TODO: run git commit -m <message>
            //  attempted a solution but wasn't working

            // Get the user to enter the remote URL
            Scanner repoUrlPrompt = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("Enter Repository URL: ");
            String repoUrl = repoUrlPrompt.nextLine();
            // Set the remote origin
            ProcessBuilder addRemote = new ProcessBuilder("git", "remote", "add", "origin", repoUrl);
            Process addRemoteProcess = addRemote.start();
            int remoteExitCode = addRemoteProcess.waitFor();
            // Alert user of success/failure
            if (remoteExitCode == 0) {
                System.out.println("Remote added " + repoUrl);
            } else {
                System.out.println("Failed to add " + repoUrl);
            }
            // Push to remote
            ProcessBuilder gitPush = new ProcessBuilder("git", "push", "origin", "main");
            // Display IO from ProcessBuilder in terminal
            gitPush.inheritIO();
            Process pushProcess = gitPush.start();
            int pushExitCode = pushProcess.waitFor();
            // Alert user of success/failure
            if (pushExitCode == 0) {
                System.out.println("Pushed to remote successfully");
            } else {
                System.out.println("Failed to push to remote. Make sure remote exists!");
            }
        } catch (AssertionError e){
            System.out.println("Error: " + e.getMessage());
        }

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
