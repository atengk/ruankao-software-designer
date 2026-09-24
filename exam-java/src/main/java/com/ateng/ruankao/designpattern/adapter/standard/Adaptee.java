package com.ateng.ruankao.designpattern.adapter.standard;

/**
 * 适配者类 (Adaptee).
 * 包含已经存在但接口不兼容的业务实现.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Adaptee {

    /**
     * 已存在的特定业务方法.
     *
     * @return 特定响应
     */
    public String specificRequest() {
        return "适配者Adaptee的特定请求响应";
    }
}
