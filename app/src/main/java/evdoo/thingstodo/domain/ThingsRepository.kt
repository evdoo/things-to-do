package evdoo.thingstodo.domain

interface ThingsRepository {

    fun addThing(thing: ThingItem)

    fun editThing(thing: ThingItem)

    fun getThingsList() : List<ThingItem>

    fun getThing(thingId: Int): ThingItem

    fun removeThing(thing: ThingItem)
}