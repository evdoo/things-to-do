package evdoo.thingstodo.domain

class GetThingUseCase(private val thingsRepository: ThingsRepository) {

    fun getThing(thingId: Int): ThingItem = thingsRepository.getThing(thingId)
}