package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.block.entity.GemData;
import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = NGemExtBoxMod.MOD_ID)
public class EffectHandler {

    private static final UUID GEM_DEFENSE_ARMOR_UUID = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static final UUID GEM_DAMAGE_BONUS_UUID = UUID.fromString("22222222-2222-2222-2222-222222222222");
    private static final UUID GEM_SPEED_BONUS_UUID = UUID.fromString("33333333-3333-3333-3333-333333333333");
    private static final UUID GEM_WATERSPEED_BONUS_UUID = UUID.fromString("44444444-4444-4444-4444-444444444444");

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

    public static int air = 300;
    public static boolean inWater = false;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;


        if(!player.isEyeInFluid(FluidTags.WATER)){ //水中か判定
            inWater = false;
            air = player.getAirSupply(); //呼吸リセット
        } else {
            inWater = true;
        }

        int[] bonusAir = {0};
        int[] bonusHeal = {0};
        float[] bonusSpeed = {0};
        double[] bonusWaterSpeed = {0};

        for (ItemStack armor : player.getArmorSlots()) {
            armor.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
                for (ItemStack gem : cap.getGems()) {
                    if (gem.isEmpty()) continue;

                    String id = gem.getItem().toString();

                    if (inWater) {
                        if (id.contains("aquamarine")) bonusAir[0] += 5; //水中呼吸
                    }

                    if(player.isInWater()){
                        if (id.contains("tourmaline")) bonusWaterSpeed[0] += 0.1D; //水中呼吸
                    }

                    if (id.contains("emerald")) bonusHeal[0] += 5; //再生
                    if (id.contains("peridot")) bonusSpeed[0] += 0.1F; //移動速度
                }
            });
        }

        //水中呼吸
        ForgeRegistries.FLUIDS.tags();
        if (bonusAir[0] > 0) {
            // 通常は毎tickごとに減少する（例：20tick = 1秒）
            if (player.tickCount % bonusAir[0] == 0) {
                air -= 1;
            }
            player.setAirSupply(air);
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

