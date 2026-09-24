package com.ateng.ruankao.designpattern.adapter.exam;

/**
 * 软考真题适配者（旧版 Micro-USB 充电线）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class MicroUsbCable {

    /**
     * Micro-USB 协议供电输出.
     *
     * @return 供电输出状态
     */
    public String chargeWithMicroUsb() {
        return "Micro-USB 5V/2A 供电中";
    }
}
