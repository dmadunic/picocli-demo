package io.spotsie.tools;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "goodbye", description = "Say goodbye!")
public class GoodByeCommand implements Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "picocli", description = "Your name.")
    String name;

    @Override
    public void run() {
        System.out.printf("Goodbye %s!\n", name);
    }

}
