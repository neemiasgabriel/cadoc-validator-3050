package com.picpay.core.parser.validators;

import com.picpay.core.domain.Referencia;
import com.picpay.core.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReferenciaValidator implements Validator<Referencia> {
  private final DateValidator dateValidator;

  @Override
  public void accept(final Referencia tag) {
    if (tag.getDocTxb() == null) {
      throw new ValidationException("docTxb is required");
    }

    validateDatRef(tag.getDataRef());
  }

  private void validateDatRef(final String datRef) {
    if (datRef == null) {
      throw new ValidationException("datRef is required");
    }

    if (!dateValidator.isYearMonthDay(datRef)) {
      throw new ValidationException("datRef is invalid");
    }
  }
}
