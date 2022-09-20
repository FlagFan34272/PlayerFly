package me.nyaneo.yfallen.yfallentp;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Yfallentp extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(this, this);
    }


    

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("unfly")) {

            if (sender instanceof Player player) {
                if (sender.hasPermission("yf.unfly")) {
                    player.setAllowFlight(false);
                    player.sendMessage("기능 꺼짐!");
                } else {

                }
            }
        }



        if (cmd.getName().equalsIgnoreCase("fly")) {


            if (sender instanceof Player player) {
                if (sender.hasPermission("yf.fly")) {
                    player.setAllowFlight(true);
                    player.sendMessage("기능 활성화!");
                } else {

                }
            }
        }

        if (cmd.getName().equalsIgnoreCase("update")) {


            if (sender instanceof Player player) {
                if (sender.hasPermission("yf.update")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
                    Bukkit.broadcastMessage(ChatColor.YELLOW +" [Update System]" + ChatColor.GREEN + "A plugin has been updated to new version.");
                    Bukkit.broadcastMessage(ChatColor.RED + "이제 최신버전입니다. 1.0.1 Beta");

                } else {
                    player.sendMessage("괄자 아니면 안됨 ㅅㄱ");
                }
            }
        }


        return false;
    }






    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
