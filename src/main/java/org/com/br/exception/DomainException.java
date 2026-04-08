package org.com.br.exception;

public class DomainException extends NoStackTraceException {

    private final ErrorInfo error;

    public DomainException(ErrorInfo error) {
        super(error.message());
        this.error = error;
    }

    public static DomainException with(final ErrorInfo error) {
        return new DomainException(error);
    }
    public static DomainException with(final String message) {
        return new DomainException(new ErrorInfo(message));
    }

    public ErrorInfo errorInfo() {
        return error;
    }
}
