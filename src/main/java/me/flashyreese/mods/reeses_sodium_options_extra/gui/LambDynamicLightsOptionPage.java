package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import dev.lambdaurora.lambdynlights.DynamicLightsConfig;
import dev.lambdaurora.lambdynlights.DynamicLightsMode;
import dev.lambdaurora.lambdynlights.ExplosiveLightingMode;
import dev.lambdaurora.lambdynlights.accessor.DynamicLightHandlerHolder;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.ldl.LambDynamicLightsOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.CyclingControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambDynamicLightsOptionPage {
    public static final LambDynamicLightsOptionsStorage ldlOpts = new LambDynamicLightsOptionsStorage();

    public static OptionPage ldl() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(DynamicLightsMode.class, ldlOpts)
                        .setName(Text.translatable("lambdynlights.option.mode"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.mode.1")
                                .append(Text.literal("\n"))
                                .append(Text.translatable("lambdynlights.tooltip.mode.2", DynamicLightsMode.FASTEST.getTranslatedText(), DynamicLightsMode.FAST.getTranslatedText()))
                                .append(Text.literal("\n")).append(Text.translatable("lambdynlights.tooltip.mode.3", DynamicLightsMode.FANCY.getTranslatedText())))
                        .setControl(opt -> new CyclingControl<>(opt, DynamicLightsMode.class, new Text[]{
                                DynamicLightsMode.OFF.getTranslatedText(),
                                DynamicLightsMode.FASTEST.getTranslatedText(),
                                DynamicLightsMode.FAST.getTranslatedText(),
                                DynamicLightsMode.FANCY.getTranslatedText()}))
                        .setBinding(DynamicLightsConfig::setDynamicLightsMode, DynamicLightsConfig::getDynamicLightsMode)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ldlOpts)
                        .setName(Text.translatable("lambdynlights.option.light_sources.entities"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.entities"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opt, value) -> opt.getEntitiesLightSource().set(value), opt -> opt.getEntitiesLightSource().get())
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ldlOpts)
                        .setName(Text.translatable("lambdynlights.option.light_sources.block_entities"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.block_entities"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opt, value) -> opt.getBlockEntitiesLightSource().set(value), opt -> opt.getBlockEntitiesLightSource().get())
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ldlOpts)
                        .setName(Text.translatable("lambdynlights.option.light_sources.water_sensitive_check"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.water_sensitive"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opt, value) -> opt.getBlockEntitiesLightSource().set(value), opt -> opt.getBlockEntitiesLightSource().get())
                        .build()
                )
                .add(OptionImpl.createBuilder(ExplosiveLightingMode.class, ldlOpts)
                        .setName(Text.translatable("entity.minecraft.creeper"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.creeper_lighting"))
                        .setControl(opt -> new CyclingControl<>(opt, ExplosiveLightingMode.class, new Text[]{
                                ExplosiveLightingMode.OFF.getTranslatedText(),
                                ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                ExplosiveLightingMode.FANCY.getTranslatedText()}))
                        .setBinding(DynamicLightsConfig::setCreeperLightingMode, DynamicLightsConfig::getCreeperLightingMode)
                        .build()
                )
                .add(OptionImpl.createBuilder(ExplosiveLightingMode.class, ldlOpts)
                        .setName(Text.translatable("block.minecraft.tnt"))
                        .setTooltip(Text.translatable("lambdynlights.tooltip.tnt_lighting"))
                        .setControl(opt -> new CyclingControl<>(opt, ExplosiveLightingMode.class, new Text[]{
                                ExplosiveLightingMode.OFF.getTranslatedText(),
                                ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                ExplosiveLightingMode.FANCY.getTranslatedText()}))
                        .setBinding(DynamicLightsConfig::setTntLightingMode, DynamicLightsConfig::getTntLightingMode)
                        .build()
                )
                .build());

        OptionGroup.Builder groupImp = OptionGroup.createBuilder();
        Registry.ENTITY_TYPE.stream().map(DynamicLightHandlerHolder::cast).collect(Collectors.toList()).forEach(dynamicLightHandlerHolder -> groupImp.add(OptionImpl.createBuilder(boolean.class, ldlOpts)
                .setName(dynamicLightHandlerHolder.lambdynlights$getName())
                .setTooltip(Text.translatable(""))
                .setControl(TickBoxControl::new)
                .setBinding((opt, value) -> dynamicLightHandlerHolder.lambdynlights$getSetting().set(value), opt -> dynamicLightHandlerHolder.lambdynlights$getSetting().get())
                .build()));
        groups.add(groupImp.build());

        OptionGroup.Builder groupImp2 = OptionGroup.createBuilder();
        Registry.BLOCK_ENTITY_TYPE.stream().map(DynamicLightHandlerHolder::cast).collect(Collectors.toList()).forEach(dynamicLightHandlerHolder -> groupImp2.add(OptionImpl.createBuilder(boolean.class, ldlOpts)
                .setName(dynamicLightHandlerHolder.lambdynlights$getName())
                .setTooltip(Text.translatable(""))
                .setControl(TickBoxControl::new)
                .setBinding((opt, value) -> dynamicLightHandlerHolder.lambdynlights$getSetting().set(value), opt -> dynamicLightHandlerHolder.lambdynlights$getSetting().get())
                .build()));
        groups.add(groupImp2.build());

        return new OptionPage(Text.literal("LambDynamicLights"), ImmutableList.copyOf(groups));
    }
}