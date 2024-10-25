package org.acme.microprofile.graphql.client.model

//class PlanetConnection(planets: MutableList<Planet>?) {
//
////    private var planets:MutableList<Planet>? = null
//
//    var planets:MutableList<Planet>? = null
//}

/**
 * 以下のように引数なしコンストラクタで定義しないと500エラーが発生する
 */
class PlanetConnection() {

    var planets: MutableList<Planet>? = null

    constructor(planets: MutableList<Planet>?) : this() {
        this.planets = planets
    }
}