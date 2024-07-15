package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.client.sound.data.MaidSoundInstance;
import com.github.tartaricacid.touhoulittlemaid.config.subconfig.InGameMaidConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MaidSoundFreqEvent {
    @SubscribeEvent
    public static void onPlaySoundEvent(PlaySoundEvent event) {
        if (event.getSound() instanceof MaidSoundInstance maidSoundInstance) {
            double soundFrequency = InGameMaidConfig.INSTANCE.getSoundFrequency();
            if (soundFrequency < 1 && !maidSoundInstance.isTestSound()) {
                if (Math.random() > soundFrequency) {
                    event.setSound(null);
                }
            }
        }
    }
}