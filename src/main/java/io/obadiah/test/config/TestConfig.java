package io.obadiah.test.config;

import io.obadiah.test.ExpansionTest;
import io.skyfallsdk.Server;
import io.skyfallsdk.config.type.YamlConfig;

import java.nio.file.Path;

public class TestConfig extends YamlConfig<TestConfig> {

    private static final TestConfig DEFAULT_CONFIG = new TestConfig(1);

    private int testNumber;

    public TestConfig() {
        super(TestConfig.class);
    }

    public TestConfig(int testNumber) {
        super(TestConfig.class);

        this.testNumber = testNumber;
    }

    public int getTestNumber() {
        return this.testNumber;
    }

    @Override
    public Path getPath() {
        return Server.get().getExpansion(ExpansionTest.class).getPath().resolve("testconfig.yml");
    }

    @Override
    public TestConfig getDefaultConfig() {
        return DEFAULT_CONFIG;
    }
}
