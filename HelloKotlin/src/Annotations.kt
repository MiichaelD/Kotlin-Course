
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
  fun trim() {}
  fun fertilize() {}
}

annotation class ImAPlant

fun reflections() {
  val classObj: KClass<Plant> = Plant::class

  // Print all methods.
  println("$classObj methods:")
  for (method: KFunction<*> in classObj.declaredMemberFunctions) {
    println(method.name)
  }

  // Print all annotations.
  println("$classObj annotations:")
  for (annotation: Annotation in classObj.annotations) {
    println(annotation.annotationClass.simpleName)
  }

  // Find annotation or null
  val annotated = classObj.findAnnotation<ImAPlant>()
  annotated?.apply { println("Found a ImAPlant annotated class") }
}

fun main(args: Array<String>) {
  reflections()
}