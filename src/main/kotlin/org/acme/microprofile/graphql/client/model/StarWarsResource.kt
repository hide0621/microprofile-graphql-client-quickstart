package org.acme.microprofile.graphql.client.model

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jetbrains.annotations.Blocking

@Path("/")
class StarWarsResource {

    @Inject
    lateinit var typesafeClient: StarWarsClientApi

    @GET
    @Path("/typesafe")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    fun getAllFilmsUsingTypesafeClient(): List<Film>? {
        return typesafeClient.allFilms().films
    }
}