package Core.Infrastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Commands{

    public ArrayList<String> addCommand(String line) {
        ArrayList<String> commands = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(" ");
            while (rowScanner.hasNext()) {
                commands.add(rowScanner.next());
            }
            rowScanner.close();
        }
        return commands;
    }

    public String commandsToString(ArrayList<String> commands) {
        StringBuilder builder = new StringBuilder();
        for(String command : commands) {
            builder.append(command + " ");
        }
        String str = builder.toString();
        return str;
    }
}
