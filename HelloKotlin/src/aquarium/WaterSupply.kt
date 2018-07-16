package aquarium

open class WaterSupply(var needsProcessed: Boolean)

object TapWater: WaterSupply(true) {
  fun addChemicalCleaners() = apply {needsProcessed = false}
}

object FishStoreWater: WaterSupply(false)

object LakeWater: WaterSupply(true) {
  fun filter() = apply {needsProcessed = false}
}

interface Cleaner<in T: WaterSupply> {
  fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
  override fun clean(waterSupply: TapWater) {
    waterSupply.addChemicalCleaners()
  }
}

class LakeWaterCleaner: Cleaner<LakeWater> {
  override fun clean(waterSupply: LakeWater) {
    waterSupply.filter()
  }
}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
  println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T: WaterSupply> Aquarium<*>.hasWaterSupplyOfType2() = waterSupply is T

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

