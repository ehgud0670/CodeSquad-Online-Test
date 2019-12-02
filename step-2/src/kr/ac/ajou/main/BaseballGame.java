package kr.ac.ajou.main;

import kr.ac.ajou.main.util.GameUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

class BaseballGame {

    private Team firstTeam;
    private Team secondTeam;

    BaseballGame() {
        firstTeam = new Team();
        secondTeam = new Team();
    }

    void turnOn() {
        GameUtils.printMessageLine(Constant.STR_GAME_START);
        printMenu();
        int menuNum = selectMenu();
        processByMenu(menuNum);
    }

    private void printMenu() {
        printMenuOption();
        GameUtils.printMessageNoLine(Constant.STR_MENU_CHOICE);
    }

    private void printMenuOption() {
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 출력");
        System.out.println("3. 시합 시작");
        System.out.println();
    }

    private int selectMenu() {
        Scanner sc = new Scanner(System.in);
        int menuNum;
        while (true) {
            try {
                menuNum = sc.nextInt();
                if (menuNum != Constant.MENU_INPUT &&
                        menuNum != Constant.MENU_OUTPUT &&
                        menuNum != Constant.MENU_GAME_START) {
                    GameUtils.printMessageNoLine(Constant.STR_REINPUT_MENU);
                    continue;
                }
            } catch(InputMismatchException e){
                GameUtils.printMessageNoLine(Constant.STR_REINPUT_MENU);
                sc = new Scanner(System.in);
                continue;
            }
            break;
        }
        return menuNum;
    }

    private void processByMenu(int menuNum) {
        switch (menuNum) {
            case Constant.MENU_INPUT:
                processInputMenu();
                break;
            case Constant.MENU_OUTPUT:
                break;
            case Constant.MENU_GAME_START:
                break;
        }
    }

    private void processInputMenu() {
        inputFirstTeam();
    }

    private void inputFirstTeam() {
        inputFirstTeamName();
        inputFirstTeamHittersInfo();
        inputFirstTeamPitcherInfo();
    }

    private void inputFirstTeamName() {
        Scanner sc = new Scanner(System.in);
        GameUtils.printMessageNoLine(Constant.STR_INPUT_TEAM_NAME_1);
        String firstTeamName = sc.next();
        firstTeam.setTeamName(firstTeamName);
    }

    private void inputFirstTeamHittersInfo() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Constant.NUM_HITTERS; i++) {
            Hitter hitter = new Hitter();
            inputHitterName(sc, i, hitter);
            inputHitterBattingAvr(sc,i,hitter);
            firstTeam.addHitter(hitter);
        }
    }

    private void inputFirstTeamPitcherInfo() {
        Scanner sc = new Scanner(System.in);
        Pitcher pitcher = new Pitcher();
        GameUtils.printMessageNoLine("투수 정보 입력> ");
        String pitcherName = sc.next();
        pitcher.setName(pitcherName);
        firstTeam.setPitcher(pitcher);
    }

    private void inputHitterName(Scanner sc, int i, Hitter hitter) {
        System.out.printf("%d번 타자 이름 입력> ", i + 1);
        String hitterName = sc.next();
        hitter.setHitterName(hitterName);
    }

    private void inputHitterBattingAvr(Scanner sc, int i, Hitter hitter) {
        System.out.printf("%d번 타자 타율 입력> ", i + 1);
        double battingAvr = sc.nextDouble();
        hitter.setBattingAvr(battingAvr);
    }
}
