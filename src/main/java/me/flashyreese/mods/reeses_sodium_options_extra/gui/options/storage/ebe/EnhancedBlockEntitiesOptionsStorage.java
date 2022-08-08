package me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.ebe;

import foundationgames.enhancedblockentities.EnhancedBlockEntities;
import foundationgames.enhancedblockentities.config.EBEConfig;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class EnhancedBlockEntitiesOptionsStorage implements OptionStorage<EBEConfig> {
    private final EBEConfig options = EnhancedBlockEntities.CONFIG;

    @Override
    public EBEConfig getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.save();
    }
}
