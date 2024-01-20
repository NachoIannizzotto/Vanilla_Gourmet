
package vanillagourmet.block;

import vanillagourmet.init.VanillaGourmetModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class ChocolateBlock extends LiquidBlock {
	public ChocolateBlock() {
		super(() -> VanillaGourmetModFluids.CHOCOLATE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(1000f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
