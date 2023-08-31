package evdoo.thingstodo.domain

class EditThingUseCase(private val thingsRepository: ThingsRepository) {

    fun editThing(thing: ThingItem) {
        thingsRepository.editThing(thing)
    }
}