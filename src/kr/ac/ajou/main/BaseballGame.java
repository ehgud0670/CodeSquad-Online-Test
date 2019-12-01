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
                GameUtils.printMessage(Constant.STR_STRIKE);
                break;
            case Constant.NUM_BALL:
                GameUtils.printMessage(Constant.STR_BALL);
                break;
            case Constant.NUM_HITS:
                GameUtils.printMessage(Constant.STR_HITS);
                break;
            case Constant.NUM_OUT:
                GameUtils.printMessage(Constant.STR_OUT);
                break;
        }
    }


}
