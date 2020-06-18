package net.xyfe.twinelib.nms;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Minecart;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_15_R1.Entity;
import net.minecraft.server.v1_15_R1.EntityMinecartRideable;
import net.minecraft.server.v1_15_R1.EnumMoveType;
import net.minecraft.server.v1_15_R1.Vec3D;
import net.minecraft.server.v1_15_R1.World;

public class NMSGhostMinecart extends EntityMinecartRideable {
  public NMSGhostMinecart(World world, double d0, double d1, double d2) {
    super(world, d0, d1, d2);
    this.noclip = true;
    this.setNoGravity(true);
  }

  public static Minecart spawn(Location loc) {
    World world = ((CraftWorld)loc.getWorld()).getHandle();
    Entity entity = new NMSGhostMinecart(world, loc.getX(), loc.getY(), loc.getZ());
    world.addEntity(entity, SpawnReason.CUSTOM);
    return (Minecart)entity.getBukkitEntity();
  }

  @Override
  public void tick() {
    lastX = locX();
    lastY = locY();
    lastZ = locZ();
    lastYaw = yaw;
    Vec3D mot = getMot();
    yaw = (float)(Math.toDegrees(Math.atan2(mot.z, mot.x)) % 360f);
    move(EnumMoveType.SELF, mot);
  }
}