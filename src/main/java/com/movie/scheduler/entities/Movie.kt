package com.movie.scheduler.entities

import javax.persistence.*

@Entity
@Table(name = "movie")
data class Movie(
       // @Column(name = "name")
        val name: String="") {

   // @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int=0

   // @Column(name = "language")
    var language: String=""

   // @Column(name = "genre")
    var genre: String=""

    @OneToMany(cascade = arrayOf(CascadeType.ALL),
            mappedBy = "movie",
            fetch = FetchType.LAZY
    )
    var play: List<Play> = emptyList()

    override fun toString(): String{
        return "{name: ${this.name}}}"
    }
}