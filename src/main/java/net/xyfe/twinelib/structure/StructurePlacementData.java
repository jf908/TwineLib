package net.xyfe.twinelib.structure;

import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;

import net.minecraft.server.v1_16_R3.DefinedStructureInfo;
import net.minecraft.server.v1_16_R3.EnumBlockMirror;
import net.minecraft.server.v1_16_R3.EnumBlockRotation;

public class StructurePlacementData {
  protected DefinedStructureInfo data = new DefinedStructureInfo();

  public void setMirror(Mirror mirror) {
    data.a(EnumBlockMirror.valueOf(mirror.name()));
  }

  public void setBlockRotation(StructureRotation rotation) {
    data.a(EnumBlockRotation.valueOf(rotation.name()));
  }
}
