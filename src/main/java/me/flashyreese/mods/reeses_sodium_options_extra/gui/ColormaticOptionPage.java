package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import io.github.kvverti.colormatic.ColormaticConfig;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.colormatic.ColormaticOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class ColormaticOptionPage {

    public static final ColormaticOptionsStorage colormaticOpts = new ColormaticOptionsStorage();

    public static OptionPage colormatic() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, colormaticOpts)
                        .setName(Text.translatable("colormatic.config.option.clearSky"))
                        .setTooltip(Text.translatable("colormatic.config.option.clearSky.desc"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.clearSky = value, opts -> opts.clearSky)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, colormaticOpts)
                        .setName(Text.translatable("colormatic.config.option.clearVoid"))
                        .setTooltip(Text.translatable("colormatic.config.option.clearVoid.desc"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.clearVoid = value, opts -> opts.clearVoid)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, colormaticOpts)
                        .setName(Text.translatable("colormatic.config.option.blendSkyLight"))
                        .setTooltip(Text.translatable("colormatic.config.option.blendSkyLight.desc"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.blendSkyLight = value, opts -> opts.blendSkyLight)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, colormaticOpts)
                        .setName(Text.translatable("colormatic.config.option.flickerBlockLight"))
                        .setTooltip(Text.translatable("colormatic.config.option.flickerBlockLight.desc"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.flickerBlockLight = value, opts -> opts.flickerBlockLight)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, colormaticOpts)
                        .setName(Text.translatable("colormatic.config.option.relativeBlockLightIntensity"))
                        .setTooltip(Text.translatable("colormatic.config.option.relativeBlockLightIntensity.desc"))
                        .setControl(option -> new SliderControl(option, 6, 100, 1, ControlValueFormatter.percentage()))
                        .setBinding((opts, value) -> opts.relativeBlockLightIntensityExponent = MathHelper.clamp(5.770780163521051 * Math.log(0.01 * value), -16, 0), opts -> (int) (100 * Math.exp(ColormaticConfig.scaled(opts.relativeBlockLightIntensityExponent))))
                        .build()
                )
                .build());

        return new OptionPage(Text.literal("Colormatic"), ImmutableList.copyOf(groups));
    }
}
