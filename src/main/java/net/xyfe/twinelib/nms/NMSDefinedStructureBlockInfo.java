package net.xyfe.twinelib.nms;

import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_19_R2.block.data.CraftBlockData;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.xyfe.twinelib.structure.StructureBlockInfo;

public class NMSDefinedStructureBlockInfo implements StructureBlockInfo {
  StructureTemplate.StructureBlockInfo info;

  public NMSDefinedStructureBlockInfo(StructureTemplate.StructureBlockInfo info) {
    this.info = info;
  }

  @Override
  public int getX() {
    return info.pos.getX();
  }

  @Override
  public int getY() {
    return info.pos.getY();
  }

  @Override
  public int getZ() {
    return info.pos.getZ();
  }

  @Override
  public BlockData getBlockState() {
    return (BlockData) CraftBlockData.fromData(info.state);
  }
}
