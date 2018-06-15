package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

  val size: Int

  init {
    println("First init block")
  }

  constructor(): this(volumeNeeded = 9) {
    println("Running secondary constructor")
  }

  init {
    size = if (friendly) volumeNeeded else volumeNeeded * 2
  }

  init {
    println("Constructed fish of size $volumeNeeded - Final size: $size")
  }

  init {
    println("Last init block")
  }
}

fun makeDefaultFish() = Fish(true, 50)

fun fishExample() {
  var fish = Fish(true, 20)
  printFish(fish)

  fish = Fish()
  printFish(fish)

  fish = makeDefaultFish()
  printFish(fish)
}

fun printFish(fish: Fish) {
  println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}\n")
}