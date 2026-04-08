package org.com.br.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(final NotFoundException e) {

        final var error = new ErrorInfo(e.getMessage());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
