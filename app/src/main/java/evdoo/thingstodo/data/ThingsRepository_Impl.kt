package evdoo.thingstodo.data

import evdoo.thingstodo.domain.ThingItem
import evdoo.thingstodo.domain.ThingsRepository
import java.lang.RuntimeException

object ThingsRepository_Impl: ThingsRepository {

    private val thingsList = mutableListOf<ThingItem>()

    private var autoIncrementId = 0

    override fun addThing(thing: ThingItem) {
        if (thing.id == ThingItem.UNDEFINED_ID) {
            thing.id = autoIncrementId

            autoIncrementId++
        }
        thingsList.add(thing)
    }

    override fun editThing(thing: ThingItem) {
        val oldElement = getThing(thing.id)
        thingsList.remove(oldElement)
        addThing(thing)
    }

    override fun getThingsList(): List<ThingItem> {
        return thingsList.toList()
    }

    override fun getThing(thingId: Int): ThingItem {
        return thingsList.find {
            it.id == thingId } ?: throw RuntimeException("Element with id $thingId not found")
    }

    override fun removeThing(thing: ThingItem) {
        thingsList.remove(thing)
    }
}