package com.teamunknown.application.utils

import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter


class TimeUtil {

    companion object {
        @JvmStatic
        fun getDateTimeFormatString(zonedDateTime: ZonedDateTime?, patter: String) : String {
            return (zonedDateTime ?: ZonedDateTime.now()).withZoneSameInstant(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(patter))
        }
    }
}