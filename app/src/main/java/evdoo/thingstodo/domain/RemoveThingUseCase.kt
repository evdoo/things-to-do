package evdoo.thingstodo.domain

class RemoveThingUseCase(private val thingsRepository: ThingsRepository) {

    fun removeThing(thing: ThingItem) {
        thingsRepository.removeThing(thing)
    }
}