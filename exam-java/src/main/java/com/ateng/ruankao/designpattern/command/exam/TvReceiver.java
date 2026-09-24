package com.ateng.ruankao.designpattern.command.exam;

/**
 * 软考真题电视机接收者 (Receiver).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class TvReceiver {

    private boolean turnedOn = false;

    public void on() {
        this.turnedOn = true;
    }

    public void off() {
        this.turnedOn = false;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }
}
