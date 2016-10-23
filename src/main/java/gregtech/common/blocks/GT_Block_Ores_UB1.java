package gregtech.common.blocks;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GT_Block_Ores_UB1 extends GT_Block_Ores_Abstract {
    //Block aUBBlock = GameRegistry.findBlock("UndergroundBiomes", "igneousStone");

    public GT_Block_Ores_UB1() {
        super("gt.blockores.ub1", Material.ROCK);
    }

    @Override
    public OrePrefixes[] getProcessingPrefix() { //Must have 8 entries.
        return new OrePrefixes[]{OrePrefixes.oreRedgranite, OrePrefixes.oreBlackgranite, OrePrefixes.ore, OrePrefixes.ore, OrePrefixes.ore, OrePrefixes.oreBasalt, OrePrefixes.ore, OrePrefixes.ore};
    }

    @Override
    public Block getDroppedBlock() {
        return GregTech_API.sBlockOresUb1;
    }

    @Override
    public Materials[] getDroppedDusts() { //Must have 8 entries; can be null.
        return new Materials[]{Materials.Stone, Materials.Stone, Materials.Stone, Materials.Stone, Materials.Stone, Materials.Stone, Materials.Stone, Materials.Stone};
    }

    @Override
    public IIconContainer[] getTextureSet() { //Must have 16 entries.
        return GT_Block_Ores.TEXTURES;
        //return new ITexture[]{new GT_CopiedBlockTexture(aUBBlock, 0, 0), new GT_CopiedBlockTexture(aUBBlock, 0, 1), new GT_CopiedBlockTexture(aUBBlock, 0, 2), new GT_CopiedBlockTexture(aUBBlock, 0, 3), new GT_CopiedBlockTexture(aUBBlock, 0, 4), new GT_CopiedBlockTexture(aUBBlock, 0, 5), new GT_CopiedBlockTexture(aUBBlock, 0, 6), new GT_CopiedBlockTexture(aUBBlock, 0, 7), new GT_CopiedBlockTexture(aUBBlock, 0, 0), new GT_CopiedBlockTexture(aUBBlock, 0, 1), new GT_CopiedBlockTexture(aUBBlock, 0, 2), new GT_CopiedBlockTexture(aUBBlock, 0, 3), new GT_CopiedBlockTexture(aUBBlock, 0, 4), new GT_CopiedBlockTexture(aUBBlock, 0, 5), new GT_CopiedBlockTexture(aUBBlock, 0, 6), new GT_CopiedBlockTexture(aUBBlock, 0, 7)};
    }

    @Override
    public boolean isGravelAlike(int aOreMeta) {
        return false;
    }
}
