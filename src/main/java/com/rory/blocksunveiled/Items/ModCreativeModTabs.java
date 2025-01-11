package com.rory.blocksunveiled.Items;

import com.rory.blocksunveiled.Blocks.ModBlocks;
import com.rory.blocksunveiled.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODS_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final RegistryObject<CreativeModeTab> ALPHORITE_TAB = CREATIVE_MODS_TABS.register("alphorite_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.ALPHORITE.get()))
                    .title(Component.translatable("creativetab.blocksunveiled.alphorite"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALPHORITE.get());
                        output.accept(ModItems.RAW_ALPHORITE.get());
                        output.accept(ModBlocks.ALPHORITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALPHORITE_BLOCK.get());
                        output.accept(ModBlocks.ALPHORITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.ALPHORITE_ORE.get());
                        output.accept(ModBlocks.CHISELED_ALPHORITE.get());
                        output.accept(ModItems.ALPHORITE_CHISEL.get());
                        output.accept(ModBlocks.SMELTERY.get());
                        output.accept(ModItems.ALPHORITE_MEAT.get());
                    })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODS_TABS.register(eventBus);
    }
}
