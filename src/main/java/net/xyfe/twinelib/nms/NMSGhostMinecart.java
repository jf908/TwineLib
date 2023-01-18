package net.xyfe.twinelib.nms;

import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;

public class NMSGhostMinecart extends Minecart {
  public NMSGhostMinecart(Level world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);
    this.noPhysics = true;
    this.setNoGravity(true);
  }

  @Override
  public void tick() {
    xo = getX();
    yo = getY();
    zo = getZ();
    yRotO = getYRot();
    xRotO = getXRot();

    move(MoverType.SELF, getDeltaMovement());
  }
}