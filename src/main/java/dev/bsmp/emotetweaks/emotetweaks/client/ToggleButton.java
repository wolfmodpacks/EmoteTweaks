package dev.bsmp.emotetweaks.emotetweaks.client;

import net.minecraft.text.LiteralText;

import java.util.UUID;

import dev.bsmp.emotetweaks.emotetweaks.EmoteTweaks;
import dev.bsmp.emotetweaks.emotetweaks.IEmoteScreen;
import io.github.kosmx.emotes.arch.gui.screen.IButtonImpl;
import io.github.kosmx.emotes.executor.dataTypes.Text;
import io.github.kosmx.emotes.main.screen.EmoteMenu;

public class ToggleButton extends IButtonImpl {
    public EmoteMenu parent;
    private boolean currentState = false;

    public ToggleButton(EmoteMenu parent, int x, int y, int width, int height, boolean state) {
        super(x, y, width, height, new LiteralText(""+state), null);
        this.currentState = state;
        this.parent = parent;
    }

    @Override
    public void onPress() {
        setCurrentState(!currentState);
    }

    public void setCurrentState(boolean newState) {
        currentState = newState;
        parent.save = true;
        setMessage(new LiteralText(""+currentState));
        UUID uuid = ((IEmoteScreen)parent).getEmoteList().getSelectedEntry().getEmote().getUuid();
        EmoteTweaks.CROUCH_CANCEL_MAP.put(uuid, currentState);
    }

    public boolean getCurrentState() {
        return currentState;
    }
}
