package vanillagourmet.procedures;

import vanillagourmet.entity.JumpSpiderEntity;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class JumpSpiderSitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
				if ((entity instanceof JumpSpiderEntity _datEntL3 && _datEntL3.getEntityData().get(JumpSpiderEntity.DATA_spiderSit)) == true) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Jump Spider: Following\"}");
						}
					}
					if (entity instanceof JumpSpiderEntity _datEntSetL)
						_datEntSetL.getEntityData().set(JumpSpiderEntity.DATA_spiderSit, false);
					if (entity instanceof JumpSpiderEntity) {
						((JumpSpiderEntity) entity).setAnimation("empty");
					}
				} else if ((entity instanceof JumpSpiderEntity _datEntL7 && _datEntL7.getEntityData().get(JumpSpiderEntity.DATA_spiderSit)) == false) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Jump Spider: Standing\"}");
						}
					}
					if (entity instanceof JumpSpiderEntity _datEntSetL)
						_datEntSetL.getEntityData().set(JumpSpiderEntity.DATA_spiderSit, true);
					if (entity instanceof JumpSpiderEntity) {
						((JumpSpiderEntity) entity).setAnimation("jumpspider.sit");
					}
				}
			} else {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Use a stick to command the Jump Spider\"}");
					}
				}
			}
		}
	}
}
