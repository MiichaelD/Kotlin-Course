

class Book(val title:String, val author:String, val year:Int = 2000) {

  fun getTitleAndAuthor(): Pair<String, String> {
    return (title to author)
  }

  fun getTitleAuthorAndYear(): Triple<String, String, Int> {
    return Triple(title, author, year)
  }
}

fun main(args: Array<String>) {
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