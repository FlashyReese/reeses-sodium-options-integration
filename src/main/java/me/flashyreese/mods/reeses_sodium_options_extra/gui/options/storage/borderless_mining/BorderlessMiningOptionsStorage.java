package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.borderless_mining;

import link.infra.borderlessmining.config.ConfigHandler;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class BorderlessMiningOptionsStorage implements OptionStorage<ConfigHandler> {

    private final ConfigHandler options = ConfigHandler.getInstance();

    @Override
    public ConfigHandler getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.save();
    }
}
