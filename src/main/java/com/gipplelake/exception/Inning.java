package com.gipplelake.exception;

/**
 * @author dengqg
 */

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {

}

public abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    }
}

class StormException extends Exception {
}

class RainOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    void event() throws RainOut;

    void randHard() throws RainOut;
}

class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainOut ,BaseballException {
    }

    public StormyInning(String s) throws RainOut, BaseballException {
    }

    //void walk() throws PopFoul {}
    // public void event() throws RainOut{}
    public void event() {
    }

    @Override
    public void atBat() throws PopFoul {

    }

    public void randHard() throws RainOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        }  catch (BaseballException e) {
            System.out.println("BaseballException");
        } catch (StormException e) {
            e.printStackTrace();
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (BaseballException e) {
            System.out.println("BaseballException ");
        } catch (StormException e) {
            e.printStackTrace();
        }
    }
}
