package com.Nuaah.NGemExtBoxMod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomAddItemModifier extends LootModifier {

    public static final Supplier<Codec<RandomAddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(Codec.list(Codec.STRING)
            .fieldOf("items").forGetter(m -> m.items)).apply(inst, RandomAddItemModifier::new)));

    private final List<String> items;
    private static final Random random = new Random();

    public RandomAddItemModifier(LootItemCondition[] conditionsIn, List<String> items) {
        super(conditionsIn);
        this.items = items;

    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        String id = this.items.get(random.nextInt(items.size()));
        Item item = ForgeRegistries.ITEMS.getValue(new net.minecraft.resources.ResourceLocation(id));

        if (item != null) {
            generatedLoot.add(new ItemStack(item));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
