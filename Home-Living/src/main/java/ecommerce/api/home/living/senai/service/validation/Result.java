package ecommerce.api.home.living.senai.service.validation;

import java.util.List;

public final class Result<T> {
    private final T value;
    private final List<String> errors;

    private Result(T value, List<String> errors){
        this.value = value;
        this.errors = errors;
    }

    public static <T> Result<T> ok(T value){
        return new Result<>(value, List.of());
    }

    public static <T> Result<T> fail(List<String> errors){
        return new Result<>(null, errors);
    }

    public boolean isOk(){
        return errors.isEmpty();
    }

    public T value(){
        return value;
    }

    public List<String> errors(){return errors;}
}


