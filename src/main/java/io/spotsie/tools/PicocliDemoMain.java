package io.spotsie.tools;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class PicocliDemoMain {
    
    public static void main(String... args) {
        Quarkus.run(PicocliDemo.class, args);
    }
}
