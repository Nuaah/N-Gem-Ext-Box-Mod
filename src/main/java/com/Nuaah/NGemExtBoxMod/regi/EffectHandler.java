package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.block.entity.GemData;
import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import com.Nuaah.NGemExtBoxMod.regi.net.LinkerCoreSyncPacket;
import com.Nuaah.NGemExtBoxMod.regi.net.NetworkHandler;
import com.Nuaah.NGemExtBoxMod.villager.NGemExtBoxModVillager;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.util.*;

@Mod.EventBusSubscriber(modid = NGemExtBoxMod.MOD_ID)
public class EffectHandler {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void addCustomTrade(VillagerTradesEvent event){
        if (event.getType() == NGemExtBoxModVillager.JEWELER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> tredes = event.getTrades();

            List<ItemStack> gems = new ArrayList<ItemStack>(Arrays.asList(
                    new ItemStack(NGemExtBoxModItems.RUBY_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.SAPPHIRE_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.PERIDOT_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.AQUAMARINE_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.TOURMALINE_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.TOPAZ_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.GARNET_GEM.get()),
                    new ItemStack(NGemExtBoxModItems.MOONSTONE_GEM.get())
                )
            );

            Collections.shuffle(gems);




            tredes.get(1).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 3 + rand.nextInt(0,3);
                return new MerchantOffer(
                    new ItemStack(Items.EMERALD, emeraldCost),
                    gems.get(randomIndex).copy(),
                    5, 5, 0.05F
                );
            });

            tredes.get(1).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 3 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, emeraldCost),
                        gems.get(randomIndex).copy(),
                        5, 5, 0.05F
                );
            });

            tredes.get(1).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 3 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, emeraldCost),
                        gems.get(randomIndex).copy(),
                        5, 5, 0.05F
                );
            });

            tredes.get(2).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 1 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, emeraldCost),
                        new ItemStack(NGemExtBoxModBlocks.Blocks.GEODE.get()),
                        10, 5, 0.05F
                );
            });

            tredes.get(2).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 1 + rand.nextInt(0,3);
                return new MerchantOffer(
                        gems.get(randomIndex).copy(),
                        new ItemStack(Items.EMERALD, emeraldCost),
                        6, 5, 0.05F
                );
            });

            tredes.get(2).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 3 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, emeraldCost),
                        gems.get(randomIndex).copy(),
                        7, 5, 0.05F
                );
            });

            tredes.get(3).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int tradeCount = 1 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(gems.get(3).getItem(),tradeCount),
                        gems.get(randomIndex).copy(),
                        10, 5, 0.05F
                );
            });

            tredes.get(3).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int tradeCount = 1 + rand.nextInt(0,3);
                return new MerchantOffer(
                        new ItemStack(gems.get(3).getItem(),tradeCount),
                        gems.get(randomIndex).copy(),
                        10, 5, 0.05F
                );
            });

            tredes.get(4).add((trader, rand) -> {
                int randomIndex = rand.nextInt(gems.size());
                int emeraldCost = 2 + rand.nextInt(0,2);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, emeraldCost),
                        gems.get(randomIndex).copy(),
                        5, 5, 0.05F
                );
            });
        }
    }

    //結合効果
    private static final UUID GEM_DEFENSE_ARMOR_UUID = UUID.fromString("9b58f60f-b4e1-47f0-90f6-b83fdd2f9cda");
    private static final UUID GEM_DAMAGE_BONUS_UUID = UUID.fromString("d23709b8-6f76-4dc6-b3a1-6c5cec7e9d5b");
    private static final UUID GEM_SPEED_BONUS_UUID = UUID.fromString("a049b884-7a69-4a07-a619-4e4a301b8303");
    private static final UUID GEM_WATERSPEED_BONUS_UUID = UUID.fromString("ae321664-b90a-49d2-a14e-e99d66fd4cfa");
    private static final UUID GEM_HEALTH_BONUS_UUID = UUID.fromString("b1f6472c-5ad7-4ae8-9bda-4440e0c8e000");


    @SubscribeEvent
    public static void onAttributeModify(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();

        Equipable equip = Equipable.get(stack); //装備可能スロット
        EquipmentSlot slot = event.getSlotType(); //eventスロット

        // 防具スロットにのみ適用
        if (slot.getType() != EquipmentSlot.Type.ARMOR) return;
        if (equip == null) return;;

        //スロットが一致するか?
        EquipmentSlot equipSlot = equip.getEquipmentSlot();
        if(equipSlot != event.getSlotType())return;

        //付与
        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
            double bonusArmor = 0;

            for (ItemStack gem : cap.getGems()) { //宝石取得
                if (gem.isEmpty()) continue;

                String id = gem.getItem().toString();
                if (id.contains("diamond")) bonusArmor += 1;
            }

            if (bonusArmor > 0) {
                event.addModifier(
                    Attributes.ARMOR,
                    new AttributeModifier(
                        GEM_DEFENSE_ARMOR_UUID
                        , "Gem defense boost"
                        , bonusArmor
                        , AttributeModifier.Operation.ADDITION
                    )
                );
            }
        });
    }

    @SubscribeEvent
    public static void onItemAttribute(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();

        // Capability取得
        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {

            double bonusDamage = 0;

            for (ItemStack gem : cap.getGems()){
                if (gem.isEmpty()) continue;

                String id = gem.getItem().toString();
                if (id.contains("garnet")) bonusDamage += 0.5;
            }

            if (bonusDamage > 0) {
                // ここで武器スロットか確認（mainhandなど）
                if (event.getSlotType() == EquipmentSlot.MAINHAND) {
                    event.addModifier(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                            GEM_DAMAGE_BONUS_UUID
                            , "Gem Damage bonus"
                            , bonusDamage
                            , AttributeModifier.Operation.ADDITION
                        )
                    );
                }
            }
        });
    }

//    public static int air = 300;
//    public static boolean inWater = false;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        boolean isEyeInWater = player.isEyeInFluid(FluidTags.WATER);

//        if(!player.isEyeInFluid(FluidTags.WATER)){ //水中か判定
//            inWater = false;
//            air = player.getAirSupply(); //呼吸リセット
//        } else {
//            inWater = true;
//        }

        int[] bonusAir = {0};
        int[] bonusHeal = {0};
        float[] bonusSpeed = {0};
        double[] bonusWaterSpeed = {0};
        int[] bonusHealth = {0};

        for (ItemStack armor : player.getArmorSlots()) {
            armor.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
                for (ItemStack gem : cap.getGems()) {
                    if (gem.isEmpty()) continue;

                    String id = gem.getItem().toString();

                    if (isEyeInWater) {
                        if (id.contains("aquamarine")) bonusAir[0] += 3; //水中呼吸
                    }

                    if(player.isInWater()){
                        if (id.contains("tourmaline")) bonusWaterSpeed[0] += 0.1D; //水中呼吸
                    }

                    if (id.contains("emerald")) bonusHeal[0] += 5; //再生
                    if (id.contains("peridot")) bonusSpeed[0] += 0.1F; //移動速度
                    if (id.contains("rose_quartz")) bonusHealth[0] += 1; //体力
                }
            });
        }

        //水中呼吸
        // --- 水中呼吸の処理 ---

        if (bonusAir[0] > 0 && isEyeInWater) {
            player.getCapability(NGemExtBoxModCapabilities.CUSTOM_AIR_CAP).ifPresent(customAir -> {
                // データを操作
                long gameTime = player.level().getGameTime();
                if (gameTime % bonusAir[0] == 0) {
                    customAir.decreaseAir(1);
                }
                int currentCustomAir = customAir.getAir();
                // マイクラ標準のゲージに反映させる（視覚的表示）
                player.setAirSupply(currentCustomAir);
            });
        } else {
            player.getCapability(NGemExtBoxModCapabilities.CUSTOM_AIR_CAP).ifPresent(customAir -> {
               customAir.setAir(player.getAirSupply());
            });
        }

        // 再生
        if (bonusHeal[0] > 0) {
            // 通常は毎tickごとに減少する（例：20tick = 1秒）
            if ((player.tickCount % (100 - bonusHeal[0])) == 0) {
                player.heal(0.5F);
            }
        }

        AttributeInstance speedAttr = player.getAttribute(Attributes.MOVEMENT_SPEED);

        speedAttr.removeModifier(GEM_SPEED_BONUS_UUID);
        speedAttr.removeModifier(GEM_WATERSPEED_BONUS_UUID);

        if (bonusSpeed[0] > 0) { //移動速度
            AttributeModifier modifier = new AttributeModifier(
                    GEM_SPEED_BONUS_UUID,
                    "gem_speed_boost",
                    bonusSpeed[0],
                    AttributeModifier.Operation.MULTIPLY_TOTAL
            );
            speedAttr.addTransientModifier(modifier);
        }

        if (bonusWaterSpeed[0] > 0) {

            float inputX = player.xxa;
            float inputZ = player.zza;

            // 入力があるときのみ処理
            if (Math.abs(inputX) > 0.01f || Math.abs(inputZ) > 0.01f) {

                // 入力方向をベクトル化（前後左右）
                Vec3 inputDir = new Vec3(inputX, 0, inputZ).normalize();

                // プレイヤーの向きに合わせて回転
                Vec3 dir = inputDir.yRot(-player.getYRot() * ((float)Math.PI / 180F));

                // 水中用速度倍率
                double moveSpeed = Math.min(bonusWaterSpeed[0],1.0D);

                // 垂直方向の速度は維持（落下とか浮力用）
                Vec3 motion = player.getDeltaMovement();
                Vec3 newMotion = new Vec3(dir.x * moveSpeed, motion.y, dir.z * moveSpeed);

                player.setDeltaMovement(newMotion);
            } else {
                // 入力がないときは自然減速
                Vec3 motion = player.getDeltaMovement();
                player.setDeltaMovement(new Vec3(motion.x * 0.8D, motion.y, motion.z * 0.8D));
            }
        }

        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        // 体力バー更新
        player.setHealth(player.getHealth());
        maxHealth.removeModifier(GEM_HEALTH_BONUS_UUID);

        if (bonusHealth[0] > 0) {
            AttributeModifier mod = new AttributeModifier(
                    GEM_HEALTH_BONUS_UUID,
                    "gem_health_boost",
                    bonusHealth[0] * 2,
                    AttributeModifier.Operation.ADDITION
            );
            maxHealth.addPermanentModifier(mod);
        }

        if (player instanceof ServerPlayer serverPlayer) { //リンクォーツ処理
            ItemStack heldItem = event.player.getMainHandItem();
            if (heldItem.getItem() == NGemExtBoxModItems.LINQUARTZ.get()) { // 特定アイテムをチェック
                LinkerPowerData data = LinkerPowerData.get(player.level());
                BlockPos linkerCorePos = LinkerCoreRegistry.getNearestCorePos(player.level(),player.getOnPos());

                double distance = -1;
                if (linkerCorePos != null){
                    distance = Math.sqrt(player.getOnPos().distSqr(linkerCorePos));

                    NetworkHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new LinkerCoreSyncPacket(data.getLinkerPower(),distance,linkerCorePos));
                } else {
                    NetworkHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new LinkerCoreSyncPacket(data.getLinkerPower(),distance,new BlockPos(0,0,0)));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide) return;
        if (!(entity instanceof Player player)) return;

        float[] bonusFallDamage = {0};

        for (ItemStack armor : player.getArmorSlots()) {
            armor.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
                for (ItemStack gem : cap.getGems()) {
                    if (gem.isEmpty()) continue;

                    String id = gem.getItem().toString();

                    if (id.contains("moonstone")) bonusFallDamage[0] += 0.1f; //落下耐性
                }
            });
        }

        if (bonusFallDamage[0] > 0) {
            // ダメージ軽減率を設定
            float multiplier = Math.min(bonusFallDamage[0],1.0F);

            // 元のダメージを取得
            float originalDamage = event.getDamageMultiplier() * event.getDistance();

            // 新しいダメージを計算
            float reducedDamage = originalDamage * (1.0f - multiplier);

            // イベントに反映
            event.setDamageMultiplier(reducedDamage / event.getDistance());
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof LivingEntity target)) return;

        ItemStack weapon = player.getMainHandItem();

        int[] bonusFire = {0};

        weapon.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
            for (ItemStack gem : cap.getGems()) {
                if (gem.isEmpty()) continue;

                String id = gem.getItem().toString();

                if (id.contains("ruby")) bonusFire[0] += 1; //火属性
            }
        });

        target.setSecondsOnFire(bonusFire[0]);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        // プレイヤーのみ処理
        if (entity instanceof Player player) {

            float[] bonusFireArmor = {0F};

            for (ItemStack armor : player.getArmorSlots()) {
                armor.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
                    for (ItemStack gem : cap.getGems()) {
                        if (gem.isEmpty()) continue;

                        String id = gem.getItem().toString();

                        if (id.contains("sapphire")) bonusFireArmor[0] += 0.15f; //火炎耐性
                    }
                });
            }

            //火耐性
            if (bonusFireArmor[0] > 0) {
                float multiplier = Math.min(bonusFireArmor[0], 1.0F);
                event.setAmount(event.getAmount() * (1f - multiplier));
            }

        } else if (event.getSource().getEntity() instanceof Player player) { //プレイヤーが攻撃された
            int[] bonusPoison = {0};

            ItemStack weapon = player.getMainHandItem();

            weapon.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
                for (ItemStack gem : cap.getGems()) {
                    if (gem.isEmpty()) continue;

                    String id = gem.getItem().toString();

                    if (id.contains("amethyst")) bonusPoison[0] += 2; //毒
                }
            });
            //毒
            if (bonusPoison[0] > 0) {
                int duration = 60 * bonusPoison[0]; // 60 ticks = 3秒 × 宝石数
                int amplifier = 0; // 毒 I
                MobEffectInstance poison = new MobEffectInstance(MobEffects.POISON, duration, amplifier);
                event.getEntity().addEffect(poison);
            }
        }


    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        ItemStack tool = player.getMainHandItem();

        float[] bonusDigSpeed = {0F};

        // 宝石がついているかチェック
        tool.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
            for (ItemStack gem : cap.getGems()) {
                if (gem.isEmpty()) continue;

                String id = gem.getItem().toString();

                if (id.contains("topaz")) bonusDigSpeed[0] += 0.15f; //採掘速度
            }
        });

        event.setNewSpeed(event.getOriginalSpeed() * (1.0F + bonusDigSpeed[0]));
    }

    @SubscribeEvent
    public static void onExperienceDrop(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if (player == null) return;

        ItemStack weapon = player.getMainHandItem();

        float[] bonusXP = {0F};

        weapon.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
            for (ItemStack gem : cap.getGems()) {
                if (gem.isEmpty()) continue;

                String id = gem.getItem().toString();

                if (id.contains("lapis")) bonusXP[0] += 0.2f; //経験値
            }
        });

        if (bonusXP[0] > 0) {
            int originalXP = event.getOriginalExperience();
            int bonus = (int) (originalXP * bonusXP[0]);
            event.setDroppedExperience(originalXP + bonus);
        }
    }
}

