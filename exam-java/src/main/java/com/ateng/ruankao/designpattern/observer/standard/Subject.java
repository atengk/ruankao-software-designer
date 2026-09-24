package com.ateng.ruankao.designpattern.observer.standard;

/**
 * 目标主题接口 (Subject).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
