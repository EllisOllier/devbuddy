import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectCreator {
    static void createReactProject(String args) throws IOException, InterruptedException {
        String projectName = args.toLowerCase(); // React does not allow uppercase characters in project names

        // Check node is installed
        ProcessBuilder checkNode = new ProcessBuilder("node", "-v");
        Process runNodeCheck = checkNode.start();
        int nodeExitCode =  runNodeCheck.waitFor();
        // Check npx is installed
        ProcessBuilder checkNpx = new ProcessBuilder("npx", "-v");
        Process runNpxCheck = checkNpx.start();
        int npxExitCode = runNpxCheck.waitFor();

        // If node and npx is installed run "npx create-react-app <projectName>"
        if(npxExitCode == 0 && nodeExitCode == 0){
            ProcessBuilder reactProject = new ProcessBuilder("npx", "create-react-app", projectName);
            reactProject.inheritIO(); // Displays build messages for react project
            Process runReactProject = reactProject.start();
            int reactExitCode = runReactProject.waitFor();

            if(reactExitCode == 0){
                System.out.println("Successfully created react project: " + projectName);  // Alert the user if successful
            } else {
                System.out.println("Failed to created react project: " + projectName); // Alert the user of any errors
            }
        }
        else if(npxExitCode != 0 &&  nodeExitCode != 0){
            System.out.println("node and npx are required to create a react project!");
        }
    }

    // TODO : Check for more efficient way to create java and python projects as file structure is similar
    static void createPythonProject(String args) throws IOException {
        // Create root project folder with projectName at the users current directory (user.dir)
        // Specify root path for project
        Path root = Paths.get(System.getProperty("user.dir"), args);
        // Create root path
        Files.createDirectories(root);
        // Add Main.java to src
        Path mainFile = root.resolve("main.py");
        // Add Main class to Main.java
        Files.writeString(mainFile, "if __name__ == \"__main__\":\n" +
                "    print(\"Hello, world!\")\n");
        // Add readme.md to directory
        Path readmeFile = root.resolve("README.md");
        // Add default text to readme.md
        Files.writeString(readmeFile, "Add information about Python project");
    }

    static void createJavaProject(String args) throws IOException {
        // Create root project folder with projectName at the users current directory (user.dir)
        // Specify root path for project
        Path root = Paths.get(System.getProperty("user.dir"), args);
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
