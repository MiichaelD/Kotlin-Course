
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
  fun trim() {}
  fun fertilize() {}

  @get:OnGet val isGrowing: Boolean = true
  @set:OnSet var needsFood: Boolean = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
  val classObj: KClass<Plant> = Plant::class

  // Print all methods.
  println("$classObj methods:")
  for (method: KFunction<*> in classObj.declaredMemberFunctions) {
    println(method.name)
  }

  // Print all properties.
  println("\n$classObj properties:")
  for (property: KProperty<*> in classObj.declaredMemberProperties) {
    println("${property.name}: ${property.annotations}")
  }

  // Print all annotations.
  println("\n$classObj annotations:")
  for (annotation: Annotation in classObj.annotations) {
    println(annotation.annotationClass.simpleName)
  }

  // Find annotation or null
  val annotated = classObj.findAnnotation<ImAPlant>()
  annotated?.apply { println("\nFound a ImAPlant annotated class") }
}

fun main(args: Array<String>) {
  reflections()
}