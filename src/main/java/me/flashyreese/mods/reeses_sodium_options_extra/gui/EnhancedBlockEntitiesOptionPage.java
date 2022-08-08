package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.ebe.EnhancedBlockEntitiesOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.*;
import me.jellysquid.mods.sodium.client.gui.options.control.CyclingControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class EnhancedBlockEntitiesOptionPage {
    public static final EnhancedBlockEntitiesOptionsStorage ebeOpts = new EnhancedBlockEntitiesOptionsStorage();

    public enum AllowedForcedDisabled implements TextProvider {
        ALLOWED("allowed"),
        FORCED("forced"),
        DISABLED("disabled");

        private final Text name;
        private final String value;

        AllowedForcedDisabled(String value) {
            this.name = Text.translatable("value.ebe." + value);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public Text getLocalizedName() {
            return this.name;
        }
    }

    public enum SignTextOptions implements TextProvider {
        SMART("smart"),
        ALL("all"),
        MOST("most"),
        SOME("some"),
        FEW("few");

        private final Text name;
        private final String value;

        SignTextOptions(String value) {
            this.name = Text.translatable("value.ebe." + value);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public Text getLocalizedName() {
            return this.name;
        }
    }

    public static OptionPage ebe() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.render_enhanced_chests"))
                        .setTooltip(Text.translatable("option.ebe.render_enhanced_chests.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderEnhancedChests = value, opts -> opts.renderEnhancedChests)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.chest_ao"))
                        .setTooltip(Text.translatable("option.ebe.chest_ao.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.chestAO = value, opts -> opts.chestAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.experimental_chests"))
                        .setTooltip(Text.translatable("option.ebe.experimental_chests.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.experimentalChests = value, opts -> opts.experimentalChests)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(AllowedForcedDisabled.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.christmas_chests"))
                        .setTooltip(Text.translatable("option.ebe.christmas_chests.comment"))
                        .setControl(opt -> new CyclingControl<>(opt, AllowedForcedDisabled.class))
                        .setBinding((opts, value) -> opts.christmasChests = value.getValue(), opts -> AllowedForcedDisabled.valueOf(opts.christmasChests.toUpperCase()))
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.render_enhanced_signs"))
                        .setTooltip(Text.translatable("option.ebe.render_enhanced_signs.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderEnhancedSigns = value, opts -> opts.renderEnhancedSigns)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.sign_ao"))
                        .setTooltip(Text.translatable("option.ebe.sign_ao.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.signAO = value, opts -> opts.signAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.experimental_signs"))
                        .setTooltip(Text.translatable("option.ebe.experimental_signs.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.experimentalSigns = value, opts -> opts.experimentalSigns)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(SignTextOptions.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.sign_text_rendering"))
                        .setTooltip(Text.translatable("option.ebe.sign_text_rendering.comment"))
                        .setControl(opt -> new CyclingControl<>(opt, SignTextOptions.class))
                        .setBinding((opts, value) -> opts.signTextRendering = value.getValue(), opts -> SignTextOptions.valueOf(opts.signTextRendering.toUpperCase()))
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.render_enhanced_bells"))
                        .setTooltip(Text.translatable("option.ebe.render_enhanced_bells.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderEnhancedBells = value, opts -> opts.renderEnhancedBells)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.bell_ao"))
                        .setTooltip(Text.translatable("option.ebe.bell_ao.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.bellAO = value, opts -> opts.bellAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.render_enhanced_beds"))
                        .setTooltip(Text.translatable("option.ebe.render_enhanced_beds.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderEnhancedBeds = value, opts -> opts.renderEnhancedBeds)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.bed_ao"))
                        .setTooltip(Text.translatable("option.ebe.bed_ao.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.bedAO = value, opts -> opts.bedAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.experimental_beds"))
                        .setTooltip(Text.translatable("option.ebe.experimental_beds.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.experimentalBeds = value, opts -> opts.bellAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.render_enhanced_shulker_boxes"))
                        .setTooltip(Text.translatable("option.ebe.render_enhanced_shulker_boxes.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderEnhancedShulkerBoxes = value, opts -> opts.renderEnhancedShulkerBoxes)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, ebeOpts)
                        .setName(Text.translatable("option.ebe.shulker_box_ao"))
                        .setTooltip(Text.translatable("option.ebe.shulker_box_ao.comment"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.shulkerBoxAO = value, opts -> opts.shulkerBoxAO)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .build());

        return new OptionPage(Text.literal("Enhanced Block Entities"), ImmutableList.copyOf(groups));
    }
}