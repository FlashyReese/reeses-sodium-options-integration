package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.dynamic_fps;

import dynamicfps.DynamicFPSConfig;
import dynamicfps.DynamicFPSMod;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class DynamicFPSOptionsStorage implements OptionStorage<DynamicFPSConfig> {
    private final DynamicFPSConfig options = DynamicFPSMod.config;

    @Override
    public DynamicFPSConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.save();
    }
}
