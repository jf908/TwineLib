package net.xyfe.twinelib;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.block.data.CraftBlockData;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_15_R1.Entity;
import net.minecraft.server.v1_15_R1.EntityFallingBlock;
import net.minecraft.server.v1_15_R1.IBlockData;
import net.minecraft.server.v1_15_R1.World;

public class GhostBlock extends EntityFallingBlock {

  public GhostBlock(World world, double d0, double d1, double d2, IBlockData iblockdata) {
    super(world, d0, d1, d2, iblockdata);
    this.noclip = true;
    this.setNoGravity(true);
  }

  public static FallingBlock spawn(Location loc, BlockData blockData) {
    World world = ((CraftWorld)loc.getWorld()).getHandle();
    Entity entity = new GhostBlock(world, loc.getX(), loc.getY(), loc.getZ(), ((CraftBlockData)blockData).getState());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (FallingBlock)entity.getBukkitEntity();
  }

  @Override
  public void tick() {
    // Do nothing
  }
}