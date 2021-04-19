package io.obadiah.test;

import io.obadiah.test.command.TestCommand;
import io.obadiah.test.config.TestConfig;
import io.skyfallsdk.config.LoadableConfig;
import io.skyfallsdk.expansion.Expansion;
import io.skyfallsdk.expansion.ExpansionInfo;

import java.util.concurrent.TimeUnit;

@ExpansionInfo(name = "test", version = "1.0-SNAPSHOT", authors = { "Obadiah Crowe" })
public class ExpansionTest implements Expansion {

    private TestConfig config;

    @Override
    public void onStartup() {
        this.getLogger().info("testing expansion: " + this.getInfo().name());

        this.registerCommand(
          TestCommand.class
        );

        this.config = LoadableConfig.getByClass(TestConfig.class).load();

        this.getLogger().info("got value: " + this.config.getTestNumber());

        this.getServer().getScheduler().schedule(() -> {
            this.getLogger().info("firing this one later");
        }, 5, TimeUnit.SECONDS);
    }

    @Override
    public void onShutdown() {
        this.config.save();
    }
}
