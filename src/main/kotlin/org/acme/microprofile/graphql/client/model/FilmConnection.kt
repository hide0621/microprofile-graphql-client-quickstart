package org.acme.microprofile.graphql.client.model

//class FilmConnection(films: MutableList<Film>?) {
//
////    private var films:MutableList<Film>? = null
//    var films:MutableList<Film>? = null
//
//}

/**
 * 以下のように引数なしコンストラクタで定義しないと500エラーが発生する
 */
class FilmConnection() {

    var films: MutableList<Film>? = null

    constructor(films: MutableList<Film>?) : this() {
        this.films = films
    }
}