
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.client.renderer.KreeperRenderer;
import vanillagourmet.client.renderer.JumpSpiderRenderer;
import vanillagourmet.client.renderer.GooseRenderer;
import vanillagourmet.client.renderer.CaveBulkerRenderer;
import vanillagourmet.client.renderer.BulkerRenderer;
import vanillagourmet.client.renderer.AbominationRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VanillaGourmetModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(VanillaGourmetModEntities.BULKER.get(), BulkerRenderer::new);
		event.registerEntityRenderer(VanillaGourmetModEntities.CAVE_BULKER.get(), CaveBulkerRenderer::new);
		event.registerEntityRenderer(VanillaGourmetModEntities.JUMP_SPIDER.get(), JumpSpiderRenderer::new);
		event.registerEntityRenderer(VanillaGourmetModEntities.ABOMINATION.get(), AbominationRenderer::new);
		event.registerEntityRenderer(VanillaGourmetModEntities.GOOSE.get(), GooseRenderer::new);
		event.registerEntityRenderer(VanillaGourmetModEntities.KREEPER.get(), KreeperRenderer::new);
	}
}
