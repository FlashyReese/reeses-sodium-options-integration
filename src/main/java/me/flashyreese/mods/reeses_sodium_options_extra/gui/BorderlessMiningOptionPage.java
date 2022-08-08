package me.flashyreese.mods.reeses_sodium_options_extra.gui;

import com.google.common.collect.ImmutableList;
import link.infra.borderlessmining.config.ConfigHandler;
import me.flashyreese.mods.reeses_sodium_options_extra.common.util.ControlValueFormatterExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.reeses_sodium_options_extra.gui.options.storage.borderless_mining.BorderlessMiningOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.text.Text;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class BorderlessMiningOptionPage {
    public static final BorderlessMiningOptionsStorage borderlessMiningOpts = new BorderlessMiningOptionsStorage();

    public static OptionPage borderlessMining() {
        List<OptionGroup> groups = new ArrayList<>();

        List<Text> monitorNames = new ArrayList<>();
        monitorNames.add(Text.translatable("config.borderlessmining.general.forcemonitor.current"));
        PointerBuffer monitors = GLFW.glfwGetMonitors();
        if (monitors != null && monitors.limit() >= 1) {
            long monitorHandle;
            while (monitors.hasRemaining()) {
                monitorHandle = monitors.get();
                monitorNames.add(Text.literal(GLFW.glfwGetMonitorName(monitorHandle) + " (" + (monitorNames.size() - 1) + ")"));
            }
        }

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, borderlessMiningOpts)
                        .setName(Text.translatable("config.borderlessmining.general.enabled"))
                        .setTooltip(Text.translatable("config.borderlessmining.general.enabled.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding(ConfigHandler::setEnabledPending, ConfigHandler::isEnabledOrPending)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, borderlessMiningOpts)
                        .setName(Text.translatable("config.borderlessmining.general.videomodeoption"))
                        .setTooltip(Text.translatable("config.borderlessmining.general.videomodeoption.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.addToVanillaVideoSettings = value, opts -> opts.addToVanillaVideoSettings)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, borderlessMiningOpts)
                        .setName(Text.translatable("config.borderlessmining.general.enabledmac"))
                        .setTooltip(Text.translatable("config.borderlessmining.general.enabledmac.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.enableMacOS = value, opts -> opts.enableMacOS)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, borderlessMiningOpts)
                        .setName(Text.translatable("config.borderlessmining.general.forcemonitor"))
                        .setTooltip(Text.translatable("config.borderlessmining.general.forcemonitor.tooltip"))
                        .setControl(option -> new SliderControlExtended(option, 0, monitorNames.size() - 1, 1, ControlValueFormatterExtended.borderlessMiningForceMonitor(monitorNames), false))
                        .setBinding((options, value) -> options.forceWindowMonitor = value, options -> {
                            int currentMonitor = options.forceWindowMonitor + 1;
                            if (currentMonitor < 0) {
                                currentMonitor = 0;
                            }
                            if (monitors == null || monitors.limit() < 1) {
                                currentMonitor = 0;
                            } else {
                                if (options.forceWindowMonitor >= monitors.limit()) {
                                    currentMonitor = 0;
                                }
                            }
                            return currentMonitor;
                        })
                        .build()
                )
                .build());

        // Todo: custom dimension fields needs text box implementation
        return new OptionPage(Text.literal("Borderless Mining"), ImmutableList.copyOf(groups));
    }
}
