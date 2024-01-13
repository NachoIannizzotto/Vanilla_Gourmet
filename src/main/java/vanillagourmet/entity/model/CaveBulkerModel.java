package vanillagourmet.entity.model;

import vanillagourmet.entity.CaveBulkerEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class CaveBulkerModel extends GeoModel<CaveBulkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CaveBulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "animations/cavebulker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CaveBulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "geo/cavebulker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CaveBulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "textures/entities/" + entity.getTexture() + ".png");
	}

}
