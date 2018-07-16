package aquarium

import kotlin.math.PI

open class Aquarium<out T: WaterSupply>(val waterSupply: T, var length: Int = 100, var width: Int = 20, var height: Int = 40) {

  open var volume: Int
      get() = width * height * length / 1000
      set(value) { height = (value * 1000) / (width * length) }

  open var water :Double = volume * 0.9

  constructor(numberOfFish: Int): this() {
    val water: Int = numberOfFish * 2000 // cm3
    val tank:Double = water * 1.1
    height = (tank / (length * width)).toInt()
  }

  fun addWater(cleaner: Cleaner<T>) {
    if(waterSupply.needsProcessed) {
      cleaner.clean(waterSupply)
    }
    check(!waterSupply.needsProcessed) { "water supply needs to be processed"}

    println("adding water from $waterSupply")
  }
}

class TowerAquarium() : Aquarium<FishStoreWater>(FishStoreWater) {

  override var volume: Int
      get() = (width * height * length / 1000 * PI).toInt()
      set(value) { height = (value * 1000) / (width * length) }

  override var water = volume * 0.8
}

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

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample() {
  val cleaner = TapWaterCleaner()
  val aquarium = Aquarium(TapWater)
  addItemTo(aquarium) // only works if T is marked as "out" to tell compiler to avoid static check
  aquarium.addWater(cleaner)
}