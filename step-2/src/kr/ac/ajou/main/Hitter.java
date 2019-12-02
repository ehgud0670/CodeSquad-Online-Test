package kr.ac.ajou.main;

public class Hitter {

    private String hitterName;
    private double battingAvr;
    private int hitterNum;

    Hitter(int hitterNum){
        this.hitterNum = hitterNum;
    }

    public int getHitterNum() {
        return hitterNum;
    }

    public void setHitterNum(int hitterNum) {
        this.hitterNum = hitterNum;
    }

    public String getHitterName() {
        return hitterName;
    }

    public void setHitterName(String hitterName) {
        this.hitterName = hitterName;
    }

    public double getBattingAvr() {
        return battingAvr;
    }

    public void setBattingAvr(double battingAvr) {
        this.battingAvr = battingAvr;
    }
}
