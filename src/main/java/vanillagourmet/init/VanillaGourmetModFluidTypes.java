
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.fluid.types.ChocolateFluidType;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

public class VanillaGourmetModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, VanillaGourmetMod.MODID);
	public static final RegistryObject<FluidType> CHOCOLATE_TYPE = REGISTRY.register("chocolate", () -> new ChocolateFluidType());
}
