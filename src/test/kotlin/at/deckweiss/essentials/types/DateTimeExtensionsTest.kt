package at.deckweiss.essentials.types

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.format.DateTimeFormatter

class DateTimeExtensionsTest {

  private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")

  @Test
  fun `Given 1679558723L, when calling epochSecondToZonedDateTime, then the correct ZonedDateTime is returned`() {
    assertEquals("2023-03-23T08:05:23.000Z", 1679558723L.epochSecondToZonedDateTime().format(dateFormat))
  }

  @Test
  fun `Given 1679558723123L, when calling epochMilliToZonedDateTime, then the correct ZonedDateTime is returned`() {
    assertEquals("2023-03-23T08:05:23.123Z", 1679558723123L.epochMilliToZonedDateTime().format(dateFormat))
  }
}