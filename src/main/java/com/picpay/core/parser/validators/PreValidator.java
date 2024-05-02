package com.picpay.core.parser.validators;

import com.picpay.core.domain.Pre;
import com.picpay.core.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class PreValidator implements Validator<Pre> {
  @Override
  public void accept(final Pre tag) {
    if (tag.getPesFisica() == null) {
      throw new ValidationException("A tag pesFisica era esperada antes da tag pre. Houve uma falha de hierarquia no arquivo.");
    }
  }
}
