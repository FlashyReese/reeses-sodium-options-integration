package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.binding.compat;

import dev.lambdaurora.lambdynlights.DynamicLightsConfig;
import dev.lambdaurora.lambdynlights.config.BooleanSettingEntry;
import me.jellysquid.mods.sodium.client.gui.options.binding.OptionBinding;

public class LambDynamicLightsBooleanSettingEntryBinding implements OptionBinding<DynamicLightsConfig, Boolean> {
    private final BooleanSettingEntry option;

    public LambDynamicLightsBooleanSettingEntryBinding(BooleanSettingEntry option) {
        this.option = option;
    }

    @Override
    public void setValue(DynamicLightsConfig storage, Boolean value) {
        this.option.set(value);
    }

    @Override
    public Boolean getValue(DynamicLightsConfig storage) {
        return this.option.get();
    }
}

