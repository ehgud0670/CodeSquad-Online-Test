package kr.ac.ajou.main;

import kr.ac.ajou.main.util.GameUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

class BaseballGame {

    void turnOn() {
        GameUtils.printMessageLine(Constant.STR_GAME_START);
        Team firstTeam = new Team(Constant.NUM_FIRST_TEAM);
        Team secondTeam = new Team(Constant.NUM_SECOND_TEAM);

        while (true) {
            printMenu();
            int menuNum = selectMenu();
            if (menuNum == Constant.MENU_GAME_EXIT) {
                break;
            }
            processByMenu(menuNum, firstTeam, secondTeam);
        }
        GameUtils.printMessageLine(Constant.STR_GAME_EXIT);
    }

    private void printMenu() {
        printMenuOption();
        GameUtils.printMessageNoLine(Constant.STR_MENU_CHOICE);
    }

    private void printMenuOption() {
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 출력");
        System.out.println("3. 시합 시작");
        System.out.println("4. 게임 나가기");
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
                        menuNum != Constant.MENU_GAME_START &&
                        menuNum != Constant.MENU_GAME_EXIT) {
                    GameUtils.printMessageNoLine(Constant.STR_REINPUT_MENU);
                    continue;
                }
            } catch (InputMismatchException e) {
                GameUtils.printMessageNoLine(Constant.STR_REINPUT_MENU);
                sc = new Scanner(System.in);
                continue;
            }
            break;
        }
        return menuNum;
    }

    private void processByMenu(int menuNum, Team firstTeam, Team secondTeam) {
        switch (menuNum) {
            case Constant.MENU_INPUT:
                processInputMenu(firstTeam, secondTeam);
                break;
            case Constant.MENU_OUTPUT:
                processOutputMenu(firstTeam, secondTeam);
                break;
            case Constant.MENU_GAME_START:
                break;
        }
    }

    private void processInputMenu(Team firstTeam, Team secondTeam) {
        inputTeam(firstTeam);
        inputTeam(secondTeam);
    }

    private void inputTeam(Team team) {
        inputTeamName(team);
        inputTeamHittersInfo(team);
        inputTeamPitcherInfo(team);
    }

    private void inputTeamName(Team team) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%d팀의 이름을 입력하세요> ", team.getTeamNum());
        String teamName = sc.next();
        team.setTeamName(teamName);
    }

    private void inputTeamHittersInfo(Team team) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Constant.NUM_HITTERS; i++) {
            Hitter hitter = new Hitter();
            inputHitterName(sc, i, hitter);
            inputHitterBattingAvr(sc, i, hitter);
            team.addHitter(hitter);
        }
    }

    private void inputHitterName(Scanner sc, int i, Hitter hitter) {
        System.out.printf("%d번 타자 이름 입력> ", i + 1);
        String hitterName = sc.next();
        hitter.setHitterName(hitterName);
    }

    private void inputHitterBattingAvr(Scanner sc, int i, Hitter hitter) {
        System.out.printf("%d번 타자 타율 입력> ", i + 1);
        double battingAvr;
        while (true) {
            battingAvr = sc.nextDouble();
            if (battingAvr <= 0.1 || battingAvr >= 0.5) {
                System.out.println("다시 입력해주세요. 타율 h는 0.1 < h < 0.5");
                continue;
            }
            break;
        }
        hitter.setBattingAvr(battingAvr);
    }

    private void inputTeamPitcherInfo(Team team) {
        Scanner sc = new Scanner(System.in);
        Pitcher pitcher = new Pitcher();
        GameUtils.printMessageNoLine("투수 정보 입력> ");
        String pitcherName = sc.next();
        pitcher.setName(pitcherName);
        team.setPitcher(pitcher);
    }

    private void processOutputMenu(Team firstTeam, Team secondTeam) {
        String firstTeamName = firstTeam.getTeamName();
        String secondTeamName = secondTeam.getTeamName();
        if ("".equals(firstTeamName) && "".equals(secondTeamName)) {
            System.out.println("데이터 입력부터 해주세요.");
        } else {
            printTeamInfo(firstTeam);
            printTeamInfo(secondTeam);
        }
    }

    private void printTeamInfo(Team team) {
        printTeamName(team);
    }

    private void printTeamName(Team team) {
        System.out.println(team.getTeamName() + " 팀 정보");
    }
}
