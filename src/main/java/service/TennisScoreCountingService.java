package service;

public class TennisScoreCountingService {

    /**
     * Counts tennis score by given two values
     * @param scoreA player A score
     * @param scoreB player B score
     * @return string representation of score
     */
    public String currentScore(int scoreA, int scoreB) {
        if (scoreA >= 3 && scoreA == scoreB) {
            return "Deuce";
        } else if ((scoreA >= 3 || scoreB >=3) && (scoreA - scoreB == 1)){
            return "Advantage A";
        }  else if ((scoreA >= 3 || scoreB >=3) && (scoreA - scoreB == -1)){
            return "Advantage B";
        } else if (scoreA >= 4 && (scoreA - scoreB >= 2)) {
            return "Game A";
        } else if (scoreB >= 4 && (scoreB - scoreA >= 2)) {
            return "Game B";
        }
        return translate(scoreA) + " - " + translate(scoreB);
    }

    private String translate(int scoreB) {
        switch (scoreB) {
            case 0:
                return "Life";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
        }
        return "N/A";
    }


}
