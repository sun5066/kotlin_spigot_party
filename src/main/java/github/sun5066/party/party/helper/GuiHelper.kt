package github.sun5066.party.party.helper

import github.sun5066.party.party.events.BaseEvent
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.util.*

object GuiHelper : BaseEvent() {
    private var mInventoryList: MutableList<Inventory> = ArrayList()
    private var mUuid: UUID? = null
    private var mOfflinePlayer: OfflinePlayer? = null

    fun init(uuid: UUID) {
        this.mUuid = uuid
        this.mOfflinePlayer = Bukkit.getOfflinePlayer(uuid)

        this.setPartyList()
        this.openInventory()
    }

    private fun setPartyList() {
        PartyHelper.partyList.forEach { partyVO ->
            val inventory = Bukkit.createInventory(null, 36, "")
            val itemStack = ItemStack(Material.PLAYER_HEAD, 1)
            val skullMeta = itemStack.itemMeta as SkullMeta
            skullMeta.owningPlayer = Bukkit.getOfflinePlayer(partyVO.owner)
            itemStack.itemMeta = skullMeta
            inventory.addItem(itemStack)
        }
    }

    private fun openInventory() {
        mOfflinePlayer?.let { offlinePlayer ->
            offlinePlayer.player?.takeIf { player ->
                player.isOnline
            }?.let { it.openInventory(mInventoryList[0]) }
        }
    }

    override fun onInventoryClick(event: InventoryClickEvent) {
        super.onInventoryClick(event)
    }
}