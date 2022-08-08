package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.cit_resewn;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import shcm.shsupercm.fabric.citresewn.config.CITResewnConfig;

public class CITResewnOptionsStorage implements OptionStorage<CITResewnConfig> {
    private final CITResewnConfig options = CITResewnConfig.INSTANCE;

    @Override
    public CITResewnConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.write();
    }
}
