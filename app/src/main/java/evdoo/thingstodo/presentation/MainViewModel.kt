package evdoo.thingstodo.presentation

import androidx.lifecycle.ViewModel
import evdoo.thingstodo.data.ThingsRepository_Impl
import evdoo.thingstodo.domain.EditThingUseCase
import evdoo.thingstodo.domain.GetThingsListUseCase
import evdoo.thingstodo.domain.RemoveThingUseCase
import evdoo.thingstodo.domain.ThingItem

class MainViewModel : ViewModel() {

    private val repository = ThingsRepository_Impl

    private val getThingsListUseCase = GetThingsListUseCase(repository)
    private val removeThingUseCase = RemoveThingUseCase(repository)
    private val editThingUseCase = EditThingUseCase(repository)

    val thingsList = getThingsListUseCase.getThingsList()

    fun removeThing(thing: ThingItem) {
        removeThingUseCase.removeThing(thing)
    }

    fun changeEnableState(thing: ThingItem) {
        val newItem = thing.copy(enabled = !thing.enabled)
        editThingUseCase.editThing(newItem)
    }
}