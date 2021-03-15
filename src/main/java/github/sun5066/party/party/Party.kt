package github.sun5066.party.party

import github.sun5066.party.party.commands.Commands
import org.bukkit.plugin.java.JavaPlugin

class Party : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
//        Bukkit.getPluginManager().registerEvents(BaseEvent(), this)
        getCommand("example")?.setExecutor(Commands())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}