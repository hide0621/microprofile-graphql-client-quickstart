package org.acme.microprofile.graphql.client.model

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi

@GraphQLClientApi(configKey = "star-wars-typesafe")
interface StarWarsClientApi {

    fun allFilms(): FilmConnection
}