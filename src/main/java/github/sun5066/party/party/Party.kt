package github.sun5066.party.party

import github.sun5066.party.party.commands.Commands
import github.sun5066.party.party.events.Event
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Party : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(Event(), this)
        getCommand("example")?.setExecutor(Commands())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}