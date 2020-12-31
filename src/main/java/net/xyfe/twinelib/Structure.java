package net.xyfe.twinelib;

import java.util.List;

public interface Structure {
  int getSizeX();

  int getSizeY();

  int getSizeZ();

  List<StructureBlockInfo> getBlockInfo();
}
