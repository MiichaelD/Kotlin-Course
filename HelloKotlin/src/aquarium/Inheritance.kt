package aquarium

fun main(args: Array<String>) {
  delegate()
}


fun feedFishes(fishes: Array<FishAction>) {
  fishes.forEach { fish -> fish.eat() }
}

fun delegate() {
  val shark = Shark()
  val pleco = Plecostomus()

  println("Shark: ${shark.color}\nPlecostomus: ${pleco.color}")
  feedFishes(arrayOf(shark, pleco))
}

interface FishAction {
  fun eat()
}

interface FishColor {
  val color: String
}

object GoldColor: FishColor {
  override val color = "gold"
}

//object RedColor: FishColor {
//  override val color = "red"
//}

class PrintingFishAction(private val food: String): FishAction {
  override fun eat() {
    println("eats $food")
  }
}