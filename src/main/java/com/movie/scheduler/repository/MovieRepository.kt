package com.movie.scheduler.repository

import com.movie.scheduler.controller.MoviePlay
import com.movie.scheduler.entities.Movie
import com.movie.scheduler.entities.Play
import org.springframework.stereotype.Repository
import java.sql.Date
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
open class MovieRepository {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    @Transactional
    open fun proposeMovie(movie: Movie) {
        print(entityManager);
        entityManager.persist(movie);
    }

    @Transactional
    open fun proposeMoviePlay(moviePlay: MoviePlay) {

        val movie: Movie=Movie(moviePlay.movieName)
        movie.language=moviePlay.movieLanguage
        movie.genre=moviePlay.movieGenre

        val play: Play=Play()
        play.movie=movie
        val playtime= moviePlay.playTime
        play.playtime=if(playtime!=null){Date(playtime.time)} else null
        play.state="Proposed"
        play.upvote=1

        entityManager.persist(movie)
        entityManager.persist(play)
    }

    open fun getMovies(): List<Movie> =entityManager.createQuery("select m from Movie m", Movie::class.java).resultList

    open fun getMovie(id:Int): Movie = entityManager.find(Movie::class.java,id)

    open fun getProposedMovies(): List<Movie>{
        return entityManager.createQuery("select movie from Movie as movie left join movie.play as play ",Movie::class.java).resultList
    }
}

