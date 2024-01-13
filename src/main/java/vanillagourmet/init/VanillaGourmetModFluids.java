
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.fluid.ChocolateFluid;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class VanillaGourmetModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, VanillaGourmetMod.MODID);
	public static final RegistryObject<FlowingFluid> CHOCOLATE = REGISTRY.register("chocolate", () -> new ChocolateFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_CHOCOLATE = REGISTRY.register("flowing_chocolate", () -> new ChocolateFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CHOCOLATE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CHOCOLATE.get(), RenderType.translucent());
		}
	}
}
