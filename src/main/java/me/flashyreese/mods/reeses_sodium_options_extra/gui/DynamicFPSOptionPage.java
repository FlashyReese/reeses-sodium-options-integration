package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.reeses_sodium_options_extra.common.util.ControlValueFormatterExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.dynamic_fps.DynamicFPSOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class DynamicFPSOptionPage {
    public static final DynamicFPSOptionsStorage dynamicFpsOpts = new DynamicFPSOptionsStorage();

    public static OptionPage dynamicFps() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.reduce_when_unfocused"))
                        .setTooltip(Text.translatable("config.dynamicfps.reduce_when_unfocused.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.reduceFPSWhenUnfocused = value, opts -> opts.reduceFPSWhenUnfocused)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.unfocused_fps"))
                        .setTooltip(Text.translatable("config.dynamicfps.unfocused_fps.tooltip"))
                        .setControl(opt -> new SliderControlExtended(opt, 0, 60, 1, ControlValueFormatterExtended.framerate(), false))
                        .setBinding((opts, value) -> opts.unfocusedFPS = value, opts -> opts.unfocusedFPS)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.restore_when_hovered"))
                        .setTooltip(Text.translatable("config.dynamicfps.restore_when_hovered.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.restoreFPSWhenHovered = value, opts -> opts.restoreFPSWhenHovered)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.unfocused_volume"))
                        .setTooltip(Text.translatable("config.dynamicfps.unfocused_volume.tooltip"))
                        .setControl(opt -> new SliderControlExtended(opt, 0, 100, 1, ControlValueFormatter.percentage(), false))
                        .setBinding((opts, value) -> opts.unfocusedVolumeMultiplier = (float)(value / 100), opts -> (int)(opts.unfocusedVolumeMultiplier * 100))
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.hidden_volume"))
                        .setTooltip(Text.translatable("config.dynamicfps.hidden_volume.tooltip"))
                        .setControl(opt -> new SliderControlExtended(opt, 0, 100, 1, ControlValueFormatter.percentage(), false))
                        .setBinding((opts, value) -> opts.hiddenVolumeMultiplier = (float)(value / 100), opts -> (int)(opts.hiddenVolumeMultiplier * 100))
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, dynamicFpsOpts)
                        .setName(Text.translatable("config.dynamicfps.run_gc_on_unfocus"))
                        .setTooltip(Text.translatable("config.dynamicfps.run_gc_on_unfocus.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.runGCOnUnfocus = value, opts -> opts.runGCOnUnfocus)
                        .build()
                )
                .build());

        return new OptionPage(Text.literal("Dynamic FPS"), ImmutableList.copyOf(groups));
    }
}
