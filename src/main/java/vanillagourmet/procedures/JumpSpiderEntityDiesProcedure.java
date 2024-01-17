package vanillagourmet.procedures;

import vanillagourmet.entity.JumpSpiderEntity;

import net.minecraft.world.entity.Entity;

public class JumpSpiderEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof JumpSpiderEntity) {
			((JumpSpiderEntity) entity).setAnimation("empty");
		}
	}
}
