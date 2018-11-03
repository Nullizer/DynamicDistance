package com.github.nullizer;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DynamicDistancePlugin extends JavaPlugin
{
    @Override
    public void onEnable() {
        getCommand("vd").setExecutor((sender, command, label, args) -> {
            if (sender instanceof Player) {
                var player = (Player) sender;
                var name = player.getName();
                if (args.length == 2 && args[0].equalsIgnoreCase("set") && StringUtils.isNumeric(args[1])) {
                    var viewDistance = Integer.parseInt(args[1]);
                    player.setViewDistance(viewDistance);
                    sender.sendMessage(name + "'s distance changing to " + viewDistance);
                }
                sender.sendMessage(name + "'s current distance: " + player.getViewDistance());
                return true;
            } else {
                sender.sendMessage("Only player can query/change view distance");
            }
            return false;
        });
    }
}
