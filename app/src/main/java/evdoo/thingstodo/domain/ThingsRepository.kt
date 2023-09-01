package evdoo.thingstodo.domain

import androidx.lifecycle.LiveData

interface ThingsRepository {

    fun addThing(thing: ThingItem)

    fun editThing(thing: ThingItem)

    fun getThingsList() : LiveData<List<ThingItem>>

    fun getThing(thingId: Int): ThingItem

    fun removeThing(thing: ThingItem)
}