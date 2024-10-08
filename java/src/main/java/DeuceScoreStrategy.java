public class DeuceScoreStrategy implements ScoreStrategy {
    @Override
    public String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        return "Deuce";
    }
}
