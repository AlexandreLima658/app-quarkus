package org.com.br.exception;

import java.util.UUID;

public class NotFoundException extends DomainException {

    public NotFoundException(final ErrorInfo error) {
        super(error);
    }

    public static NotFoundException with(
            final Class<?> anAggregate,
            final UUID id
    ) {
        final var error = "'%s' with ID '%s' not found!"
                .formatted(anAggregate.getSimpleName(), id);

        return new NotFoundException(new ErrorInfo(error));
    }
}
