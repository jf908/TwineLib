package net.xyfe.twinelib;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.block.data.CraftBlockData;
import org.bukkit.entity.Minecart;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_16_R2.Entity;
import net.minecraft.server.v1_16_R2.World;
import net.xyfe.twinelib.nms.NMSAutoturnGhostMinecart;
import net.xyfe.twinelib.nms.NMSGhostBlock;
import net.xyfe.twinelib.nms.NMSGhostMinecart;

public class TwineLib extends JavaPlugin {
  public static Minecart spawnMinecart(Location loc) {
    World world = ((CraftWorld)loc.getWorld()).getHandle();
    Entity entity = new NMSGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (Minecart)entity.getBukkitEntity();
  }

  public static Minecart spawnAutoturnMinecart(Location loc) {
    World world = ((CraftWorld)loc.getWorld()).getHandle();
    Entity entity = new NMSAutoturnGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (Minecart)entity.getBukkitEntity();
  }

  public static GhostBlock spawnGhostBlock(Location loc, BlockData blockData) {
    World world = ((CraftWorld)loc.getWorld()).getHandle();
    Entity block = new NMSGhostBlock(world, loc.getX(), loc.getY(), loc.getZ(), ((CraftBlockData)blockData).getState());
    world.addEntity(block, SpawnReason.CUSTOM);
    return (GhostBlock)block.getBukkitEntity();
  }
}