package vanillagourmet.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class CaveBulkerSitProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean bsit = false;
		if (bsit) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sit down " + bsit)), false);
			return false;
		} else if (bsit == false) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Standing " + bsit)), false);
			bsit = false;
			return true;
		}
		return true;
	}
}
