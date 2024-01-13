package vanillagourmet.entity.model;

import vanillagourmet.entity.BulkerEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class BulkerModel extends GeoModel<BulkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "animations/bulker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "geo/bulker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BulkerEntity entity) {
		return new ResourceLocation("vanilla_gourmet", "textures/entities/" + entity.getTexture() + ".png");
	}

}
