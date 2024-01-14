package vanillagourmet.procedures;

import vanillagourmet.entity.JumpSpiderEntity;

import net.minecraft.world.entity.Entity;

public class JumpSpiderCallProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof JumpSpiderEntity _datEntL0 && _datEntL0.getEntityData().get(JumpSpiderEntity.DATA_spiderSit)) == true) {
			return false;
		} else if ((entity instanceof JumpSpiderEntity _datEntL1 && _datEntL1.getEntityData().get(JumpSpiderEntity.DATA_spiderSit)) == false) {
			return true;
		}
		return false;
	}
}
