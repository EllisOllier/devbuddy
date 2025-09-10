// Steps to run in dev env
// 1. javac src/DevBuddy.java -d out
// 2. java -cp out DevBuddy <command>

public class DevBuddy {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("DevBuddy CLI - No command provided");
            System.out.println("Usage: java DevBuddy <command>");
            return;
        }

        String command = args[0];

        switch(command){
            case "init":
                System.out.println("DevBuddy initialized");
                break;
            case "help":
                System.out.println("Commands:\ninit\nhelp");
                break;
                default:
                    System.out.println("Unknown command: " + command);
        }
    }
}
