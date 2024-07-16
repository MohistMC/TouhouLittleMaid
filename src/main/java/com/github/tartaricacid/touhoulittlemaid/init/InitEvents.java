package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.event.EnterServerEvent;
import com.github.tartaricacid.touhoulittlemaid.event.EntityHurtEvent;
import com.github.tartaricacid.touhoulittlemaid.event.EntityJoinWorldEvent;
import com.github.tartaricacid.touhoulittlemaid.event.MaidMealRegConfigEvent;

public class InitEvents {
    
    public static void init() {
        EntityHurtEvent.onArrowImpact();
        MaidMealRegConfigEvent.onEvent();
        EntityJoinWorldEvent.onEvent();
        EnterServerEvent.onAttachCapabilityEvent();
    }
}
