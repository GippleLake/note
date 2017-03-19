package com.gipplelake.designmode.state;

/**
 * @author dengqg
 */
public class State {
    private StateOption stateOption;

    public enum StateOption {
        Online, Offline, Hidden
    }

    public StateOption getStateOption() {
        return stateOption;
    }

    public void setStateOption(StateOption stateOption) {
        this.stateOption = stateOption;
    }

    public void online() {
        System.out.println("通知好友上线");
    }

    public void offline() {
        System.out.println("通知好友离线");
    }

    public void hidden() {
        System.out.println("隐身不再被看到");
    }
}
