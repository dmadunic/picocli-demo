package io.spotsie.tools.config;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.notch.utils.shell.progress.ProgressBar;
import com.notch.utils.shell.progress.ProgressCounter;

@Singleton
public class ShellToolsConfig {
    
    @Produces
    @ApplicationScoped
    public Terminal terminal() throws IOException {
        Terminal terminal = TerminalBuilder.builder().build();
        return terminal;
    }
    
    @Produces
    @ApplicationScoped
    public ProgressCounter progressCounter(Terminal terminal) {
        ProgressCounter pc = new ProgressCounter(terminal);
        return pc;
    }

    @Produces
    @ApplicationScoped
    public ProgressBar progressBar(Terminal terminal) {
        ProgressBar pb = new ProgressBar(terminal);
        return pb;
    }
}
