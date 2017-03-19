package com.gipplelake.thinking_in_java.多路分发;

/**
 * 该版本虽然比RoShamBo3更简短，却更难理解
 * @author dengqg
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
    PAGER {
        public Outcome compete(RoShamBo4 competitor) {
           return compete(ROCK,competitor);
        }
    }, SCISSORS {
        public Outcome compete(RoShamBo4 competitor) {
           return compete(PAGER,competitor);
        }
    }, ROCK {
        public Outcome compete(RoShamBo4 competitor) {
          return compete(SCISSORS,competitor);
        }
    };

    Outcome compete(RoShamBo4 loser,RoShamBo4 opponent){
        return (opponent == this)? Outcome.DRAW:((opponent == loser)?Outcome.WIN:Outcome.LOSE);
    }
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class,20);
    }


}
