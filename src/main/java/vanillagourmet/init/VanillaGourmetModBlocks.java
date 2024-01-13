
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.block.VanillagourmetPortalBlock;
import vanillagourmet.block.ChocolateblockBlock;
import vanillagourmet.block.ChocolateBlock;
import vanillagourmet.block.CandyblockBlock;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class VanillaGourmetModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaGourmetMod.MODID);
	public static final RegistryObject<Block> CHOCOLATEBLOCK = REGISTRY.register("chocolateblock", () -> new ChocolateblockBlock());
	public static final RegistryObject<Block> CANDYBLOCK = REGISTRY.register("candyblock", () -> new CandyblockBlock());
	public static final RegistryObject<Block> CHOCOLATE = REGISTRY.register("chocolate", () -> new ChocolateBlock());
	public static final RegistryObject<Block> VANILLAGOURMET_PORTAL = REGISTRY.register("vanillagourmet_portal", () -> new VanillagourmetPortalBlock());
}
