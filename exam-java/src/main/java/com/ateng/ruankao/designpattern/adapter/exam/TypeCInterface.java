package com.ateng.ruankao.designpattern.adapter.exam;

/**
 * 软考真题目标接口（现代 Type-C 充电协议规范）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface TypeCInterface {

    /**
     * 使用 Type-C 协议充电.
     *
     * @return 充电状态
     */
    String chargeWithTypeC();
}
