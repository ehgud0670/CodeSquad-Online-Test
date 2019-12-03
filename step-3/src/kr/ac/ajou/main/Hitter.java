package kr.ac.ajou.main;

public class Hitter {

    private String hitterName;
    private double battingAvr;
    private int hitterNum;

    private int strikeNum;
    private int ballNum;
    private boolean isOut;
    private boolean isHit;

    Hitter(int hitterNum) {
        this.hitterNum = hitterNum;
        strikeNum = 0;
        ballNum = 0;
    }

    int getHitterNum() {
        return hitterNum;
    }

    void setHitterNum(int hitterNum) {
        this.hitterNum = hitterNum;
    }

    String getHitterName() {
        return hitterName;
    }

    void setHitterName(String hitterName) {
        this.hitterName = hitterName;
    }

    double getBattingAvr() {
        return battingAvr;
    }

    void setBattingAvr(double battingAvr) {
        this.battingAvr = battingAvr;
    }

    int getStrikeNum() {
        return strikeNum;
    }

    void setStrikeNum(int strikeNum) {
        this.strikeNum = strikeNum;
    }

    boolean isThreeStrike() {
        return strikeNum == Constant.THREE_STRIKE;
    }

    void strike() {
        strikeNum++;
    }

    int getBallNum() {
        return ballNum;
    }

    void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    void ball() {
        ballNum++;
    }

    boolean isFourBall() {
        return ballNum == Constant.FOUR_BALL;
    }

    void initStrikeAndBall() {
        strikeNum = 0;
        ballNum = 0;
    }

    void initOutAndHit() {
        isOut = false;
        isHit = false;
    }

    boolean isOut() {
        return isOut;
    }

    void setOut(boolean out) {
        isOut = out;
    }

    boolean isHit() {
        return isHit;
    }

    void setHit(boolean hit) {
        isHit = hit;
    }
}
