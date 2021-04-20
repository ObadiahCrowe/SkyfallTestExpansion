package io.obadiah.test;

import io.obadiah.test.command.TestCommand;
import io.obadiah.test.config.TestConfig;
import io.obadiah.test.loader.DatabaseWorldLoader;
import io.skyfallsdk.SkyfallServer;
import io.skyfallsdk.config.LoadableConfig;
import io.skyfallsdk.expansion.Expansion;
import io.skyfallsdk.expansion.ExpansionInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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

        try {
            SkyfallServer server = (SkyfallServer) this.getServer();
            Field field = server.getClass().getDeclaredField("worldLoader");
            field.setAccessible(true);

            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(server, new DatabaseWorldLoader(server, server.getPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("worldLoader class: " + this.getServer().getWorldLoader().getClass());
    }

    @Override
    public void onShutdown() {
        this.config.save();
    }
}
