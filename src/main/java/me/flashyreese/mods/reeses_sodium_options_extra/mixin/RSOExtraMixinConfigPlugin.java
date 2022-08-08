package me.flashyreese.mods.reeses_sodium_options_extra.mixin;

import net.caffeinemc.caffeineconfig.AbstractCaffeineConfigMixinPlugin;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import net.fabricmc.loader.api.FabricLoader;

public class RSOExtraMixinConfigPlugin extends AbstractCaffeineConfigMixinPlugin {
    private static final String MIXIN_PACKAGE_ROOT = "me.flashyreese.mods.reeses_sodium_options_extra.mixin.";

    @Override
    protected CaffeineConfig createConfig() {
        return CaffeineConfig.builder("Reese's Sodium Options Extra").withSettingsKey("rso-extra:options")
                .addMixinOption("borderless_mining", FabricLoader.getInstance().isModLoaded("borderlessmining"))
                .addMixinOption("cit_resewn", FabricLoader.getInstance().isModLoaded("citresewn"))
                .addMixinOption("colormatic", FabricLoader.getInstance().isModLoaded("colormatic"))
                .addMixinOption("continuity", FabricLoader.getInstance().isModLoaded("continuity"))
                .addMixinOption("dynamic_fps", FabricLoader.getInstance().isModLoaded("dynamicfps"))
                .addMixinOption("ebe", FabricLoader.getInstance().isModLoaded("enhancedblockentities"))
                .addMixinOption("lbg", FabricLoader.getInstance().isModLoaded("lambdabettergrass"))
                .addMixinOption("ldl", FabricLoader.getInstance().isModLoaded("lambdynlights"))

                .withInfoUrl("https://github.com/FlashyReese/reeses-sodium-options-extra/wiki/Configuration-File")
                .build(FabricLoader.getInstance().getConfigDir().resolve("rso-extra.properties"));
    }

    @Override
    protected String mixinPackageRoot() {
        return MIXIN_PACKAGE_ROOT;
    }
}
