package net.xyfe.twinelib.nms;

import net.minecraft.server.v1_15_R1.EntityArmorStand;
import net.minecraft.server.v1_15_R1.EnumMoveType;
import net.minecraft.server.v1_15_R1.World;

/**
 * NMSGhostStand
 */
public class NMSGhostStand extends EntityArmorStand {

  public NMSGhostStand(World world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);

    // setMarker(true);
    setInvisible(true);
    // setNoGravity(true);
    // noclip = true;
  }

  @Override
  public void tick() {
    // super.tick();
    lastX = locX();
    lastY = locY();
    lastZ = locZ();
    lastYaw = yaw;
    yaw++;
    move(EnumMoveType.SELF, getMot());
  }
}