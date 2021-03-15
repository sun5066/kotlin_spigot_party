package github.sun5066.party.party.helper

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.util.*

class GuiHelper private constructor(private val mUuid: UUID) {
    private var mInventoryList: MutableList<Inventory> = ArrayList()

    init {
        init()
    }

    private fun init() {
        this.setPartyList()
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

    @EventHandler
    fun clickEvent(inventoryClickEvent: InventoryClickEvent) {

    }
}