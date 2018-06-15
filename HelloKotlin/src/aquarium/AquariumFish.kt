package aquarium

class Shark : FishAction, FishColor {
  override val color =  "gray"

  override fun eat() {
    println("Hunt and eat fish")
  }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("lots of algae"), FishColor by fishColor