package org.acme.microprofile.graphql.client.model

//class Film(title:String?, planetConnection:PlanetConnection?) {
//
////    private var title:String? = null
////    private var planetConnection:PlanetConnection? = null
//
//    var title:String? = null
//    var planetConnection:PlanetConnection? = null
//}

/**
 * 以下のように引数なしコンストラクタで定義しないと500エラーが発生する
 */
class Film() {

    var title: String? = null
    var planetConnection: PlanetConnection? = null

    constructor(title: String?, planetConnection: PlanetConnection?) : this() {
        this.title = title
        this.planetConnection = planetConnection
    }
}