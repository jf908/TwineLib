package net.xyfe.twinelib.structure;

import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;

import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;

public class StructurePlacementData {
  protected StructurePlaceSettings data = new StructurePlaceSettings();

  public void setMirror(Mirror mirror) {
    data.setMirror(net.minecraft.world.level.block.Mirror.valueOf(mirror.name()));
  }

  public void setBlockRotation(StructureRotation rotation) {
    data.setRotation(Rotation.valueOf(rotation.name()));
  }
}
