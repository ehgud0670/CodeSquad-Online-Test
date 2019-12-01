package kr.ac.ajou.main;

import kr.ac.ajou.main.util.GameUtils;

import java.util.Random;

class BaseballGame {

    void turnOn() {
        printGameStart();

        int randomNum = generateRandomNum();
        Team team = new Team();
        processByRandomNum(randomNum, team);
    }

    private void printGameStart() {
        System.out.println("신나는 야구 게임!");
        System.out.println("첫 번째 타자가 타석에 입장했습니다.");
        System.out.println();
    }

    private int generateRandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(Integer.MAX_VALUE) % Constant.NUM_MOD;
        return randomNum;
    }

    private void processByRandomNum(int randomNum, Team team) {
        switch (randomNum) {
            case Constant.NUM_STRIKE:
                processStrike(team);
                break;
            case Constant.NUM_BALL:
                processBall(team);
                break;
            case Constant.NUM_HITS:
                processHits(team);
                break;
            case Constant.NUM_OUT:
                processOut(team);
                break;
        }
    }

    private void processStrike(Team team) {
        GameUtils.printMessage(Constant.STR_STRIKE);
        team.strike();
        if (team.isThreeStrike()) {
            processOut(team);
        }
    }

    private void processBall(Team team) {
        GameUtils.printMessage(Constant.STR_BALL);
        team.ball();
        if (team.isFourBall()) {
            processHits(team);
        }
    }

    private void processHits(Team team) {
        GameUtils.printMessage(Constant.STR_HITS);
        team.hits();
        GameUtils.printMessage(Constant.STR_NEXT_HITTER);
        team.initHitter();
    }

    private void processOut(Team team) {
        GameUtils.printMessage(Constant.STR_OUT);
    }
}
