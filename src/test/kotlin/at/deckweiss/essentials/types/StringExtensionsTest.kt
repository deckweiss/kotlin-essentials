package at.deckweiss.essentials.types

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringExtensionsTest {

  // region nullIfBlank

  @Test
  fun `Given asdf, when calling nullIfEmpty, then asdf is returned`() {
    assertEquals("asdf", "asdf".nullIfBlank())
  }

  @Test
  fun `Given empty string, when calling nullIfEmpty, then null is returned`() {
    assertEquals(null, "".nullIfBlank())
  }

  @Test
  fun `Given blank string, when calling nullIfEmpty, then null is returned`() {
    assertEquals(null, "   ".nullIfBlank())
  }

  @Test
  fun `Given null, when calling nullIfEmpty, then null is returned`() {
    assertEquals(null, null.nullIfBlank())
  }

  // endregion

  // region truncate

  @Test
  fun `Given AA, when calling truncate with 1 length, then AA is returned`() {
    assertEquals("AA", "AA".truncate(1))
  }

  @Test
  fun `Given AA, when calling truncate with 2 length, then AA is returned`() {
    assertEquals("AA", "AA".truncate(2))
  }

  @Test
  fun `Given AA, when calling truncate with 3 length, then AA is returned`() {
    assertEquals("AA", "AA".truncate(3))
  }

  @Test
  fun `Given AA, when calling truncate with 0 length, then AA is returned`() {
    assertEquals("AA", "AA".truncate(0))
  }

  @Test
  fun `Given AAAAAAAA, when calling truncate with 3 length, then AAA-- is returned`() {
    assertEquals("AAA--", "AAAAAAAA".truncate(3, "--"))
  }

  @Test
  fun `Given AAAAAAAAAAAAAAAAAAAAAAAAAA, when calling truncate with 10 length, then AAAAAAAAAA-- is returned`() {
    assertEquals("AAAAAAAAAA--", "AAAAAAAAAAAAAAAAAAAAAAAAAA".truncate(10, "--"))
  }

  // endregion
}