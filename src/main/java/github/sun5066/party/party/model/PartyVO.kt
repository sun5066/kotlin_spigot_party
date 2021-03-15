package github.sun5066.party.party.model

import java.io.Serializable
import java.util.*

data class PartyVO(
    val id: UUID? = UUID.randomUUID(),
    val owner: UUID,
    val memberList: MutableList<MemberVO>? = ArrayList()
) : Serializable