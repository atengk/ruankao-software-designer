package com.ateng.ruankao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 下午应用技术 Java 实战验证工程冒烟测试.
 *
 * @author Ateng
 * @since 2026-09-24
 */
class SmokeTest {

    @Test
    @DisplayName("验证 Java 运行环境为 21 及以上版本")
    void testJavaRuntimeVersion() {
        String javaVersion = System.getProperty("java.version");
        assertThat(javaVersion).isNotNull();
        int majorVersion = Runtime.version().feature();
        assertThat(majorVersion).isGreaterThanOrEqualTo(21);
    }

    @Test
    @DisplayName("验证 AssertJ 断言机制与基础集合操作就绪")
    void testAssertionFramework() {
        var patternCategories = java.util.List.of("创建型", "结构型", "行为型");
        assertThat(patternCategories)
                .hasSize(3)
                .contains("行为型")
                .doesNotContain("反模式");
    }
}
