package vanillagourmet.procedures;

import vanillagourmet.entity.CaveBulkerEntity;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CaveBulkerCallProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if ((entity instanceof CaveBulkerEntity _datEntL1 && _datEntL1.getEntityData().get(CaveBulkerEntity.DATA_bulkerSit)) == true) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Cave Bulker: Following\"}");
					}
				}
				if (entity instanceof CaveBulkerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CaveBulkerEntity.DATA_bulkerSit, false);
			} else if ((entity instanceof CaveBulkerEntity _datEntL4 && _datEntL4.getEntityData().get(CaveBulkerEntity.DATA_bulkerSit)) == false) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Cave Bulker: Standing\"}");
					}
				}
				if (entity instanceof CaveBulkerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CaveBulkerEntity.DATA_bulkerSit, true);
			}
		}
	}
}
