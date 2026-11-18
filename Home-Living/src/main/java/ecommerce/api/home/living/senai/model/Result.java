package ecommerce.api.home.living.senai.model;

import java.util.List;
import java.util.Objects;

public final class Result<T, E> {
    private final T value;
    private final List<String> errors;

    private Result(T value, List<String> errors) {
        this.value = value;
        this.errors = errors;
    }

    public static <T, E> Result<T, E> ok(T value) {
        return new Result<>(value, List.of());
    }

    public static <T, E> Result<T, E> fail(List<String> errors) {
        return new Result<>(null, Objects.requireNonNull(errors));
    }

    public boolean isOk() {
        return errors.isEmpty();
    }

    public T value() {
        return value;
    }

    public List<String> errors() {
        return errors;
    }
}


