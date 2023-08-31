package evdoo.thingstodo.domain

class GetThingsListUseCase(private val thingsRepository: ThingsRepository) {

    fun getThingsList() : List<ThingItem> = thingsRepository.getThingsList()
}