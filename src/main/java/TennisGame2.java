
public class TennisGame2 implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private final String player1Name;
    private final String player2Name;

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    private static final String WIN_FOR_PLAYER1 = "Win for player1";
    private static final String WIN_FOR_PLAYER2 = "Win for player2";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getScore() {
        if (P1point == P2point) {
            if (P1point < 3) {
                return pointToString(P1point) + "-All";
            }
            return DEUCE;
        }

        if (P1point >= 4 || P2point >= 4) {
            int diff = P1point - P2point;
            if (diff == 1) return ADVANTAGE_PLAYER1;
            if (diff == -1) return ADVANTAGE_PLAYER2;
            if (diff >= 2) return WIN_FOR_PLAYER1;
            if (diff <= -2) return WIN_FOR_PLAYER2;
        }

        return pointToString(P1point) + "-" + pointToString(P2point);
    }

    private String pointToString(int point) {
        switch (point) {
            case 0: return LOVE;
            case 1: return FIFTEEN;
            case 2: return THIRTY;
            case 3: return FORTY;
            default: return FORTY;
        }
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    @Override
    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            P1Score();
        } else {
            P2Score();
        }
    }
}
