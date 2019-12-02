package kr.ac.ajou.main;

import java.util.List;

class Team {

    private String teamName;
    private List<Hitter> hitters;

    Team(){
        teamName = "";
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
