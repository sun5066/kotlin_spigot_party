package github.sun5066.party.party.events

import github.sun5066.party.party.helper.UserHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent

abstract class BaseEvent : Event() {

    @EventHandler
    open fun onInventoryClick(event: InventoryClickEvent) {
        val uuid = event.whoClicked.uniqueId
        if (!UserHelper.uuidList.contains(uuid)) return

        event.rawSlot.takeIf { it < 0 || it > 54 }?.let { return }
        if (event.currentItem == null) return
    }
}