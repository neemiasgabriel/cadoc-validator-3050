package com.picpay.core.parser.validators;

import com.picpay.core.domain.Diario;
import com.picpay.core.exceptions.ValidationException;

public class DiarioValidator implements Validator<Diario> {
  @Override
  public void accept(final Diario tag) {
    if (tag.getReferencia() == null) {
      throw new ValidationException("referencia is required");
    }
  }
}
