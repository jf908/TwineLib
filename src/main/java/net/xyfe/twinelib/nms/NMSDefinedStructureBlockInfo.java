package net.xyfe.twinelib.nms;

import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;

import net.minecraft.server.v1_16_R3.DefinedStructure;
import net.xyfe.twinelib.StructureBlockInfo;

public class NMSDefinedStructureBlockInfo implements StructureBlockInfo {
  DefinedStructure.BlockInfo info;

  public NMSDefinedStructureBlockInfo(DefinedStructure.BlockInfo info) {
    this.info = info;
  }

  @Override
  public int getX() {
    return info.a.getX();
  }

  @Override
  public int getY() {
    return info.a.getY();
  }

  @Override
  public int getZ() {
    return info.a.getZ();
  }

  @Override
  public BlockData getBlockState() {
    return (BlockData) CraftBlockData.fromData(info.b);
  }
}
