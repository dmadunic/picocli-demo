package io.spotsie.tools.commands;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import com.notch.utils.shell.Chalk;
import com.notch.utils.shell.progress.ProgressBar;
import com.notch.utils.shell.progress.ProgressCounter;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * 
 * @author dmadunic
 */
@CommandLine.Command(name = "counter", description = "Progress demo command")
public class ProgressCommand implements Runnable {
    private final Logger log = Logger.getLogger(ProgressCommand.class);

    @Inject 
    ProgressCounter pc;

    @Inject
    ProgressBar pb;

    @Parameters(paramLabel = "<countTo>", defaultValue = "60", description = "Number of seconds to count (min 10)")
    int countTo;

    @ArgGroup(exclusive = true, multiplicity = "1")
    Exclusive exclusive;

    static class Exclusive {
        @Option(names = "-c", required = true, description = "Display progress as counter") boolean counter;
        @Option(names = "-p", required = true, description = "Display progress as bar") boolean progressBas;
    }

    String messagePattern = "Progress: %d|%d";

    @Override
    public void run() {
        if (exclusive.counter) {
            displayCounter();
        } else {
            displayProgressBar();
        }        
    }

    protected void displayCounter() {
        for (int i=0; i<countTo;i++) {
            String message = Chalk.yellow("%c ", true) + String.format(messagePattern, i, countTo);
            pc.display(message);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                log.debug(ie);
            }
        }
    }

    protected void displayProgressBar() {
        for (int i=0; i<countTo;i++) {
            int pp = i*100/countTo;
            pb.display(pp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                log.debug(ie);
            }
        }
    }
    
}
