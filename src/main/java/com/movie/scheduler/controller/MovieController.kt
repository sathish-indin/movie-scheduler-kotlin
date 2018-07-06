package com.movie.scheduler.controller

import com.movie.scheduler.entities.Movie
import com.movie.scheduler.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/movie-scheduler")
open class MovieController(
        @Autowired
        val movieRepository: MovieRepository) {

    @PostMapping("/proposeMovie")
    fun proposeMovie(@RequestBody moviePlay: MoviePlay): ResponseEntity<MoviePlay> {

        movieRepository.proposeMoviePlay(moviePlay)
        return ResponseEntity(moviePlay, HttpStatus.CREATED)
    }

    @GetMapping("/getMovie")
    fun getMovie(@RequestParam id: Int): ResponseEntity<MoviePlay> {

    val movie:Movie = movieRepository.getMovie(id)
        return ResponseEntity(buildMoviePlay(movie), HttpStatus.CREATED)
    }

    private fun buildMoviePlay(movie: Movie): MoviePlay {

        var moviePlay: MoviePlay=MoviePlay(movie.name)
        moviePlay.movieGenre=movie.genre
        moviePlay.movieLanguage=movie.genre
        moviePlay.playTime=null
        return moviePlay

    }

    @GetMapping("/getMovies")
    fun getMovies(): ResponseEntity<List<MoviePlay>> {
       return ResponseEntity(movieRepository.getMovies().map { movie: Movie -> buildMoviePlay(movie) }.toList(), HttpStatus.CREATED)
    }

    @GetMapping("/getProposedMovies")
    fun getPropsedMovies():ResponseEntity<List<MoviePlay>> = ResponseEntity(movieRepository.getProposedMovies().map { movie: Movie -> buildMoviePlay(movie) }.toList(),HttpStatus.CREATED)
}