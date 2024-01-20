package vanillagourmet.entity.model;

import vanillagourmet.entity.KreeperEntity;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class KreeperModel extends GeoModel<KreeperEntity> {
	@Override
	public ResourceLocation getAnimationResource(KreeperEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "animations/kreeper.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KreeperEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "geo/kreeper.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KreeperEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(KreeperEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head1");
		if (head != null) {
			int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
