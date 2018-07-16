package aquarium

import kotlin.math.PI

open class Aquarium<out T: WaterSupply>(val waterSupply: T, var length: Int = 100, var width: Int = 20, var height: Int = 40) {

  open var volume: Int
      get() = width * height * length / 1000
      set(value) { height = (value * 1000) / (width * length) }

  open var water :Double = volume * 0.9

  constructor(waterSupply: T, numberOfFish: Int): this(waterSupply) {
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

  /** Needs to be inline and reified to be used in Runtime, replacing R with real type. */
  inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

class TowerAquarium() : Aquarium<FishStoreWater>(FishStoreWater) {

  override var volume: Int
      get() = (width * height * length / 1000 * PI).toInt()
      set(value) { height = (value * 1000) / (width * length) }

  override var water = volume * 0.8
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample() {
  val cleaner = TapWaterCleaner()
  val aquarium = Aquarium(TapWater)
  addItemTo(aquarium) // only works if T is marked as "out" to tell compiler to avoid static check
  aquarium.addWater(cleaner)

  // Generic Functions
  println("Aquarium has clean water? ${isWaterClean(aquarium)}")
  println("Aquarium has TapWater? ${aquarium.hasWaterSupplyOfType<TapWater>()}")
  println("Aquarium has LakeWater? ${aquarium.hasWaterSupplyOfType2<LakeWater>()}")
  println("Aquarium has FishStoreWater? ${aquarium.waterSupply.isOfType<FishStoreWater>()}")
}