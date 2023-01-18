package net.xyfe.twinelib.structure;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.Palette;
import net.xyfe.twinelib.nms.NMSDefinedStructureBlockInfo;

public class NMSDefinedStructure implements Structure {
  private StructureTemplate struct;

  public NMSDefinedStructure(StructureTemplate struct) {
    this.struct = struct;
  }

  @Override
  public int getSizeX() {
    return struct.getSize().getX();
  }

  @Override
  public int getSizeY() {
    return struct.getSize().getY();
  }

  @Override
  public int getSizeZ() {
    return struct.getSize().getZ();
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

    StructurePlaceSettings placementData;
    if (data == null) {
      placementData = new StructurePlaceSettings();
    } else {
      placementData = data.data;
    }

    BlockPos origin = BlockPos.ZERO;

    List<Palette> list;
    try {
      list = (List<Palette>) field.get(struct);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return placementData.getRandomPalette(list, origin).blocks().stream()
        .map(b -> new StructureTemplate.StructureBlockInfo(transform(placementData, b.pos), b.state, b.nbt))
        .map(NMSDefinedStructureBlockInfo::new).collect(Collectors.toList());
  }

  @Override
  public List<StructureBlockInfo> getBlockInfo() {
    return getBlockInfo(null);
  }

  private static BlockPos transform(StructurePlaceSettings info, BlockPos pos) {
    return StructureTemplate.calculateRelativePosition(info, pos);
  }
}
