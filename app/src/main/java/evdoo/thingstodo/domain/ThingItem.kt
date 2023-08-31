package evdoo.thingstodo.domain

data class ThingItem(
    val id: Int,
    val title: String,
    val description: String?,
    val enabled: Boolean
)