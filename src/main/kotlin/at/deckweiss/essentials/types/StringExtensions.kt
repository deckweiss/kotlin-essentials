package at.deckweiss.essentials.types

fun String?.nullIfBlank(): String? {
  if (this == null) {
    return null
  }

  if (this.isBlank()) {
    return null
  }

  return this
}

fun String.truncate(length: Int, ellipsis: String = "..."): String {
  return if (this.length > length && this.length > ellipsis.length) {
    "${this.take(length)}$ellipsis"
  } else {
    this
  }
}
