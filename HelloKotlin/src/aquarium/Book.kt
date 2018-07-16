package aquarium

open class Book(
    val title:String, val author:String, val year:Int = 2000, var pages: Int = 100) {

  private var currentPage = 1

  open fun readPage() {
    ++currentPage
  }

  companion object {
    const val MAX_BOOKS = 3;
  }

  object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
  }

  fun getTitleAndAuthor(): Pair<String, String> {
    return (title to author)
  }

  fun getTitleAuthorAndYear(): Triple<String, String, Int> {
    return Triple(title, author, year)
  }

  fun canBorrow(hasBooks: Int): Boolean {
    return hasBooks < MAX_BOOKS
  }

  fun printUrl() {
    println(Constants.BASE_URL + title + ".html")
  }
}

class EBook(title:String, author:String, val format:String = "yrcy")
  : Book(title, author) {

  private var wordCount = 0

  override fun readPage() {
    wordCount += 250
  }
}

fun staticTestCollections() {
  val book = Book("X", "Y", 1991)
  println("Here is your book '${book.title}' written by '${book.author}' in ${book.year}")

  val shakespeare: String = "William Shakespeare"

  val romeoAndJuliet = Book("Romeo and Juliet", shakespeare, 1597)
  val twelfthNight = Book("Twelfth night", shakespeare, 1602)
  val asYouLikeIt = Book("As you like it", shakespeare, 1603)
  val othello = Book("Hamlet", shakespeare, 1604)
  val hamlet = Book("Hamlet", shakespeare, 1609)
  val wintersTale = Book("Winter's tale", shakespeare, 1611)


  val allBooks:Set<Book> =
      setOf(romeoAndJuliet, twelfthNight, asYouLikeIt, othello, hamlet, wintersTale)

  val library:Map<String, Set<Book>> = mapOf((shakespeare to allBooks))
  println("Is hamlet in the library? ${library.any { it.value.contains(hamlet) }}")

  val moreBooks: MutableMap<String, String> = mutableMapOf("Wilhelm Tell" to "Schiller")
  moreBooks.getOrPut("Jungle Book") { "Kipling" }
  moreBooks.getOrPut("Hamlet") { "Shakespeare" }
  println(moreBooks)
}


fun Book.getWeight(): Float {
  return pages * 1.5f
}

fun Book.tornPages(pagesTorn: Int) {
  pages -= pagesTorn
  if (pages < 0) pages = 0
}

class Puppy {
  fun playWithBook(book: Book) {
    book.tornPages(Math.ceil(Math.random()*10).toInt())
  }
}

fun staticPuppyTest() {
  val book = Book("Romeo and Juliet", "William Shakespeare")
  val puppy = Puppy()


  while (book.pages > 0) {
    println("Book: ${book.title} has ${book.pages} left, it weights ${book.getWeight()}")
    puppy.playWithBook(book)
  }
  println("Book: ${book.title} has ${book.pages} left")
}

fun main(args: Array<String>) {
//  staticTestCollections()
  staticPuppyTest()
}