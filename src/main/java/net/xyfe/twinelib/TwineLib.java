package net.xyfe.twinelib;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;
import org.bukkit.entity.Minecart;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_16_R3.DefinedStructure;
import net.minecraft.server.v1_16_R3.DefinedStructureManager;
import net.minecraft.server.v1_16_R3.Entity;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import net.minecraft.server.v1_16_R3.World;
import net.xyfe.twinelib.nms.NMSAutoturnGhostMinecart;
import net.xyfe.twinelib.nms.NMSDefinedStructure;
import net.xyfe.twinelib.nms.NMSGhostBlock;
import net.xyfe.twinelib.nms.NMSGhostMinecart;

public class TwineLib extends JavaPlugin {
  public static Minecart spawnMinecart(Location loc) {
    World world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity entity = new NMSGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (Minecart) entity.getBukkitEntity();
  }

  public static Minecart spawnAutoturnMinecart(Location loc) {
    World world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity entity = new NMSAutoturnGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (Minecart) entity.getBukkitEntity();
  }

  public static GhostBlock spawnGhostBlock(Location loc, BlockData blockData) {
    World world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity block = new NMSGhostBlock(world, loc.getX(), loc.getY(), loc.getZ(),
        ((CraftBlockData) blockData).getState());
    world.addEntity(block, SpawnReason.CUSTOM);
    return (GhostBlock) block.getBukkitEntity();
  }

  public static Structure loadStructure(String id) {
    DefinedStructure struct = loadDefinedStructure(id);
    return struct == null ? null : new NMSDefinedStructure(struct);
  }

  private static DefinedStructure loadDefinedStructure(String id) {
    DefinedStructureManager manager = ((CraftServer) Bukkit.getServer()).getServer().getDefinedStructureManager();
    return manager.b(new MinecraftKey(id));
  }
}