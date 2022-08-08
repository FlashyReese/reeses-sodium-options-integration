package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.continuity.ContinuityOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ContinuityOptionPage {
    public static final ContinuityOptionsStorage continuityOpts = new ContinuityOptionsStorage();

    public static OptionPage continuity() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, continuityOpts)
                        .setName(Text.translatable("options.continuity.connected_textures"))
                        .setTooltip(Text.translatable("options.continuity.connected_textures.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.connectedTextures.set(value), opts -> opts.connectedTextures.get())
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, continuityOpts)
                        .setName(Text.translatable("options.continuity.emissive_textures"))
                        .setTooltip(Text.translatable("options.continuity.emissive_textures.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.emissiveTextures.set(value), opts -> opts.emissiveTextures.get())
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, continuityOpts)
                        .setName(Text.translatable("options.continuity.custom_block_layers"))
                        .setTooltip(Text.translatable("options.continuity.custom_block_layers.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.customBlockLayers.set(value), opts -> opts.customBlockLayers.get())
                        .build()
                )
                .build());

        return new OptionPage(Text.literal("Continuity"), ImmutableList.copyOf(groups));
    }
}
