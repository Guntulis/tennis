package service;

public class TennisScoreTranslationService {

    public static final String GAME = "Game";
    public static final String N_A = "N/A";
    private static final String LIFE = "Life";
    private static final String FIFTEEN = "15";
    private static final String THIRTY = "30";
    private static final String FORTY = "40";

    /**
     * Counts tennis score by given two values
     *
     * @param scoreA player A score
     * @param scoreB player B score
     * @return string representation of score
     */
    public String translatedScore(int scoreA, int scoreB) {
        if (scoreA > 6 || scoreB > 6) {
            return N_A;
        }
        if (scoreA >= 3 && scoreA == scoreB) {
            return "Deuce";
        }
        if ((scoreA >= 3 || scoreB >= 3) && (scoreA - scoreB == 1)) {
            return "Advantage A";
        }
        if ((scoreA >= 3 || scoreB >= 3) && (scoreA - scoreB == -1)) {
            return "Advantage B";
        }
        if ((scoreA >= 5 && scoreA - scoreB >= 3) || (scoreB >= 5 && scoreB - scoreA >= 3)) {
            return N_A;
        }
        if (scoreA >= 4 && (scoreA - scoreB >= 2)) {
            return GAME + " A";
        }
        if (scoreB >= 4 && (scoreB - scoreA >= 2)) {
            return GAME + " B";
        }
        return translate(scoreA) + "-" + translate(scoreB);
    }

    private String translate(int scoreB) {
        switch (scoreB) {
            case 0:
                return LIFE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
        }
        return "";
    }


}
