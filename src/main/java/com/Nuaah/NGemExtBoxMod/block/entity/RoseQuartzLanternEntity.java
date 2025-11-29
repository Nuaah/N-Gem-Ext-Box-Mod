package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class RoseQuartzLanternEntity extends BlockEntity {
    private static final int RANGE = 5; // 効果が届く半径

    public RoseQuartzLanternEntity(BlockPos pos, BlockState state) {
        super(NGemExtBoxModBlockEntityTypes.ROSE_QUARTZ_LANTERN.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, RoseQuartzLanternEntity be) {
        // サーバー側のみ
        if (level.isClientSide) return;

        // 範囲 AABB を作成（立方体）
        AABB area = new AABB(
                pos.getX() - RANGE, pos.getY() - RANGE, pos.getZ() - RANGE,
                pos.getX() + RANGE + 1, pos.getY() + RANGE + 1, pos.getZ() + RANGE + 1
        );

        // 範囲内のすべてのプレイヤーを取得
        List<Player> players = level.getEntitiesOfClass(Player.class, area);

        // 効果を付与（例：再生能力）
        MobEffectInstance effect = new MobEffectInstance(MobEffects.REGENERATION, 100, 0, false, false);

        for (Player player : players) {
            if (!player.hasEffect(MobEffects.REGENERATION)) player.addEffect(effect);
        }
    }
}
