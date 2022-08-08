package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.lbg;

import dev.lambdaurora.lambdabettergrass.LBGConfig;
import dev.lambdaurora.lambdabettergrass.LambdaBetterGrass;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class LambdaBetterGrassOptionsStorage implements OptionStorage<LBGConfig> {
    private final LBGConfig options = LambdaBetterGrass.get().config;

    @Override
    public LBGConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        // Autosave
    }
}
