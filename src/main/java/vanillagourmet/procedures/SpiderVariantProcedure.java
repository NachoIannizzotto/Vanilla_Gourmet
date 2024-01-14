package vanillagourmet.procedures;

import vanillagourmet.entity.JumpSpiderEntity;

import net.minecraft.world.entity.Entity;

public class SpiderVariantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() >= 0.2) {
			if (entity instanceof JumpSpiderEntity animatable)
				animatable.setTexture("jumpspidera");
		} else if (Math.random() <= 0.1) {
			if (entity instanceof JumpSpiderEntity animatable)
				animatable.setTexture("jumpspiderb");
		}
	}
}
