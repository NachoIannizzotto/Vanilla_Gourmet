package vanillagourmet.procedures;

import vanillagourmet.entity.KreeperEntity;

import net.minecraft.world.entity.Entity;

public class KreepercallProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof KreeperEntity _datEntL0 && _datEntL0.getEntityData().get(KreeperEntity.DATA_kreeperSit)) == true) {
			return false;
		} else if ((entity instanceof KreeperEntity _datEntL1 && _datEntL1.getEntityData().get(KreeperEntity.DATA_kreeperSit)) == false) {
			return true;
		}
		return false;
	}
}
