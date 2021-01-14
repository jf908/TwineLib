package net.xyfe.twinelib.structure;

import java.util.List;

public interface Structure {
  int getSizeX();

  int getSizeY();

  int getSizeZ();

  List<StructureBlockInfo> getBlockInfo();

  List<StructureBlockInfo> getBlockInfo(StructurePlacementData data);
}
