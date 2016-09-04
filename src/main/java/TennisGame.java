import entity.TennisPlayer;
import service.TennisScoreTranslationService;

import java.util.Scanner;

public class TennisGame {

    public static void main(String[] args) {
        System.out.println("Tennis game.");
        Scanner keyboard = new Scanner(System.in);
        TennisScoreTranslationService service = new TennisScoreTranslationService();
        TennisPlayer playerA = new TennisPlayer();
        TennisPlayer playerB = new TennisPlayer();
        String explanationText = "Type 'A' if player A won set, type 'B' won set. (type 'quit' to exit):";
        System.out.println(explanationText);
        boolean exit = false;
        while (!exit) {
            String input = keyboard.nextLine();
            if (input != null) {
                if ("quit".equalsIgnoreCase(input)) {
                    System.out.println("Exit game.");
                    exit = true;
                } else if ("a".equalsIgnoreCase(input)) {
                    playerA.setScore(playerA.getScore() + 1);
                } else if ("b".equalsIgnoreCase(input)) {
                    playerB.setScore(playerB.getScore() + 1);
                } else {
                    System.out.println(explanationText);
                }
                String currentScore = service.translatedScore(playerA.getScore(), playerB.getScore());
                if (!exit) {
                    System.out.println("Current score: " + currentScore);
                }
                if (currentScore.contains(TennisScoreTranslationService.GAME)) {
                    exit = true;
                }
                if (playerA.getScore() == 5 && playerB.getScore() == 5) {
                    exit = true;
                }
            }
        }
        keyboard.close();
    }
}
