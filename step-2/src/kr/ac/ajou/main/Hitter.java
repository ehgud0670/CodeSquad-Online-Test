package kr.ac.ajou.main;

public class Hitter {

    private String hitterName;
    private double battingAvr;
    private int hitterNum;

    private int strikeNum;
    private int ballNum;

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

    int getBallNum() {
        return ballNum;
    }

    void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    void strike() {
        strikeNum++;
    }

    void ball() {
        ballNum++;
    }
}
