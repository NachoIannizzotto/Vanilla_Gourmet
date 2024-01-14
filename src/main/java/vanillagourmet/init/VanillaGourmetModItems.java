
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.item.VanillagourmetItem;
import vanillagourmet.item.ChocolateItem;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class VanillaGourmetModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaGourmetMod.MODID);
	public static final RegistryObject<Item> CHOCOLATEBLOCK = block(VanillaGourmetModBlocks.CHOCOLATEBLOCK);
	public static final RegistryObject<Item> CANDYBLOCK = block(VanillaGourmetModBlocks.CANDYBLOCK);
	public static final RegistryObject<Item> CHOCOLATE_BUCKET = REGISTRY.register("chocolate_bucket", () -> new ChocolateItem());
	public static final RegistryObject<Item> VANILLAGOURMET = REGISTRY.register("vanillagourmet", () -> new VanillagourmetItem());
	public static final RegistryObject<Item> BULKER_SPAWN_EGG = REGISTRY.register("bulker_spawn_egg", () -> new ForgeSpawnEggItem(VanillaGourmetModEntities.BULKER, -16750900, -16711681, new Item.Properties()));
	public static final RegistryObject<Item> CAVE_BULKER_SPAWN_EGG = REGISTRY.register("cave_bulker_spawn_egg", () -> new ForgeSpawnEggItem(VanillaGourmetModEntities.CAVE_BULKER, -16751002, -16777165, new Item.Properties()));
	public static final RegistryObject<Item> JUMP_SPIDER_SPAWN_EGG = REGISTRY.register("jump_spider_spawn_egg", () -> new ForgeSpawnEggItem(VanillaGourmetModEntities.JUMP_SPIDER, -10092544, -1, new Item.Properties()));
	public static final RegistryObject<Item> ABOMINATION_SPAWN_EGG = REGISTRY.register("abomination_spawn_egg", () -> new ForgeSpawnEggItem(VanillaGourmetModEntities.ABOMINATION, -16764007, -16777216, new Item.Properties()));

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
