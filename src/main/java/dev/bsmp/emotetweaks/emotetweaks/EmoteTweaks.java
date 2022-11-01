package dev.bsmp.emotetweaks.emotetweaks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import dev.bsmp.emotetweaks.voicefx.SFXPacket;
import dev.bsmp.emotetweaks.voicefx.SoundPlugin;
import io.github.kosmx.emotes.api.events.client.ClientEmoteEvents;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;

public class EmoteTweaks implements ModInitializer {
    public static HashMap<Integer, String> MODIFIERS = new HashMap<>();
    public static Object2BooleanOpenHashMap<UUID> CROUCH_CANCEL_MAP = new Object2BooleanOpenHashMap<>();

    @Override
    public void onInitialize() {
        MODIFIERS.put(1, "SHIFT");
        MODIFIERS.put(2, "CTRL");
        MODIFIERS.put(4, "L ALT");
        MODIFIERS.put(6, "R ALT");

        ServerPlayNetworking.registerGlobalReceiver(SFXPacket.PACKET_ID, SFXPacket::receiveMessage);
    }

}
