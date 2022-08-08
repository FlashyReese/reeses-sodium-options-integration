package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import dev.lambdaurora.lambdabettergrass.LBGConfig;
import dev.lambdaurora.lambdabettergrass.LBGMode;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.lbg.LambdaBetterGrassOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.CyclingControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class LambdaBetterGrassOptionPage {
    public static final LambdaBetterGrassOptionsStorage lbgOpts = new LambdaBetterGrassOptionsStorage();

    public static OptionPage lbg() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(LBGMode.class, lbgOpts)
                        .setName(Text.translatable("lambdabettergrass.option.mode"))
                        .setTooltip(Text.translatable("lambdabettergrass.tooltip.mode",
                                LBGMode.OFF.getTranslatedText(),
                                LBGMode.FASTEST.getTranslatedText(),
                                LBGMode.FAST.getTranslatedText(),
                                LBGMode.FANCY.getTranslatedText()))
                        .setControl(opt -> new CyclingControl<>(opt, LBGMode.class, new Text[]{
                                LBGMode.OFF.getTranslatedText(),
                                LBGMode.FASTEST.getTranslatedText(),
                                LBGMode.FAST.getTranslatedText(),
                                LBGMode.FANCY.getTranslatedText()}))
                        .setBinding(LBGConfig::setMode, LBGConfig::getMode)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, lbgOpts)
                        .setName(Text.translatable("lambdabettergrass.option.better_snow"))
                        .setTooltip(Text.translatable("lambdabettergrass.tooltip.better_snow"))
                        .setControl(TickBoxControl::new)
                        .setBinding(LBGConfig::setBetterLayer, LBGConfig::hasBetterLayer)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());

        return new OptionPage(Text.literal("LambdaBetterGrass"), ImmutableList.copyOf(groups));
    }
}