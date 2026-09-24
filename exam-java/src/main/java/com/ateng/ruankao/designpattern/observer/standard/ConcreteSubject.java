package com.ateng.ruankao.designpattern.observer.standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 具体目标主题实现类.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void attach(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }
}
