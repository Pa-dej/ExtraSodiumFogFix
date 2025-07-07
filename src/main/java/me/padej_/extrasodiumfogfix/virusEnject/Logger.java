package me.padej_.extrasodiumfogfix.virusEnject;

import org.slf4j.LoggerFactory;

public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("Extra-Sodium-Fog-Fix");

    public static void info(String message, Object... args) {
        LOGGER.info(message, args);
    }

    public static void warn(String message, Object... args) {
        LOGGER.warn(message, args);
    }

    public static void error(String message, Object... args) {
        LOGGER.error(message, args);
    }

    public static void debug(String message, Object... args) {
        LOGGER.debug(message, args);
    }

    public static void trace(String message, Object... args) {
        LOGGER.trace(message, args);
    }
}
