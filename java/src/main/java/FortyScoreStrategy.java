public class FortyScoreStrategy implements ScoreStrategy{
    @Override
    public String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore== secondPlayerScore ? "Deuce": "Forty";
    }
}
