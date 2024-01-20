
package vanillagourmet.fluid;

import vanillagourmet.init.VanillaGourmetModItems;
import vanillagourmet.init.VanillaGourmetModFluids;
import vanillagourmet.init.VanillaGourmetModFluidTypes;
import vanillagourmet.init.VanillaGourmetModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class ChocolateFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> VanillaGourmetModFluidTypes.CHOCOLATE_TYPE.get(), () -> VanillaGourmetModFluids.CHOCOLATE.get(),
			() -> VanillaGourmetModFluids.FLOWING_CHOCOLATE.get()).explosionResistance(1000f).tickRate(10).levelDecreasePerBlock(2).slopeFindDistance(3).bucket(() -> VanillaGourmetModItems.CHOCOLATE_BUCKET.get())
			.block(() -> (LiquidBlock) VanillaGourmetModBlocks.CHOCOLATE.get());

	private ChocolateFluid() {
		super(PROPERTIES);
	}

	public static class Source extends ChocolateFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends ChocolateFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
