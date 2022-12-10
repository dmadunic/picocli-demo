package io.spotsie.tools;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import io.quarkus.picocli.runtime.annotations.TopCommand;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {GreetingCommand.class, GoodByeCommand.class})
public class PicocliDemo {
    
}
