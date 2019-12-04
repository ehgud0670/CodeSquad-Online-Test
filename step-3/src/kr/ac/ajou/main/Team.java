package kr.ac.ajou.main;

import java.util.ArrayList;
import java.util.List;

class Team {

    private int teamNum;
    private String teamName;

    private List<Hitter> hitters;
    private Pitcher pitcher;
    private int pitchingNum;

    private int outNum;
    private int strikeOutNum;
    private int curHitsNum;
    private int totalHitsNum;
    private int score;
    private int curInningNum;
    private int[] inningScores;

    Team(int teamNum) {
        this.teamNum = teamNum;
        teamName = "";
        hitters = new ArrayList<>(Constant.NUM_HITTERS);
        inningScores = new int[Constant.NUM_INNINGS];
    }

    public int getPitchingNum() {
        return pitchingNum;
    }

    public void setPitchingNum(int pitchingNum) {
        this.pitchingNum = pitchingNum;
    }

    void pitching() {
        pitchingNum++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addTotalScore(int score) {
        this.score += score;
    }

    int getTeamNum() {
        return teamNum;
    }

    void setTeamNum(int teamNum) {
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

    void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }

    List<Hitter> getHitters() {
        return hitters;
    }

    Pitcher getPitcher() {
        return pitcher;
    }

    int getOutNum() {
        return outNum;
    }

    void setOutNum(int outNum) {
        this.outNum = outNum;
    }

    void out() {
        outNum++;
    }

    boolean isThreeOut() {
        return outNum == Constant.THREE_OUT;
    }

    public void initOut() {
        outNum = 0;
    }

    int getCurHitsNum() {
        return curHitsNum;
    }

    void setCurHitsNum(int curHitsNum) {
        this.curHitsNum = curHitsNum;
    }

    void hits() {
        curHitsNum++;
    }

    void addTotalHitsNum() {
        totalHitsNum += curHitsNum;
    }

    public int getTotalHitsNum() {
        return totalHitsNum;
    }

    void initHits() {
        curHitsNum = 0;
    }

    int getCurInningNum() {
        return curInningNum;
    }

    void setCurInningNum(int curInningNum) {
        this.curInningNum = curInningNum;
    }

    int[] getInningScores() {
        return inningScores;
    }

    void setInningScores(int[] inningScores) {
        this.inningScores = inningScores;
    }

    void setCurInningScore(int score) {
        this.inningScores[this.curInningNum - 1] = score;
    }

    int getStrikeOutNum() {
        return strikeOutNum;
    }

    void setStrikeOutNum(int strikeOutNum) {
        this.strikeOutNum = strikeOutNum;
    }

    void strikeOut() {
        strikeOutNum++;
    }
}
