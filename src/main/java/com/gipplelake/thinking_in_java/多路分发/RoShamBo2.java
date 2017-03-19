package com.gipplelake.thinking_in_java.多路分发;

import static com.gipplelake.thinking_in_java.多路分发.Outcome.*;

/**
 * 使用enum进行俩路分发，第一次分发是方法调用，第二次分发借助switch
 * @author dengqg
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN), SCISSOR(WIN, DRAW, LOSE), ROCK(LOSE, WIN, DRAW);

    private Outcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Outcome pager, Outcome scissors, Outcome rock) {
        this.vPAPER = pager;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }

    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case ROCK:
                return vROCK;
            case SCISSOR:
                return vSCISSORS;
        }
    }
}
