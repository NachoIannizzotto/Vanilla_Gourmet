package vanillagourmet.procedures;

import vanillagourmet.entity.GooseEntity;

import net.minecraft.world.entity.Entity;

public class GooseCallProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof GooseEntity _datEntI ? _datEntI.getEntityData().get(GooseEntity.DATA_gooseState) : 0) == 1) {
			return true;
		} else if ((entity instanceof GooseEntity _datEntI ? _datEntI.getEntityData().get(GooseEntity.DATA_gooseState) : 0) < 1) {
			return false;
		}
		return false;
	}
}
