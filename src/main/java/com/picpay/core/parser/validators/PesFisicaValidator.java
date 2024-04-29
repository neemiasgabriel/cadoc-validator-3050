package com.picpay.core.parser.validators;

import com.picpay.core.domain.PesFisica;
import com.picpay.core.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class PesFisicaValidator implements Validator<PesFisica> {
  @Override
  public void accept(final PesFisica tag) {
    if (tag.getCrdLivre() == null) {
      throw new ValidationException("crdLivre is required");
    }
  }
}
