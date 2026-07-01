package com.example.chatfilter.mixin;

import com.example.chatfilter.ChatFilter;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPacketListener.class)
public class ChatFilterMixin {

    @ModifyVariable(
        method = "sendChat(Ljava/lang/String;)V", // Precise descriptor matching production
        at = @At("HEAD"),
        argsOnly = true
    )
    private String chatfilter$filterOutgoingMessage(String content) {
        return ChatFilter.filter(content);
    }
}