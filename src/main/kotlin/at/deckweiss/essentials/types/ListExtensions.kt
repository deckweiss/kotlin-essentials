package at.deckweiss.essentials.types

fun <T> List<T>.equalsIgnoreOrder(other: List<T>, mapper: ((item: T) -> String)? = null): Boolean {
  val list1 = if (mapper != null) this.map { mapper(it) } else this
  val list2 = if (mapper != null) other.map { mapper(it) } else other
  return list1.size == list2.size && list1.toSet() == list2.toSet()
}