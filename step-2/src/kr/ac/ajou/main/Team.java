package kr.ac.ajou.main;

import java.util.ArrayList;
import java.util.List;

class Team {

    private int teamNum;
    private String teamOrder;
    private String teamName;

    private List<Hitter> hitters;
    private Pitcher pitcher;
    private int outNum;
    private int hitsNum;

    Team(int teamNum, String teamOrder) {
        this.teamNum = teamNum;
        this.teamOrder = teamOrder;

        teamName = "";
        hitters = new ArrayList<>(Constant.NUM_HITTERS);
    }

    int getTeamNum() {
        return teamNum;
    }

    void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    String getTeamOrder() {
        return teamOrder;
    }

    void setTeamOrder(String teamOrder) {
        this.teamOrder = teamOrder;
    }

    String getTeamName() {
        return teamName;
    }

    void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    void addHitter(Hitter hitter) {
        hitters.add(hitter);
    }

    void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }

    List<Hitter> getHitters() {
        return hitters;
    }

    Pitcher getPitcher() {
        return pitcher;
    }

    public boolean isThreeOut() {
        return outNum == Constant.THREE_OUT;
    }
}
