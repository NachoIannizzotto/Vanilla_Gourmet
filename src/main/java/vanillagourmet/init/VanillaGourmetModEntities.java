
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vanillagourmet.init;

import vanillagourmet.entity.CaveBulkerEntity;
import vanillagourmet.entity.BulkerEntity;

import vanillagourmet.VanillaGourmetMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VanillaGourmetModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VanillaGourmetMod.MODID);
	public static final RegistryObject<EntityType<BulkerEntity>> BULKER = register("bulker",
			EntityType.Builder.<BulkerEntity>of(BulkerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BulkerEntity::new)

					.sized(1f, 1.2f));
	public static final RegistryObject<EntityType<CaveBulkerEntity>> CAVE_BULKER = register("cave_bulker",
			EntityType.Builder.<CaveBulkerEntity>of(CaveBulkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20).setUpdateInterval(3).setCustomClientFactory(CaveBulkerEntity::new)

					.sized(1.3f, 1.3f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BulkerEntity.init();
			CaveBulkerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BULKER.get(), BulkerEntity.createAttributes().build());
		event.put(CAVE_BULKER.get(), CaveBulkerEntity.createAttributes().build());
	}
}
