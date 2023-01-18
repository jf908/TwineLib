package net.xyfe.twinelib.craft;

import org.bukkit.craftbukkit.v1_19_R2.CraftServer;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftFallingBlock;
import org.bukkit.util.Vector;

import net.xyfe.twinelib.GhostBlock;
import net.xyfe.twinelib.nms.NMSGhostBlock;

public class CraftGhostBlock extends CraftFallingBlock implements GhostBlock {
  public CraftGhostBlock(CraftServer server, NMSGhostBlock entity) {
    super(server, entity);
  }

  public void setTarget(Vector target) {
    getHandle().setTarget(target);
  }

  @Override
  public NMSGhostBlock getHandle() {
    return (NMSGhostBlock) entity;
  }
}