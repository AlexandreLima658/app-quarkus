package org.com.br.controller.category;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.com.br.entity.category.CategoryEntity;
import org.com.br.service.category.CategoryService;

import java.util.UUID;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

    private final CategoryService service;

    public CategoryController(final CategoryService service) {
        this.service = service;
    }

    @POST
    @Transactional
    public Response createCategory(final CategoryEntity category){
        return Response.ok(this.service.create(category)).build();
    }

    @GET
    public Response findAll(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("perSize")@DefaultValue("10") Integer pageSize
    ) {
        final var categories = service.findAll(page, pageSize);
        return Response.ok(categories).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID categoryId){
        return Response.ok(this.service.findById(categoryId)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCategory(
            @PathParam("id") UUID categoryId,
            final CategoryEntity category
    ){
        return Response.ok(this.service.update(categoryId, category)).build();
    }



}
