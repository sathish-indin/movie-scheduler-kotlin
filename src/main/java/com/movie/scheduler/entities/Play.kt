package com.movie.scheduler.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "movieplay")
data class Play(
        @Id
       // @Column(name = "playid")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val playid: Int=0) {

       // @Column(name = "state")
        var state: String=""

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "movieid")
        var movie: Movie?=null

        //@Column(name = "playtime")
        var playtime: Date?=null

        //@Column(name = "upvote")
        var upvote: Int=0

    override fun toString(): String{
        return "{name: ${this.state}}}"
    }

}
