package net.xyfe.twinelib.nms;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftEntity;
import org.bukkit.util.Vector;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.xyfe.twinelib.craft.CraftGhostBlock;

public class NMSGhostBlock extends FallingBlockEntity {
  private Vector target;

  public NMSGhostBlock(Level world, double d0, double d1, double d2, BlockState blockState) {
    super(EntityType.FALLING_BLOCK, world);

    setPos(d0, d1, d2);
    try {
      FieldUtils.writeField(this, "ao", blockState, true);
    } catch (IllegalAccessException ex) {
      throw new RuntimeException("Couldn't set blockState of falling block");
    }

    this.noPhysics = true;
    this.setNoGravity(true);
  }

  public void setTarget(Vector target) {
    this.target = target;
  }

  @Override
  public void tick() {
    if (target != null) {
      setDeltaMovement(target.getX() - getX(), target.getY() - getY(), target.getZ() - getZ());
      hurtMarked = true;
    }

    xo = getX();
    yo = getY();
    zo = getZ();
    move(MoverType.SELF, getDeltaMovement());
  }

  @Override
  public CraftEntity getBukkitEntity() {
    return new CraftGhostBlock(level.getCraftServer(), this);
  }
}