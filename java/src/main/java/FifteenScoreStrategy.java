public class FifteenScoreStrategy implements ScoreStrategy{
    @Override
    public String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        return "Fifteen";
    }
}
