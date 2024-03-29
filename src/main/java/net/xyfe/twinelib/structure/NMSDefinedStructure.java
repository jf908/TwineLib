package net.xyfe.twinelib.structure;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.DefinedStructure;
import net.minecraft.server.v1_16_R3.DefinedStructure.BlockInfo;
import net.minecraft.server.v1_16_R3.DefinedStructureInfo;
import net.xyfe.twinelib.nms.NMSDefinedStructureBlockInfo;

public class NMSDefinedStructure implements Structure {
  private DefinedStructure struct;

  public NMSDefinedStructure(DefinedStructure struct) {
    this.struct = struct;
  }

  @Override
  public int getSizeX() {
    return struct.a().getX();
  }

  @Override
  public int getSizeY() {
    return struct.a().getY();
  }

  @Override
  public int getSizeZ() {
    return struct.a().getZ();
  }

  /**
   * A "dangerous" method that could do with some cleanup
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<StructureBlockInfo> getBlockInfo(StructurePlacementData data) {
    Field field;
    try {
      field = struct.getClass().getDeclaredField("a");
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    field.setAccessible(true);

    DefinedStructureInfo placementData;
    if (data == null) {
      placementData = new DefinedStructureInfo();
    } else {
      placementData = data.data;
    }

    BlockPosition origin = BlockPosition.ZERO;

    List<DefinedStructure.a> list;
    try {
      list = (List<DefinedStructure.a>) field.get(struct);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return placementData.a(list, origin).a().stream().map(b -> new BlockInfo(transform(placementData, b.a), b.b, b.c))
        .map(NMSDefinedStructureBlockInfo::new).collect(Collectors.toList());
  }

  @Override
  public List<StructureBlockInfo> getBlockInfo() {
    return getBlockInfo(null);
  }

  private static BlockPosition transform(DefinedStructureInfo info, BlockPosition pos) {
    return DefinedStructure.a(info, pos);
  }
}
