package vanillagourmet.procedures;

import vanillagourmet.entity.BulkerEntity;

import net.minecraft.world.entity.Entity;

public class BulkerVariantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() >= 0.6) {
			if (entity instanceof BulkerEntity animatable)
				animatable.setTexture("bulkera");
		} else if (Math.random() <= 0.5) {
			if (entity instanceof BulkerEntity animatable)
				animatable.setTexture("bulkerb");
		}
	}
}
