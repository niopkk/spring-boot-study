package com.bbz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Welcomer {

    private static final Logger logger = LoggerFactory.getLogger(Welcomer.class);

    private String welcomeText;

    public void initWelcomer() {
        logger.info("Welcomer is initialized");
    }

    public void setWelcomeText(String welcomeText) {
        logger.info("Setting welcomeText to: "+welcomeText);
        this.welcomeText = welcomeText;
    }

    public String getWelcomeText() {
        return this.welcomeText;
    }

    @Override
    public String toString() {
        return "Welcomer {text: "+this.welcomeText+"}";
    }
}
