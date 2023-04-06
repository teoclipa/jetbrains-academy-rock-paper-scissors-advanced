package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static List<String> gameOptions;

    public static void main(String[] args) {
        String input;
        String userChoice;
        String computerChoice;
        Player player = startGameWithPlayer();
        while (true) {
            input = scanner.next();
            if (input.equalsIgnoreCase("!rating")) {
                System.out.println("Your rating: " + player.getRating());
                continue;
            }
            if (input.equalsIgnoreCase("!exit")) {
                System.out.println("Bye!");
                break;
            }
            if (!gameOptions.contains(input.toLowerCase())) {
                System.out.println("Invalid input");
            } else {
                userChoice = input;
                computerChoice = Option.randomOption(gameOptions);
                printResult(player, userChoice, computerChoice);
            }

        }

    }

    public static Player startGameWithPlayer() {
        Player player = new Player();
        //initial rating, to be set to file value if exists
        player.setRating(0);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        player.setName(name);
        System.out.printf("Hello, %s\n", name);

        gameOptions = selectOptions();
        System.out.println("Okay, let's start");


        String pathToFile = "./rating.txt";
        File file = new File(pathToFile);
        try (Scanner scanner1 = new Scanner(file)) {
            List<String> lines = new ArrayList<>();
            while (scanner1.hasNext()) {
                lines.add(scanner1.nextLine());
            }
            Map<String, Integer> scores = new HashMap<>();
            for (String line : lines) {
                String[] scoreLine = line.split(" ");
                scores.put(scoreLine[0], Integer.parseInt(scoreLine[1]));

            }
            for (String user : scores.keySet()) {
                if (user.equals(name)) {
                    player.setRating(scores.get(user));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }

        return player;
    }

    public static ArrayList<String> selectOptions() {
        String options = scanner.nextLine();
        if (options.trim().equals("")) {
            return new ArrayList<>(Arrays.asList("rock", "paper", "scissors"));
        }
        return new ArrayList<>(List.of(options.trim().toLowerCase().split(",")));
    }

    public static void printResult(Player player, String userChoice, String computerChoice) {
        switch (getResult(userChoice, computerChoice)) {
            case DRAW -> {
                System.out.println("There is a draw (" + userChoice + ")");
                player.increaseRating(50);
            }
            case USER_WIN -> {
                System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                player.increaseRating(100);
            }
            case COMPUTER_WIN -> {
                System.out.println("Sorry, but the computer chose " + computerChoice);
                player.increaseRating(0); //redundant for now
            }
        }
    }

    public static Result getResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return Result.DRAW;
        }
        ArrayList<String> newChoices = new ArrayList<>();
        int pos = gameOptions.indexOf(userChoice);
        int size = gameOptions.size();
        for (int i = 1; i < size - pos; i++) {
            newChoices.add(gameOptions.get(i + pos));
        }
        for (int i = 0; i < pos; i++) {
            newChoices.add(gameOptions.get(i));
        }
        List<String> computerWinsChoices = newChoices.subList(0, size / 2);
        for (String choice : computerWinsChoices) {
            if (computerChoice.equals(choice)) {
                return Result.COMPUTER_WIN;
            }
        }
        return Result.USER_WIN;
    }
}