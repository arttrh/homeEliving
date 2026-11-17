package ecommerce.api.home.living.senai;

import javax.print.DocFlavor;
import java.util.List;

public class ValidacaoException extends RuntimeException {
   private final List<String> errors;

    public ValidacaoException(List<String> errors) {
        super(String.join("; ", errors));
        this.errors = List.copyOf(errors);
    }

    public List<String> getErrors(){
        return errors;
    }
}
