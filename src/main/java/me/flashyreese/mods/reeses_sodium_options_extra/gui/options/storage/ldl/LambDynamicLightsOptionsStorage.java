package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.ldl;

import dev.lambdaurora.lambdynlights.DynamicLightsConfig;
import dev.lambdaurora.lambdynlights.LambDynLights;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class LambDynamicLightsOptionsStorage implements OptionStorage<DynamicLightsConfig> {
    private final DynamicLightsConfig options = LambDynLights.get().config;

    @Override
    public DynamicLightsConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.save();
    }
}
