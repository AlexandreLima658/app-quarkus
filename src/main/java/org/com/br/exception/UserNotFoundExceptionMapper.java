package org.com.br.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(final UserNotFoundException e) {
        return Response.status(
                Response.Status.NOT_FOUND
                        .getStatusCode(),
                "User not found"
        ).build();
    }
}
