package com.ateng.ruankao.designpattern.adapter.exam;

/**
 * 软考真题适配器（Micro-USB 转 Type-C 转换接头）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：实现 Target 接口（TypeCInterface）
public class UsbAdapter implements TypeCInterface {

    // 【题眼 2】：内部组合被适配者 Adaptee（MicroUsbCable）
    private final MicroUsbCable microUsbCable;

    // 【题眼 3】：构造方法注入被适配者实例
    public UsbAdapter(MicroUsbCable microUsbCable) {
        if (microUsbCable == null) {
            throw new IllegalArgumentException("被适配的 Micro-USB 数据线不能为空");
        }
        this.microUsbCable = microUsbCable;
    }

    @Override
    public String chargeWithTypeC() {
        // 【题眼 4】：将目标接口请求委托调用适配者的具体方法并完成协议转换
        return "Type-C 转换头接通 -> [" + microUsbCable.chargeWithMicroUsb() + "]";
    }
}
