package net.xyfe.twinelib.nms;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;

public class NMSGhostSheep extends Sheep {
  public NMSGhostSheep(EntityType<? extends Sheep> entitytypes, Level world) {
    super(entitytypes, world);
    this.noPhysics = true;
  }
}