package evdoo.thingstodo.domain

class AddThingUseCase(private val thingsRepository: ThingsRepository) {

    fun addThing(thing: ThingItem) {
        thingsRepository.addThing(thing)
    }
}