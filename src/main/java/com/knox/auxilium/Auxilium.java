package com.knox.auxilium;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.knox.auxilium.item.ModItems;
import com.knox.auxilium.item.ModEvents;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Auxilium.MODID)
public class Auxilium {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "auxilium";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "auxilium" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "auxilium" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "auxilium" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "auxilium:auxilium_tab" for all mod items
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AUXILIUM_TAB = CREATIVE_MODE_TABS.register("auxilium_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.auxilium"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.IRON_BATTLE_AXE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // Battle Axes
                output.accept(ModItems.IRON_BATTLE_AXE.get());
                output.accept(ModItems.GOLDEN_BATTLE_AXE.get());
                output.accept(ModItems.DIAMOND_BATTLE_AXE.get());
                output.accept(ModItems.NETHERITE_BATTLE_AXE.get());
                // Daggers
                output.accept(ModItems.IRON_DAGGER.get());
                output.accept(ModItems.GOLDEN_DAGGER.get());
                output.accept(ModItems.DIAMOND_DAGGER.get());
                output.accept(ModItems.NETHERITE_DAGGER.get());
                // Shields
                output.accept(ModItems.IRON_SHIELD.get());
                output.accept(ModItems.GOLDEN_SHIELD.get());
                output.accept(ModItems.DIAMOND_SHIELD.get());
                output.accept(ModItems.NETHERITE_SHIELD.get());
                output.accept(ModItems.IRON_LIGHT_SHIELD.get());
                output.accept(ModItems.GOLDEN_LIGHT_SHIELD.get());
                output.accept(ModItems.DIAMOND_LIGHT_SHIELD.get());
                output.accept(ModItems.NETHERITE_LIGHT_SHIELD.get());
                // Scythes
                output.accept(ModItems.IRON_SCYTHE.get());
                output.accept(ModItems.GOLDEN_SCYTHE.get());
                output.accept(ModItems.DIAMOND_SCYTHE.get());
                output.accept(ModItems.NETHERITE_SCYTHE.get());
                // Multi-tools
                output.accept(ModItems.IRON_MULTI_TOOL.get());
                output.accept(ModItems.GOLDEN_MULTI_TOOL.get());
                output.accept(ModItems.DIAMOND_MULTI_TOOL.get());
                output.accept(ModItems.NETHERITE_MULTI_TOOL.get());
                // Backpacks
                output.accept(ModItems.LEATHER_BACKPACK.get());
                output.accept(ModItems.IRON_BACKPACK.get());
                output.accept(ModItems.GOLDEN_BACKPACK.get());
                output.accept(ModItems.DIAMOND_BACKPACK.get());
                output.accept(ModItems.NETHERITE_BACKPACK.get());
                // Improved Totems
                output.accept(ModItems.DIAMOND_TOTEM.get());
                output.accept(ModItems.NETHERITE_TOTEM.get());
                // Great Swords
                output.accept(ModItems.IRON_GREAT_SWORD.get());
                output.accept(ModItems.GOLDEN_GREAT_SWORD.get());
                output.accept(ModItems.DIAMOND_GREAT_SWORD.get());
                output.accept(ModItems.NETHERITE_GREAT_SWORD.get());
                // Katars
                output.accept(ModItems.IRON_KATAR.get());
                output.accept(ModItems.GOLDEN_KATAR.get());
                output.accept(ModItems.DIAMOND_KATAR.get());
                output.accept(ModItems.NETHERITE_KATAR.get());
                // Katanas
                output.accept(ModItems.IRON_KATANA.get());
                output.accept(ModItems.GOLDEN_KATANA.get());
                output.accept(ModItems.DIAMOND_KATANA.get());
                output.accept(ModItems.NETHERITE_KATANA.get());
                // Spears
                output.accept(ModItems.IRON_SPEAR.get());
                output.accept(ModItems.GOLDEN_SPEAR.get());
                output.accept(ModItems.DIAMOND_SPEAR.get());
                output.accept(ModItems.NETHERITE_SPEAR.get());
                // Scimitars
                output.accept(ModItems.IRON_SCIMITAR.get());
                output.accept(ModItems.GOLDEN_SCIMITAR.get());
                output.accept(ModItems.DIAMOND_SCIMITAR.get());
                output.accept(ModItems.NETHERITE_SCIMITAR.get());
                // Great Bow
                output.accept(ModItems.GREAT_BOW.get());
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Auxilium(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Registers to the mod event bus
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        
        // Register our custom items
        ModItems.ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
        LOGGER.info("Auxilium mod loaded! Created by Knox");
        LOGGER.info("Added: Battle Axes, Daggers, Enhanced Shields, Scythes, Multi-tools, Backpacks, Improved Totems, Great Swords, Katars, Katanas, Spears, Scimitars, Great Bow");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP - AUXILIUM");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            // No blocks yet
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting - AUXILIUM");
    }
}
