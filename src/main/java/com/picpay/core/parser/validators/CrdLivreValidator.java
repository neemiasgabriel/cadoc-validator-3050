package com.picpay.core.parser.validators;

import com.picpay.core.domain.CrdLivre;
import com.picpay.core.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CrdLivreValidator implements Validator<CrdLivre> {
  @Override
  public void accept(final CrdLivre tag) {
    if (tag.getDiario() == null) {
      throw new ValidationException("referencia is required");
    }
  }
}
