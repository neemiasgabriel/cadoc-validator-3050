package com.picpay.core.parser.validators;

import com.picpay.core.domain.Pre;
import com.picpay.core.exceptions.ValidationException;

public class PreValidator implements Validator<Pre> {
  @Override
  public void accept(final Pre tag) {
    if (tag.getPesFisica() == null) {
      throw new ValidationException("pesFisica is required");
    }
  }
}
