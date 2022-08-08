package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.colormatic;

import io.github.kvverti.colormatic.Colormatic;
import io.github.kvverti.colormatic.ColormaticConfig;
import io.github.kvverti.colormatic.ColormaticConfigController;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class ColormaticOptionsStorage implements OptionStorage<ColormaticConfig> {
    private final ColormaticConfig options = Colormatic.config();

    @Override
    public ColormaticConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        ColormaticConfigController.persist(this.options);
    }
}
