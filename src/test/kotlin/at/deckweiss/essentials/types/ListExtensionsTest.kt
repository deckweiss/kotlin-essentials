package at.deckweiss.essentials.types

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ListExtensionsTest {
  private val targetList = listOf("one", "two", "three", "four", "five")
  private val listExactlySame = listOf("one", "two", "three", "four", "five")
  private val listInDiffSizeButWithSameElements = listOf("one", "two", "three", "four", "five", "five", "five")
  private val listInDiffSizeAndElements = listOf("one", "two", "three", "four", "five", "five", "five", "I am a new element")
  private val listInDiffOrder = listOf("two", "one", "three", "five", "four")
  private val listInDiffElement = listOf("ONE", "two", "three", "four", "FIVE")

  private val targetComplexList = listOf(1 to "one", 2 to "two")
  private val listExactlySameComplex = listOf(1 to "one", 2 to "two")
  private val listInDiffSizeAndElementsComplex = listOf(1 to "one", 3 to "two", 4 to "five")

  @Test
  fun `Given simple list, when comparing to lists of different or same order, then lists are still equal`() {
    targetList.let {
      assertTrue(listExactlySame.equalsIgnoreOrder(it))
      assertTrue(listInDiffOrder.equalsIgnoreOrder(it))
      assertFalse(listInDiffSizeButWithSameElements.equalsIgnoreOrder(it))
      assertFalse(listInDiffSizeAndElements.equalsIgnoreOrder(it))
      assertFalse(listInDiffElement.equalsIgnoreOrder(it))
    }
  }

  @Test
  fun `Given complex list, when comparing to lists of different or same order, then lists are still equal`() {
    targetComplexList.let {
      assertTrue(listExactlySameComplex.equalsIgnoreOrder(it) { (key, _) -> key.toString() })
      assertFalse(listInDiffSizeAndElementsComplex .equalsIgnoreOrder(it) { (key, _) -> key.toString() })
    }
  }
}
