package net.xyfe.twinelib;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Minecart;
import org.bukkit.plugin.java.JavaPlugin;

public class TwineLib extends JavaPlugin {
  

  public static FallingBlock spawnGhostBlock(Location loc, BlockData blockData) {
    return GhostBlock.spawn(loc, blockData);
  }

  public static Minecart spawnMinecart(Location loc) {
    return GhostMinecart.spawn(loc);
  }
}