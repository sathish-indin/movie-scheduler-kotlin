package com.movie.scheduler.controller

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.util.*

data class MoviePlay(
    val movieName: String){

    var movieGenre: String=""
    var movieLanguage: String=""

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    var playTime: Timestamp?=null

    constructor(): this ("")
}

