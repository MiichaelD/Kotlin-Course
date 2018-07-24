package aquarium

fun main(args: Array<String>) {
  buildAquarium()
}

fun buildAquarium() {
  val myAquarium = Aquarium(FishStoreWater)

  println("Length: ${myAquarium.length}, Width: ${myAquarium.width}, " +
      "Height: ${myAquarium.height}")

  myAquarium.height = 80

  println("Height: ${myAquarium.height} cm")
  println("Volume: ${myAquarium.volume} liters")

  val smallAquarium = Aquarium(FishStoreWater,20, 15, 30)
  println("Volume: ${smallAquarium.volume} liters")

  val myAquarium2 = Aquarium(FishStoreWater, numberOfFish = 9)
  println("Small Aquarium 2: ${myAquarium2.volume} liters with Length: ${myAquarium2.length}, " +
      "Width: ${myAquarium2.width}, Height: ${myAquarium2.height}")

  fishExample()
}