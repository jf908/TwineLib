package net.xyfe.twinelib;

import org.bukkit.block.data.BlockData;

public interface StructureBlockInfo {
  int getX();

  int getY();

  int getZ();

  BlockData getBlockState();

}
