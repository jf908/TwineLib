package net.xyfe.twinelib.nms;

import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class NMSAutoturnGhostMinecart extends NMSGhostMinecart {
  public NMSAutoturnGhostMinecart(Level world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);
  }

  @Override
  public void tick() {
    xo = getX();
    yo = getY();
    zo = getZ();
    yRotO = getYRot();
    xRotO = getXRot();

    Vec3 mot = getDeltaMovement();
    setYRot((float) (Math.toDegrees(Math.atan2(mot.z, mot.x)) % 360f));
    setXRot((float) (Math.toDegrees(Math.sin(mot.y)) % 360f));
    move(MoverType.SELF, mot);

  }
}