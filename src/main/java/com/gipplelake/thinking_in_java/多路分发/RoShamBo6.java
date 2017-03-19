package com.gipplelake.thinking_in_java.多路分发;

/**
 * 使用数组实现，最简单直接。如果数组过大时容易出错
 * @author dengqg
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAGER, SCISSORS, ROCK;
    private static Outcome[][] table = {
            {Outcome.DRAW, Outcome.LOSE, Outcome.WIN},
            {Outcome.WIN,Outcome.DRAW,Outcome.LOSE},
            {Outcome.LOSE,Outcome.WIN,Outcome.DRAW}};

    public Outcome compete(RoShamBo6 competitor) {
        return table[this.ordinal()][competitor.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class,20);
    }
}
