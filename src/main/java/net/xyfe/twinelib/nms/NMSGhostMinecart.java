package net.xyfe.twinelib.nms;

import net.minecraft.server.v1_16_R3.EntityMinecartRideable;
import net.minecraft.server.v1_16_R3.EnumMoveType;
import net.minecraft.server.v1_16_R3.World;

public class NMSGhostMinecart extends EntityMinecartRideable {
  public NMSGhostMinecart(World world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);
    this.noclip = true;
    this.setNoGravity(true);
  }

  @Override
  public void tick() {
    lastX = locX();
    lastY = locY();
    lastZ = locZ();
    lastYaw = yaw;
    lastPitch = pitch;

    move(EnumMoveType.SELF, getMot());
  }
}