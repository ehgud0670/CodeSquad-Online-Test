package kr.ac.ajou.main;

import java.util.ArrayList;
import java.util.List;

class Team {

    private int teamNum;
    private String teamName;
    private List<Hitter> hitters;
    private Pitcher pitcher;

    Team(int teamNum) {
        this.teamNum = teamNum;
        teamName = "";
        hitters = new ArrayList<>(Constant.NUM_HITTERS);
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
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
}
