package org.acme.microprofile.graphql.client.model

//class Planet(name:String?) {
//
////    private var name:String? = null
//
//    var name:String? = null
//}

/**
 * 以下のように引数なしコンストラクタで定義しないと500エラーが発生する
 */
class Planet() {

    var name: String? = null

    constructor(name: String?) : this() {
        this.name = name
    }
}