package kr.ac.ajou.main;

import java.util.ArrayList;
import java.util.List;

class Team {

    private String teamName;
    private List<Hitter> hitters;
    private Pitcher pitcher;

    Team() {
        teamName = "";
        hitters = new ArrayList<>(Constant.NUM_HITTERS);
    }

    String getTeamName() {
        return teamName;
    }

    void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    void addHitter(Hitter hitter){
        hitters.add(hitter);
    }

    public void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }
}
