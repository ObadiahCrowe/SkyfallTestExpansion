package io.obadiah.test.command;

import io.obadiah.test.ExpansionTest;
import io.skyfallsdk.Server;
import io.skyfallsdk.command.options.*;
import io.skyfallsdk.command.parameter.service.Service;
import io.skyfallsdk.server.CommandSender;

@Command(name = "skyfalltest", desc = "Test Expansion command.")
@Alias(value = { "abc" })
@Permission(value = "test.test")
public class TestCommand {

    @CommandExecutor
    public void onCommandExecute(@Sender CommandSender sender, @Service ExpansionTest test, @Service Server server) {
        server.getLogger(test).info("this is a test command's output in Skyfall via Expansion: " + test.getInfo().name() + ":" + test.getInfo().version());
    }
}
