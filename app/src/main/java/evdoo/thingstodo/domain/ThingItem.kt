package evdoo.thingstodo.domain

data class ThingItem(
    val title: String,
    val description: String?,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}