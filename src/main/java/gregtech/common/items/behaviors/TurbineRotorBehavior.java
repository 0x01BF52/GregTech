package gregtech.common.items.behaviors;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.items.metaitem.stats.IItemDurabilityManager;
import gregtech.api.items.metaitem.stats.IItemMaxStackSizeProvider;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.SolidMaterial;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;

public class TurbineRotorBehavior extends AbstractMaterialPartBehavior implements IItemMaxStackSizeProvider {

    private static final int TOOL_DURABILITY_MULTIPLIER = 100;

    public static TurbineRotorBehavior getInstanceFor(ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof MetaItem)) {
            return null;
        }
        MetaItem<?> metaItem = (MetaItem<?>) itemStack.getItem();
        MetaValueItem valueItem = metaItem.getItem(itemStack);
        if (valueItem == null) {
            return null;
        }
        IItemDurabilityManager durabilityManager = valueItem.getDurabilityManager();
        if (!(durabilityManager instanceof TurbineRotorBehavior)) {
            return null;
        }
        return (TurbineRotorBehavior) durabilityManager;
    }

    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
        IngotMaterial material = getPartMaterial(itemStack);
        return material.toolDurability * TOOL_DURABILITY_MULTIPLIER;
    }

    public double getRotorEfficiency(ItemStack itemStack) {
        SolidMaterial primaryMaterial = getPartMaterial(itemStack);
        return primaryMaterial == null ? 0.1 : Math.min(primaryMaterial.toolSpeed / 14.0, 1.0);
    }

    public void applyRotorDamage(ItemStack itemStack, int damageApplied) {
        int rotorDurability = getPartMaxDurability(itemStack);
        int resultDamage = getPartDamage(itemStack) + damageApplied;
        if (resultDamage >= rotorDurability) {
            itemStack.shrink(1);
        } else {
            setPartDamage(itemStack, resultDamage);
        }
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack, int defaultValue) {
        return 1;
    }

    @Override
    public void addInformation(ItemStack stack, List<String> lines) {
        super.addInformation(stack, lines);
        lines.add(I18n.format("metaitem.tool.tooltip.rotor.efficiency", (int) (getRotorEfficiency(stack) * 100)));
    }
}
