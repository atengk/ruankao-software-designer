package com.ateng.ruankao.designpattern.adapter;

import com.ateng.ruankao.designpattern.adapter.exam.MicroUsbCable;
import com.ateng.ruankao.designpattern.adapter.exam.TypeCInterface;
import com.ateng.ruankao.designpattern.adapter.exam.UsbAdapter;
import com.ateng.ruankao.designpattern.adapter.standard.Adaptee;
import com.ateng.ruankao.designpattern.adapter.standard.ObjectAdapter;
import com.ateng.ruankao.designpattern.adapter.standard.Target;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 适配器模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 适配器模式双轨测试")
class AdapterPatternTest {

    @Test
    @DisplayName("标准规范：对象适配器无缝桥接 Adaptee 至 Target 规范")
    void testStandardAdapter() {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);

        String result = target.request();
        assertThat(result).contains("适配者Adaptee的特定请求响应");
    }

    @Test
    @DisplayName("软考真题原型：Micro-USB 线通过转接头兼容 Type-C 接口")
    void testExamUsbAdapter() {
        MicroUsbCable oldCable = new MicroUsbCable();
        TypeCInterface typeCAdapter = new UsbAdapter(oldCable);

        String status = typeCAdapter.chargeWithTypeC();
        assertThat(status)
                .contains("Type-C 转换头接通")
                .contains("Micro-USB 5V/2A 供电中");
    }
}
