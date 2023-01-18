package net.xyfe.twinelib.nms;

import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;

/**
 * NMSGhostStand
 */
public class NMSGhostStand extends ArmorStand {

  public NMSGhostStand(Level world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);

    // setMarker(true);
    setInvisible(true);
    // setNoGravity(true);
    // noclip = true;
  }

  @Override
  public void tick() {
    // super.tick();

    xo = getX();
    yo = getY();
    zo = getZ();
    yRotO = getYRot();
    setYRot(yRotO + 1);

    move(MoverType.SELF, getDeltaMovement());
  }
}