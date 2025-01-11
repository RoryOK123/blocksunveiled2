package com.rory.blocksunveiled.Items;

import com.rory.blocksunveiled.Items.Consumables.ModFoodConsumables;
import com.rory.blocksunveiled.Items.Consumables.ModFoodProperties;
import com.rory.blocksunveiled.Items.Custom.ChiselItem;
import com.rory.blocksunveiled.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final RegistryObject<Item> ALPHORITE = ITEMS.register("alphorite",()-> new Item(new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("blocksunveiled:alphorite")))));
    public static final RegistryObject<Item> RAW_ALPHORITE = ITEMS.register("raw_alphorite",()->new Item(new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("blocksunveiled:raw_alphorite")))));
    public static final RegistryObject<Item> ALPHORITE_CHISEL = ITEMS.register("alphorite_chisel",()->new ChiselItem(new Item.Properties().durability(32).useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("blocksunveiled:alphorite_chisel")))));
    public static final RegistryObject<Item> ALPHORITE_MEAT = ITEMS.register("alphorite_meat",()->new Item(new Item.Properties().food(ModFoodProperties.ALPHORITE_MEAT, ModFoodConsumables.ALPHORITE_MEAT).useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("blocksunveiled:alphorite_meat")))));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
