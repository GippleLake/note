package com.gipplelake.designmode.state;

/**
 * @author dengqg
 */
public class Context {
    private State state;


    public Context(State state) {
        this.state = state;
    }

    public void switchState() {
        switch (state.getStateOption()) {
            case Online:
                state.online();
                break;
            case Offline:
                state.offline();
                break;
            case Hidden:
                state.hidden();
                break;
            default:
                state.hidden();
        }
    }
}

class Test {
    public static void main(String[] args) {
        State state = new State();
        state.setStateOption(State.StateOption.Offline);
        Context context = new Context(state);
        context.switchState();
    }
}