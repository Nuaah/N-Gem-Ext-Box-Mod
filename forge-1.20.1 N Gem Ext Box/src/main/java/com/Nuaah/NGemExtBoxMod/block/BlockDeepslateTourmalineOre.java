package com.Nuaah.NGemExtBoxMod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

public class BlockDeepslateTourmalineOre extends DropExperienceBlock {
    public BlockDeepslateTourmalineOre() {
        super(Properties.of()
                .strength(4.5F,3.0F)
                .requiresCorrectToolForDrops()
                , UniformInt.of(3,7)
        );
    }
}
