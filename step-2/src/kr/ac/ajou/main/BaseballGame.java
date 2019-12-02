package kr.ac.ajou.main;

import kr.ac.ajou.main.util.GameUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class BaseballGame {
    void turnOn() {
        GameUtils.printMessageLine(Constant.STR_GAME_OVERVIEW);
        Team firstTeam = new Team(Constant.NUM_FIRST_TEAM, Constant.STR_TOP_ORDER);
        Team secondTeam = new Team(Constant.NUM_SECOND_TEAM, Constant.STR_BOTTOM_ORDER);
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
        if (menuNum == Constant.MENU_INPUT) {
            processInputMenu(firstTeam, secondTeam);
        } else {
            String firstTeamName = firstTeam.getTeamName();
            String secondTeamName = secondTeam.getTeamName();
            if ("".equals(firstTeamName) && "".equals(secondTeamName)) {
                System.out.println("데이터 입력부터 해주세요.");
            } else {
                switch (menuNum) {
                    case Constant.MENU_OUTPUT:
                        processOutputMenu(firstTeam, secondTeam);
                        break;
                    case Constant.MENU_GAME_START:
                        processGameStartMenu(firstTeam, secondTeam);
                        break;
                }
            }
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
        for (int i = 0; i < Constant.NUM_HITTERS; i++) {
            Hitter hitter = new Hitter(i + 1);
            inputHitterName(i, hitter);
            inputHitterBattingAvr(i, hitter);
            team.addHitter(hitter);
        }
    }

    private void inputHitterName(int i, Hitter hitter) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%d번 타자 이름 입력> ", i + 1);
        String hitterName = sc.next();
        hitter.setHitterName(hitterName);
    }

    private void inputHitterBattingAvr(int i, Hitter hitter) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%d번 타자 타율 입력> ", i + 1);
        double battingAvr;
        while (true) {
            try {
                battingAvr = sc.nextDouble();
                if (battingAvr <= 0.1 || battingAvr >= 0.5) {
                    GameUtils.printMessageLine(Constant.STR_REINPUT_BATTING_AVR);
                    continue;
                }
            } catch (InputMismatchException e) {
                GameUtils.printMessageLine(Constant.STR_REINPUT_BATTING_AVR);
                sc = new Scanner(System.in);
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
        printTeamInfo(firstTeam);
        printTeamInfo(secondTeam);
    }

    private void printTeamInfo(Team team) {
        printTeamName(team);
        printTeamHittersInfo(team);
        printTeamPitcherInfo(team);
    }

    private void printTeamName(Team team) {
        System.out.println(team.getTeamName() + " 팀 정보");
    }

    private void printTeamHittersInfo(Team team) {
        List<Hitter> hitters = team.getHitters();
        for (int i = 0; i < Constant.NUM_HITTERS; i++) {
            Hitter curHitter = hitters.get(i);
            System.out.printf("%d번 %s, %f\n",
                    curHitter.getHitterNum(),
                    curHitter.getHitterName(),
                    curHitter.getBattingAvr());
        }
    }

    private void printTeamPitcherInfo(Team team) {
        Pitcher pitcher = team.getPitcher();
        System.out.println("투수 : " + pitcher.getName());
    }

    private void processGameStartMenu(Team firstTeam, Team secondTeam) {
        printGameStart(firstTeam, secondTeam);
        for (int i = 0; i < Constant.NUM_GAME_TIMES; i++) {
            attack(firstTeam, i);
            attack(secondTeam, i);
        }
    }

    private void printGameStart(Team firstTeam, Team secondTeam) {
        System.out.println(firstTeam.getTeamName() + " VS " +
                secondTeam.getTeamName() + "의 시합을 시작합니다.");
    }

    private void attack(Team team, int i) {
        printTeamAttack(team, i);

        List<Hitter> hitters = team.getHitters();
        int hitterNum = 0;
        while (true) {
            if (team.isThreeOut()) {
                break;
            }
            Hitter curHitter = hitters.get(hitterNum);
            attackByHitter(curHitter);
            hitterNum = (hitterNum + 1) % Constant.NUM_HITTERS;
        }
    }

    private void printTeamAttack(Team team, int i) {
        System.out.println(i + 1 + "회" + team.getTeamOrder() +
                " " + team.getTeamName() +
                " 공격");
    }

    private void attackByHitter(Hitter curHitter) {
        Random random = new Random();
        double d = random.nextDouble();
        double h = curHitter.getBattingAvr();

        double percentOut = 0.1;
        double percentHits = h + percentOut;
        double percentStrike = (1 - h) / 2.0 - 0.05 + percentHits;
        double percentBall = (1 - h) / 2.0 - 0.05 + percentStrike;

        if (d <= percentOut) { //out
            processOut();
        } else if (d <= percentHits) { //hits
            processHits();
        } else if (d <= percentStrike) { // strike
            processStrike();
        } else if (d <= percentBall) { // ball defacto 1.
            processBall();
        }
    }
    
    private void processOut() {

    }

    private void processHits() {
    }

    private void processStrike() {
    }

    private void processBall() {
    }
}
