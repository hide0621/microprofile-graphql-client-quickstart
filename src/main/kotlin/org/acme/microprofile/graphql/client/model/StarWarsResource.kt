package org.acme.microprofile.graphql.client.model

import io.smallrye.graphql.client.GraphQLClient
import io.smallrye.graphql.client.core.Document
import io.smallrye.graphql.client.core.Field
import io.smallrye.graphql.client.core.Operation
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.jetbrains.annotations.Blocking
import kotlin.jvm.Throws

@Path("/")
class StarWarsResource {

    @Inject
    lateinit var typesafeClient: StarWarsClientApi

    @Inject
    @GraphQLClient("star-wars-dynamic")
    lateinit var dynamicClient: DynamicGraphQLClient

    @GET
    @Path("/typesafe")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    fun getAllFilmsUsingTypesafeClient(): List<Film>? {
        return typesafeClient.allFilms().films
    }

    @GET
    @Path("/dynamic")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    @Throws(Exception::class)
    fun getAllFilmsUsingDynamicClient(): List<Film>? {
        val query: Document = Document.document(
            Operation.operation(
                Field.field(
                    "allFilms",
                    Field.field(
                        "films",
                        Field.field("title"),
                        Field.field("planetConnection", Field.field("planets", Field.field("name")))
                    )
                )
            )
        )
        val response: io.smallrye.graphql.client.Response = dynamicClient.executeSync(query)
        return response.getObject(FilmConnection::class.java, "allFilms").films
    }
}