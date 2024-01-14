
package vanillagourmet.client.renderer;

import vanillagourmet.entity.model.AbominationModel;
import vanillagourmet.entity.layer.AbominationLayer;
import vanillagourmet.entity.AbominationEntity;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AbominationRenderer extends GeoEntityRenderer<AbominationEntity> {
	public AbominationRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AbominationModel());
		this.shadowRadius = 0.8f;
		this.addRenderLayer(new AbominationLayer(this));
	}

	@Override
	public RenderType getRenderType(AbominationEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AbominationEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
