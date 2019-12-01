package kr.ac.ajou.main;

class Team {
    private int hitsNum;
    private int outNum;
    private Hitter hitter;

    Team() {
        hitsNum = 0;
        outNum = 0;
        hitter = new Hitter();
    }

    int getHitsNum() {
        return hitsNum;
    }

    int getOutNum() {
        return outNum;
    }

    //about hitter
    int getStrikeNum() {
        return hitter.getStrikeNum();
    }

    int getBallNum() {
        return hitter.getBallNum();
    }

    public void strike() {
        hitter.strikeNum++;
    }

    public boolean isThreeStrike() {
        return this.hitter.strikeNum == Constant.THREE_STRIKE;
    }

    private static class Hitter {
        private int strikeNum;
        private int ballNum;

        private Hitter() {
            strikeNum = 0;
            ballNum = 0;
        }

        int getStrikeNum() {
            return strikeNum;
        }

        int getBallNum() {
            return ballNum;
        }
    }
}