package com.gipplelake.thinking_in_java.多路分发;

/**
 * 为每个enum提供不同的实现
 * 缺点：新增类型时，需要更多的代码
 * @author dengqg
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAGER {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAGER:
                    return Outcome.DRAW;
                case ROCK:
                    return Outcome.WIN;
                case SCISSORS:
                    return Outcome.LOSE;
            }
        }
    }, SCISSORS {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAGER:
                    return Outcome.WIN;
                case ROCK:
                    return Outcome.LOSE;
                case SCISSORS:
                    return Outcome.DRAW;
            }
        }
    }, ROCK {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAGER:
                    return Outcome.LOSE;
                case ROCK:
                    return Outcome.DRAW;
                case SCISSORS:
                    return Outcome.WIN;
            }
        }
    };

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class,20);
    }


}
