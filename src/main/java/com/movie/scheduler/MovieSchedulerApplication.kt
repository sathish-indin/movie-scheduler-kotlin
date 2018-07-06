package com.movie.scheduler

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class MovieSchedulerApplication

fun main(args: Array<String>){
    SpringApplication.run(MovieSchedulerApplication::class.java,*args)
}




