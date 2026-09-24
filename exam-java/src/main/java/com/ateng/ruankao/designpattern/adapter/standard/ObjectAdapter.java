package com.ateng.ruankao.designpattern.adapter.standard;

/**
 * 对象适配器实现类.
 * 通过内部组合 Adaptee 对象，将其适配为 Target 接口规范.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ObjectAdapter implements Target {

    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        if (adaptee == null) {
            throw new IllegalArgumentException("被适配的对象不能为空");
        }
        this.adaptee = adaptee;
    }

    @Override
    public String request() {
        return "适配器包装 -> [" + adaptee.specificRequest() + "]";
    }
}
