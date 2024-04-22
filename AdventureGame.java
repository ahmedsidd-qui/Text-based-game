import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You find yourself standing in a dark forest.");

        String currentRoom = "Forest";
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("\nWhat do you want to do?");

            String userInput = scanner.nextLine();
            String[] words = userInput.split(" ");
            String verb = words[0];
            String noun = words.length > 1 ? words[1] : "";

            switch (currentRoom) {
                case "Forest":
                    if (verb.equalsIgnoreCase("go") && noun.equalsIgnoreCase("north")) {
                        System.out.println("You enter a mysterious cave.");
                        currentRoom = "Cave";
                    } else {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "Cave":
                    if (verb.equalsIgnoreCase("pick up") && noun.equalsIgnoreCase("key")) {
                        System.out.println("You pick up a rusty key.");
                    } else if (verb.equalsIgnoreCase("use") && noun.equalsIgnoreCase("key") && hasItem(scanner, "key")) {
                        System.out.println("You unlock the hidden door and escape the cave!");
                        gameOver = true;
                    } else {
                        System.out.println("I don't see a key here.");
                    }
                    break;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    public static boolean hasItem(Scanner scanner, String item) {
        System.out.println("Do you have the " + item + "? (yes/no)");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("yes");
    }
}