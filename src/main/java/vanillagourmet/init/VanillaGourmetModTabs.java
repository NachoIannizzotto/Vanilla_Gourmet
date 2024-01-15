
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VanillaGourmetModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VanillaGourmetMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(VanillaGourmetModBlocks.CHOCOLATEBLOCK.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(VanillaGourmetModItems.BULKER_SPAWN_EGG.get());
			tabData.accept(VanillaGourmetModItems.CAVE_BULKER_SPAWN_EGG.get());
			tabData.accept(VanillaGourmetModItems.JUMP_SPIDER_SPAWN_EGG.get());
			tabData.accept(VanillaGourmetModItems.ABOMINATION_SPAWN_EGG.get());
			tabData.accept(VanillaGourmetModItems.GOOSE_SPAWN_EGG.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(VanillaGourmetModItems.CHOCOLATE_BUCKET.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(VanillaGourmetModBlocks.CANDYBLOCK.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(VanillaGourmetModItems.VANILLAGOURMET.get());
		}
	}
}
