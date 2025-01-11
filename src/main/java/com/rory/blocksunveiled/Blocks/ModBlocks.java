package com.rory.blocksunveiled.Blocks;

import com.nimbusds.jose.util.Resource;
import com.rory.blocksunveiled.Blocks.Custom.SmelteryBlock;
import com.rory.blocksunveiled.Items.ModItems;
import com.rory.blocksunveiled.Main;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> ALPHORITE_BLOCK =  registerBlock("alphorite_block",
            ()->new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:alphorite_block")))));
    public static final RegistryObject<Block> RAW_ALPHORITE_BLOCK = registerBlock("raw_alphorite_block",
            ()->new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.BAMBOO_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:raw_alphorite_block")))));
    public static final RegistryObject<Block> ALPHORITE_ORE = registerBlock("alphorite_ore",
            ()->new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:alphorite_ore")))));
    public static final RegistryObject<Block> ALPHORITE_DEEPSLATE_ORE = registerBlock("alphorite_deepslate_ore",
            ()->new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:alphorite_deepslate_ore")))));
    public static final RegistryObject<Block> CHISELED_ALPHORITE = registerBlock("chiseled_alphorite",
            ()->new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:chiseled_alphorite")))));
    public static final RegistryObject<Block> SMELTERY = registerBlock("smeltery",
            ()-> new SmelteryBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("blocksunveiled:smeltery")))));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,()-> new BlockItem(block.get(), new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("blocksunveiled:"+name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
