package net.xyfe.twinelib;

import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

public interface GhostBlock extends FallingBlock {
  public void setTarget(Vector target);
}