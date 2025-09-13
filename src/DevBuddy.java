import java.io.IOException;

public class DevBuddy {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length == 0){
            System.out.println("Usage: java DevBuddy <command> [subcommand]");
            return;
        }

        String command = args[0];

        switch(command){
            case "init":
                Commands.handleInit(args);
                break;
            case "repo":
                Commands.handleRepo(args);
                break;
            case "help":
                Commands.handleHelp();
                break;
                default:
                    System.out.println("Unknown command: " + command);
        }
    }
}
