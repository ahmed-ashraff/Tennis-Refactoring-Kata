import java.util.HashMap;
import java.util.Map;

public class ScoreManagement {
    private final static String ALL = "-All";
    private final Map<Integer, ScoreStrategy> scoreStrategies;
    private final static int MIN_PLAYER_SCORE_TO_WIN = 4;

    public ScoreManagement() {
        this.scoreStrategies = new HashMap<>();
        this.scoreStrategies.put(Score.LOVE.ordinal(), new LoveScoreStrategy());
        this.scoreStrategies.put(Score.FIFTEEN.ordinal(), new FifteenScoreStrategy());
        this.scoreStrategies.put(Score.THIRTY.ordinal(), new ThirtyScoreStrategy());
        this.scoreStrategies.put(Score.FORTY.ordinal(), new FortyScoreStrategy());
        this.scoreStrategies.put(Score.DEUCE.ordinal(), new DeuceScoreStrategy());
        this.scoreStrategies.put(Score.ADVANTAGE.ordinal(), new AdvantageScoreStrategy());
    }

    private String getScoreOfEqualMatch(int firstPlayerScore, int secondPlayerScore) {
        String currentScore = scoreStrategies.get(firstPlayerScore).calculateScore(firstPlayerScore, secondPlayerScore);
        return firstPlayerScore < 3 ? currentScore + ALL: currentScore;
    }

    private boolean isPlayerWinning(int playerScore) {
        return playerScore >= MIN_PLAYER_SCORE_TO_WIN;
    }

    public String getScoreOf(int firstPlayerScore, int secondPlayerScore) {
        if (firstPlayerScore == secondPlayerScore)  {
            return getScoreOfEqualMatch(firstPlayerScore, secondPlayerScore);
        }

        if (isPlayerWinning(firstPlayerScore) || isPlayerWinning(secondPlayerScore)) {
            return scoreStrategies.get(Score.ADVANTAGE.ordinal()).calculateScore(firstPlayerScore, secondPlayerScore);
        }

        return scoreStrategies.get(firstPlayerScore).calculateScore(firstPlayerScore, secondPlayerScore)
                + "-" + scoreStrategies.get(secondPlayerScore).calculateScore(firstPlayerScore, secondPlayerScore);
    }
}
