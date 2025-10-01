package at.deckweiss.essentials.types

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun Long.epochSecondToZonedDateTime(zone: ZoneId = ZoneId.of("UTC")): ZonedDateTime {
  return Instant.ofEpochSecond(this).atZone(zone)
}

fun Long.epochMilliToZonedDateTime(zone: ZoneId = ZoneId.of("UTC")): ZonedDateTime {
  return Instant.ofEpochMilli(this).atZone(zone)
}