package vanillagourmet.procedures;

import vanillagourmet.entity.CaveBulkerEntity;

import net.minecraft.world.entity.Entity;

public class CaveBulkerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CaveBulkerEntity) {
			((CaveBulkerEntity) entity).setAnimation("spawn");
		}
	}
}
