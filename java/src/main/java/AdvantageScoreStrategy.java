public class AdvantageScoreStrategy implements ScoreStrategy{
    @Override
    public String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        int diffScore = firstPlayerScore - secondPlayerScore;

        if (diffScore >= 2) return  "Win for player1";

        return switch (diffScore) {
            case 1 -> "Advantage player1";
            case -1 -> "Advantage player2";
            default ->  "Win for player2";
        };
    }
}
