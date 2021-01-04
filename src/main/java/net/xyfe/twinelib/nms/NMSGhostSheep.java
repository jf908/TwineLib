package net.xyfe.twinelib.nms;

import net.minecraft.server.v1_16_R3.EntitySheep;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.World;

public class NMSGhostSheep extends EntitySheep {
  public NMSGhostSheep(EntityTypes<? extends EntitySheep> entitytypes, World world) {
    super(entitytypes, world);
    this.noclip = true;
  }
}