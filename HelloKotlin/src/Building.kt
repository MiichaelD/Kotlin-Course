

open class BaseBuildingMaterial() {}

class Brick(): BaseBuildingMaterial() {}

class Building<T: BaseBuildingMaterial>(
    private val buildingMaterial: T, var actualMaterialsNeeded: Int = 5000) {}


fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
  println(if (building.actualMaterialsNeeded < 500) "Small building" else "large building")
}

fun testBuilding() {
  isSmallBuilding(Building(Brick()))
}