package vanillagourmet.procedures;

import vanillagourmet.entity.CaveBulkerEntity;

import net.minecraft.world.entity.Entity;

public class CaveBulkerSitProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof CaveBulkerEntity _datEntL0 && _datEntL0.getEntityData().get(CaveBulkerEntity.DATA_bulkerSit)) == true) {
			return false;
		} else if ((entity instanceof CaveBulkerEntity _datEntL1 && _datEntL1.getEntityData().get(CaveBulkerEntity.DATA_bulkerSit)) == false) {
			return true;
		}
		return false;
	}
}
