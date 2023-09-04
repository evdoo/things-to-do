package evdoo.thingstodo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import evdoo.thingstodo.domain.ThingItem
import evdoo.thingstodo.domain.ThingsRepository
import java.lang.RuntimeException

object ThingsRepository_Impl: ThingsRepository {

    private val thingsList = mutableListOf<ThingItem>()
    private val thingsListLiveData = MutableLiveData<List<ThingItem>>()

    private var autoIncrementId = 0

    override fun addThing(thing: ThingItem) {
        if (thing.id == ThingItem.UNDEFINED_ID) {
            thing.id = autoIncrementId

            autoIncrementId++
        }
        thingsList.add(thing)
        updateList()
    }

    override fun editThing(thing: ThingItem) {
        val oldElement = getThing(thing.id)
        val index = thingsList.indexOf(oldElement)
        thingsList.add(index, thing)
        updateList()
    }

    override fun getThingsList(): LiveData<List<ThingItem>> {
        return thingsListLiveData
    }

    override fun getThing(thingId: Int): ThingItem {
        return thingsList.find {
            it.id == thingId } ?: throw RuntimeException("Element with id $thingId not found")
    }

    override fun removeThing(thing: ThingItem) {
        thingsList.remove(thing)
        updateList()
    }

    private fun updateList() {
        thingsListLiveData.value = thingsList.toList()
    }
}