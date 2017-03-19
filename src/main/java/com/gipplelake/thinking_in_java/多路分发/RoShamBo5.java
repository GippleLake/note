package com.gipplelake.thinking_in_java.多路分发;

import java.util.EnumMap;

/**
 * 使用enumMap实现
 * @author dengqg
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER,SCISSORS,ROCK;
    static EnumMap<RoShamBo5,EnumMap<RoShamBo5,Outcome>>
    table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for(RoShamBo5 it : RoShamBo5.values()) {
            table.put(it, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }
            initRow(PAPER,Outcome.DRAW,Outcome.LOSE,Outcome.WIN);
            initRow(SCISSORS,Outcome.WIN,Outcome.DRAW,Outcome.LOSE);
            initRow(ROCK,Outcome.LOSE,Outcome.WIN,Outcome.DRAW);

    }

    static void initRow(RoShamBo5 it , Outcome vPAGER, Outcome vSCISSORS, Outcome vROCK){
        EnumMap<RoShamBo5,Outcome> row = RoShamBo5.table.get(it);
        row.put(PAPER,vPAGER);
        row.put(SCISSORS,vSCISSORS);
        row.put(ROCK,vROCK);

    }
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class,20);
    }
}
