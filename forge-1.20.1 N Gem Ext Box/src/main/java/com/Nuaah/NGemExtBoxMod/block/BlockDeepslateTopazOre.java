package com.Nuaah.NGemExtBoxMod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

public class BlockDeepslateTopazOre extends DropExperienceBlock {
    public BlockDeepslateTopazOre() {
        super(Properties.of()
                .strength(4.5F,3.0F)
                .requiresCorrectToolForDrops()
                , UniformInt.of(3,7)
        );
    }
}
