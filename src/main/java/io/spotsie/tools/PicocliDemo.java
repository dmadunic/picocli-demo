package io.spotsie.tools;

import picocli.CommandLine;
import javax.inject.Inject;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.spotsie.tools.commands.ProgressCommand;


@TopCommand
@CommandLine.Command(
    mixinStandardHelpOptions = true, 
    subcommands = {
        GreetingCommand.class, 
        GoodByeCommand.class,
        ProgressCommand.class
    }
)
public class PicocliDemo implements Runnable, QuarkusApplication {
    
    @Inject
    CommandLine.IFactory factory; 

    @Override
    public void run() {
        // business logic
        
    }
    

    @Override
    public int run(String... args) throws Exception {
        CommandLine cl = new CommandLine(this, factory);
        cl.setCaseInsensitiveEnumValuesAllowed(true);
        return cl.execute(args);
    }
}
