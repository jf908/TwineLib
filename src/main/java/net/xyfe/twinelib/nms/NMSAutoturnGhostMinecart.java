package net.xyfe.twinelib.nms;

import net.minecraft.server.v1_16_R3.EnumMoveType;
import net.minecraft.server.v1_16_R3.Vec3D;
import net.minecraft.server.v1_16_R3.World;

public class NMSAutoturnGhostMinecart extends NMSGhostMinecart {
  public NMSAutoturnGhostMinecart(World world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);
  }

  @Override
  public void tick() {
    lastX = locX();
    lastY = locY();
    lastZ = locZ();
    lastYaw = yaw;
    lastPitch = pitch;

    Vec3D mot = getMot();
    yaw = (float) (Math.toDegrees(Math.atan2(mot.z, mot.x)) % 360f);
    pitch = (float) (Math.toDegrees(Math.sin(mot.y)) % 360f);
    move(EnumMoveType.SELF, mot);
  }
}