
package vanillagourmet.client.renderer;

import vanillagourmet.entity.model.CaveBulkerModel;
import vanillagourmet.entity.CaveBulkerEntity;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CaveBulkerRenderer extends GeoEntityRenderer<CaveBulkerEntity> {
	public CaveBulkerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CaveBulkerModel());
		this.shadowRadius = 0.8f;
	}

	@Override
	public RenderType getRenderType(CaveBulkerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CaveBulkerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1.2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(CaveBulkerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
