package vanillagourmet.procedures;

import vanillagourmet.entity.GooseEntity;

import vanillagourmet.VanillaGourmetMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class GooseSitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
				if ((entity instanceof GooseEntity _datEntI ? _datEntI.getEntityData().get(GooseEntity.DATA_gooseState) : 0) == 1) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Goose: Standing\"}");
						}
					}
					if (entity instanceof GooseEntity) {
						((GooseEntity) entity).setAnimation("empty");
					}
					VanillaGourmetMod.queueServerWork(2, () -> {
						if (entity instanceof GooseEntity) {
							((GooseEntity) entity).setAnimation("goose.sit");
						}
					});
					if (entity instanceof GooseEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GooseEntity.DATA_gooseState, 2);
				} else if ((entity instanceof GooseEntity _datEntI ? _datEntI.getEntityData().get(GooseEntity.DATA_gooseState) : 0) == 2) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Goose: Dancing\"}");
						}
					}
					if (entity instanceof GooseEntity) {
						((GooseEntity) entity).setAnimation("empty");
					}
					VanillaGourmetMod.queueServerWork(2, () -> {
						if (entity instanceof GooseEntity) {
							((GooseEntity) entity).setAnimation("goose.dance");
						}
					});
					if (entity instanceof GooseEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GooseEntity.DATA_gooseState, 3);
				} else {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Goose: Following\"}");
						}
					}
					VanillaGourmetMod.queueServerWork(2, () -> {
						if (entity instanceof GooseEntity) {
							((GooseEntity) entity).setAnimation("empty");
						}
					});
					if (entity instanceof GooseEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GooseEntity.DATA_gooseState, 1);
				}
			} else {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/title @s actionbar {\"text\":\"Use a stick to command the Goose\"}");
					}
				}
			}
		}
	}
}
