package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.reeses_sodium_options_extra.common.util.ControlValueFormatterExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.cit_resewn.CITResewnOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CITResewnOptionPage {
    public static final CITResewnOptionsStorage citResewnOpts = new CITResewnOptionsStorage();

    public static OptionPage citResewn() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, citResewnOpts)
                        .setName(Text.translatable("config.citresewn.enabled.title"))
                        .setTooltip(Text.translatable("config.citresewn.enabled.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.enabled = value, opts -> opts.enabled)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, citResewnOpts)
                        .setName(Text.translatable("config.citresewn.mute_errors.title"))
                        .setTooltip(Text.translatable("config.citresewn.mute_errors.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.mute_errors = value, opts -> opts.mute_errors)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, citResewnOpts)
                        .setName(Text.translatable("config.citresewn.mute_warns.title"))
                        .setTooltip(Text.translatable("config.citresewn.mute_warns.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.mute_warns = value, opts -> opts.mute_warns)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, citResewnOpts)
                        .setName(Text.translatable("config.citresewn.cache_ms.title"))
                        .setTooltip(Text.translatable("config.citresewn.cache_ms.tooltip"))
                        .setControl(opt-> new SliderControlExtended(opt, 0, 100, 1, ControlValueFormatterExtended.citResewnCache(), false))
                        .setBinding((opts, value) -> opts.cache_ms = value * 50, opts -> opts.cache_ms / 50)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, citResewnOpts)
                        .setName(Text.translatable("config.citresewn.broken_paths.title"))
                        .setTooltip(Text.translatable("config.citresewn.broken_paths.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.broken_paths = value, opts -> opts.broken_paths)
                        .build()
                )
                .build());
        // Todo: missing textbox editor
        return new OptionPage(Text.literal("CIT Resewn"), ImmutableList.copyOf(groups));
    }
}
