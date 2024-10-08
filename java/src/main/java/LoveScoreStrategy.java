public class LoveScoreStrategy implements ScoreStrategy{
    @Override
    public String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        return "Love";
    }
}
