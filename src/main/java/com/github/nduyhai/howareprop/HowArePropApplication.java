package com.github.nduyhai.howareprop;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@SpringBootApplication
public class HowArePropApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowArePropApplication.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("my-shell>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}

@ShellComponent
class ResourceCommands {

    @Autowired
    private ResourceProperties properties;

    @ShellMethod(value = "Search resource", group = "NDH Corp")
    public String search(@ShellOption(help = "Resource name") String text) {
        return this.properties.getResource().get(text);
    }
}