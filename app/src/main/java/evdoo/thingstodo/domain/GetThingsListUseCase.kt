package evdoo.thingstodo.domain

import androidx.lifecycle.LiveData

class GetThingsListUseCase(private val thingsRepository: ThingsRepository) {

    fun getThingsList() : LiveData<List<ThingItem>> = thingsRepository.getThingsList()
}