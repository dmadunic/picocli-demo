package io.spotsie.tools;


import javax.inject.Inject;
import io.spotsie.tools.service.GreetingService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "greeting", mixinStandardHelpOptions = true, description = "Say greeting!")
public class GreetingCommand implements Runnable {

    @Inject 
    GreetingService greetingService;

    @Parameters(paramLabel = "<name>", defaultValue = "picocli", description = "Your name.")
    String name;

    @Override
    public void run() {
        greetingService.sayHello(name);
    }

}
