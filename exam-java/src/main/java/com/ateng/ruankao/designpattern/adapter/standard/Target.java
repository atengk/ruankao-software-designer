package com.ateng.ruankao.designpattern.adapter.standard;

/**
 * 适配器模式目标接口 (Target).
 * 定义客户端所期待的领域特定接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Target {

    /**
     * 目标业务请求接口.
     *
     * @return 请求响应结果
     */
    String request();
}
