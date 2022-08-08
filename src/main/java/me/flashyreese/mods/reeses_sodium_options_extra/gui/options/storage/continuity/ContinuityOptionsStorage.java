package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.continuity;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import me.pepperbell.continuity.client.config.ContinuityConfig;

public class ContinuityOptionsStorage implements OptionStorage<ContinuityConfig> {
    private final ContinuityConfig options = ContinuityConfig.INSTANCE;

    @Override
    public ContinuityConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.save();
    }
}
