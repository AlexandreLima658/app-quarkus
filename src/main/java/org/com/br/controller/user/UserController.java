package org.com.br.controller.user;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.com.br.entity.user.UserEntity;
import org.com.br.service.user.UserService;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @POST
    @Transactional
    public Response createUser(final UserEntity user){
        return Response.ok(this.service.create(user)).build();
    }

    @GET
    public Response findAll(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize
    ) {
        final var users = service.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID userId){
        return Response.ok(this.service.findById(userId)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(
            @PathParam("id") UUID userId,
            final UserEntity userEntity
    ){
        return Response.ok(this.service.update(userId, userEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID userId){
        this.service.delete(userId);
        return Response.noContent().build();
    }



}