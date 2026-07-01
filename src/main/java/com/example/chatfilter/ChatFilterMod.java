package com.example.chatfilter;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatFilterMod implements ClientModInitializer {
    public static final String MOD_ID = "chatfilter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Chat Filter loaded - 'fuck' will be replaced with 'frick' in outgoing chat messages.");
    }
}
