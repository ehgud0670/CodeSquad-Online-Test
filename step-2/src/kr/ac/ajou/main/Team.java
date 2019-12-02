package kr.ac.ajou.main;

import java.util.ArrayList;
import java.util.List;

class Team {

    private int teamNum;
    private String teamOrder;
    private String teamName;

    private List<Hitter> hitters;
    private Pitcher pitcher;

    Team(int teamNum, String teamOrder) {
        this.teamNum = teamNum;
        this.teamOrder = teamOrder;

        teamName = "";
        hitters = new ArrayList<>(Constant.NUM_HITTERS);
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public String getTeamOrder() {
        return teamOrder;
    }

    public void setTeamOrder(String teamOrder) {
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

    public void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }

    public List<Hitter> getHitters() {
        return hitters;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }
}
