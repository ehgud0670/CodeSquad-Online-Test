package kr.ac.ajou.main;

import kr.ac.ajou.main.util.GameUtils;

import java.util.Scanner;

class BaseballGame {
    void turnOn() {
        printGameStart();
        printMenu();
        int menuNum = selectMenu();
    }

    private void printMenu() {
        printMenuOption();
        printMenuChoice();
    }

    private int selectMenu() {
        Scanner sc = new Scanner(System.in);
        int menuNum;
        while (true) {
            menuNum = sc.nextInt();
            if (menuNum != Constant.MENU_INPUT &&
                    menuNum != Constant.MENU_OUTPUT &&
                    menuNum != Constant.MENU_GAME_START) {
                GameUtils.printMessage(Constant.STR_REINPUT_MENU);
                continue;
            }
            break;
        }
        return menuNum;
    }

    private void printMenuChoice() {
        System.out.print("메뉴선택 (1 - 3) ");
    }

    private void printMenuOption() {
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 출력");
        System.out.println("3. 시합 시작");
        System.out.println();
    }

    private void printGameStart() {
        System.out.println("신나는 야구시합");
    }
}
