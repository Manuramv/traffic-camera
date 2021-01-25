package com.zuhlke.map.utils

import java.text.SimpleDateFormat

object DateParser {
    fun parseCameraDate(date: String): String {
        try{
            val serverDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse(date)
            val format = SimpleDateFormat("MMMM dd,yyyy HH:mm:ss")
            val formatted: String = format.format(serverDate)
            return formatted
        } catch (e:Exception){
            return ""
        }
    }
}