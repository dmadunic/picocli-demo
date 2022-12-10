package io.spotsie.tools;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import javax.inject.Inject;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {GreetingCommand.class, GoodByeCommand.class})
public class PicocliDemo implements Runnable, QuarkusApplication {
    
    @Inject
    CommandLine.IFactory factory; 

    @Override
    public void run() {
        // business logic
    }

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this, factory).execute(args);
    }
}
