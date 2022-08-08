package me.flashyreese.mods.reeses_sodium_options_extra.common.util;

import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public interface ControlValueFormatterExtended extends ControlValueFormatter {

    static ControlValueFormatter borderlessMiningForceMonitor(List<Text> monitorNames) {
        return v -> monitorNames.get(v).getString();
    }

    static ControlValueFormatter citResewnCache() {
        return v -> {
            if (v <= 1) {
                return Text.translatable("config.citresewn.cache_ms.ticks." + v).formatted(Formatting.AQUA).getString();
            } else {
                Formatting color = Formatting.DARK_RED;
                if (v <= 40) {
                    color = Formatting.RED;
                }

                if (v <= 20) {
                    color = Formatting.GOLD;
                }

                if (v <= 10) {
                    color = Formatting.DARK_GREEN;
                }

                if (v <= 5) {
                    color = Formatting.GREEN;
                }

                return Text.translatable("config.citresewn.cache_ms.ticks.any", v).formatted(color).getString();
            }
        };
    }

    static ControlValueFormatter framerate() {
        return v -> Text.translatable("options.framerate", v).getString();
    }
}
