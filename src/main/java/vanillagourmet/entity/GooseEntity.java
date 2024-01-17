
package vanillagourmet.entity;

import vanillagourmet.procedures.GooseSitProcedure;
import vanillagourmet.procedures.GooseCallProcedure;

import vanillagourmet.init.VanillaGourmetModEntities;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import java.util.List;

public class GooseEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(GooseEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(GooseEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(GooseEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_gooseState = SynchedEntityData.defineId(GooseEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public GooseEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(VanillaGourmetModEntities.GOOSE.get(), world);
	}

	public GooseEntity(EntityType<GooseEntity> type, Level world) {
		super(type, world);
		xpReward = 5;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "goosea");
		this.entityData.define(DATA_gooseState, 3);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return 0.75F;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 4;
			}

			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}

		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		}.setAlertOthers());
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1, (float) 5, (float) 2, false) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new OwnerHurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new TemptGoal(this, 1, Ingredient.of(Items.BREAD), false) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.2) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 1.2, 40) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new BreedGoal(this, 1.2) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(10, new EatBlockGoal(this) {
			@Override
			public boolean canUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canUse() && GooseCallProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GooseEntity.this.getX();
				double y = GooseEntity.this.getY();
				double z = GooseEntity.this.getZ();
				Entity entity = GooseEntity.this;
				Level world = GooseEntity.this.level();
				return super.canContinueToUse() && GooseCallProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(12, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.CHICKEN));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DatagooseState", this.entityData.get(DATA_gooseState));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DatagooseState"))
			this.entityData.set(DATA_gooseState, compound.getInt("DatagooseState"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		GooseSitProcedure.execute(world, entity, sourceentity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		GooseEntity retval = VanillaGourmetModEntities.GOOSE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.BREAD).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(VanillaGourmetModEntities.GOOSE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 12);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("goose.walk"));
			}
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("goose.idlewater"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("goose.agro"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("goose.idle"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			return PlayState.STOP;
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(GooseEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
