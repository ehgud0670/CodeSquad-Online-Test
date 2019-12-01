package kr.ac.ajou.main;

class BaseballGame {

    void turnOn(){
        printGameStart();
    }

    private void printGameStart() {
        System.out.println("신나는 야구 게임!");
        System.out.println("첫 번째 타자가 타석에 입장했습니다.");
    }
}
