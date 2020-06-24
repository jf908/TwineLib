package net.xyfe.twinelib.nms;

import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_15_R1.EntityFallingBlock;
import net.minecraft.server.v1_15_R1.EnumMoveType;
import net.minecraft.server.v1_15_R1.IBlockData;
import net.minecraft.server.v1_15_R1.World;
import net.xyfe.twinelib.craft.CraftGhostBlock;

public class NMSGhostBlock extends EntityFallingBlock {

  private Vector target;
  // private Function<Integer,Vector> targetGenerator;

  public NMSGhostBlock(World world, double d0, double d1, double d2, IBlockData iblockdata) {
    super(world, d0, d1, d2, iblockdata);
    this.noclip = true;
    this.setNoGravity(true);
  }

  public void setTarget(Vector target) {
    this.target = target;
  }

  @Override
  public void tick() {
    if(target != null) {
      setMot(target.getX() - locX(), target.getY() - locY(), target.getZ() - locZ());
      velocityChanged = true;
    }

    lastX = locX();
    lastY = locY();
    lastZ = locZ();
    move(EnumMoveType.SELF, getMot());
  }

  @Override
  public CraftEntity getBukkitEntity() {
    return new CraftGhostBlock(world.getServer(), this);
  }
}