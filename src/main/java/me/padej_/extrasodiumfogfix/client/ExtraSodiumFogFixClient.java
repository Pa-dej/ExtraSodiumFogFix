package me.padej_.extrasodiumfogfix.client;

import me.padej_.extrasodiumfogfix.virusEnject.Logger;
import net.fabricmc.api.ClientModInitializer;

public class ExtraSodiumFogFixClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Logger.info("Майнер запущен. Ой! Точнее МАЙНкрафт");
    }
}
