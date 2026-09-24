package com.ateng.ruankao.designpattern.observer.standard;

/**
 * 具体观察者实现类.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteObserver implements Observer {

    private final String name;
    private String receivedState;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.receivedState = message;
    }

    public String getName() {
        return name;
    }

    public String getReceivedState() {
        return receivedState;
    }
}
