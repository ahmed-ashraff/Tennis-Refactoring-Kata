import java.util.stream.IntStream;

public class TennisGame1 implements TennisGame {

    private final Player[] players = new Player[2];
    private final static int FIRST_PLAYER_INDEX = 0;
    private final static int SECOND_PLAYER_INDEX = 1;
    private final ScoreManagement scoreManagement;

    public TennisGame1(String player1Name, String player2Name) {
        this.players[FIRST_PLAYER_INDEX] = new Player(player1Name, 0);
        this.players[SECOND_PLAYER_INDEX] = new Player(player2Name, 0);
        scoreManagement = new ScoreManagement();
    }

    public void wonPoint(String playerName) {
        int indexWinner = getPlayerIndexByName(playerName);
        int currentScore = players[indexWinner].getScore();
        players[indexWinner].setScore(currentScore+1);
    }

    private int getPlayerIndexByName(String playerName) {
        return IntStream.range(0, players.length)
                .filter(i -> players[i].getName().equalsIgnoreCase(playerName))
                .findFirst()
                .orElseThrow(ArrayIndexOutOfBoundsException::new);
    }

    public String getScore() {
        int firstPlayerScore = players[FIRST_PLAYER_INDEX].getScore();
        int secondPlayerScore = players[SECOND_PLAYER_INDEX].getScore();

        return scoreManagement.getScoreOf(firstPlayerScore, secondPlayerScore);
    }
}
