package github.sun5066.party.party.model

import java.io.Serializable
import java.util.*

data class MemberVO(
    val id: Long? = 0,
    val uuid: UUID
): Serializable
