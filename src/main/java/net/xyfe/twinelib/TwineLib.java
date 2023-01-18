package net.xyfe.twinelib;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_19_R2.CraftEquipmentSlot;
import org.bukkit.craftbukkit.v1_19_R2.CraftServer;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R2.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.xyfe.twinelib.nms.NMSAutoturnGhostMinecart;
import net.xyfe.twinelib.nms.NMSGhostBlock;
import net.xyfe.twinelib.nms.NMSGhostMinecart;
import net.xyfe.twinelib.nms.NMSGhostSheep;
import net.xyfe.twinelib.structure.NMSDefinedStructure;
import net.xyfe.twinelib.structure.Structure;

public class TwineLib extends JavaPlugin {
  public static void playBreakAnimation(Player player, EquipmentSlot slot) {
    ((CraftPlayer) player).getHandle().broadcastBreakEvent(CraftEquipmentSlot.getNMS(slot));
  }

  public static Minecart spawnMinecart(Location loc) {
    Level world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity entity = new NMSGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addFreshEntity(entity, SpawnReason.CUSTOM);
    return (Minecart) entity.getBukkitEntity();
  }

  public static Minecart spawnAutoturnMinecart(Location loc) {
    Level world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity entity = new NMSAutoturnGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addFreshEntity(entity, SpawnReason.CUSTOM);
    return (Minecart) entity.getBukkitEntity();
  }

  public static GhostBlock spawnGhostBlock(Location loc, BlockData blockData) {
    Level world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity block = new NMSGhostBlock(world, loc.getX(), loc.getY(), loc.getZ(),
        ((CraftBlockData) blockData).getState());
    world.addFreshEntity(block, SpawnReason.CUSTOM);
    return (GhostBlock) block.getBukkitEntity();
  }

  public static Sheep spawnGhostSheep(Location loc) {
    Level world = ((CraftWorld) loc.getWorld()).getHandle();
    Entity sheep = new NMSGhostSheep(EntityType.SHEEP, world);
    sheep.absMoveTo(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    world.addFreshEntity(sheep, SpawnReason.CUSTOM);
    return (Sheep) sheep.getBukkitEntity();
  }

  public static Structure loadStructure(String id) {
    StructureTemplate struct = loadDefinedStructure(id);
    return struct == null ? null : new NMSDefinedStructure(struct);
  }

  private static StructureTemplate loadDefinedStructure(String id) {
    StructureTemplateManager manager = ((CraftServer) Bukkit.getServer()).getServer().getStructureManager();
    return manager.get(new ResourceLocation(id)).orElse(null);
  }
}