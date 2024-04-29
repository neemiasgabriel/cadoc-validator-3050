package com.picpay.core.parser.validators;

import com.picpay.core.domain.CrdPesConTraSetPublico;
import com.picpay.core.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrdPesConTraSetPublicoValidator implements Validator<CrdPesConTraSetPublico> {
  @Override
  public void accept(final CrdPesConTraSetPublico tag) {
    validateTxMedJuros(tag.getTxMedJuros());
    validateTxMedEncFiscais(tag.getTxMedEncFiscais());
    validateTxMedEncOperacionais(tag.getTxMedEncOperacionais());
    validateVlrConcessoes(tag.getVlrConcessoes());
    validatePrzDecMedConcessoes(tag.getPrzDecMedConcessoes());
    validateSldCarAtiva(tag.getSldCarAtiva());
  }

  private void validateTxMedJuros(final String txMedJuros) {
    if (txMedJuros == null) {
      throw new ValidationException("txMedJuros is required");
    }
  }

  private void validateTxMedEncFiscais(final String txMedEncFiscais) {
    if (txMedEncFiscais == null) {
      throw new ValidationException("txMedEncFiscais is required");
    }
  }

  private void validateTxMedEncOperacionais(final String txMedEncOperacionais) {
    if (txMedEncOperacionais == null) {
      throw new ValidationException("txMedEncOperacionais is required");
    }
  }

  private void validateVlrConcessoes(final String vlrConcessoes) {
    if (vlrConcessoes == null) {
      throw new ValidationException("vlrConcessoes is required");
    }
  }

  private void validateSldCarAtiva(final String sldCardAtiva) {
    if (sldCardAtiva == null) {
      throw new ValidationException("sldCardAtiva is required");
    }
  }

  private void validatePrzDecMedConcessoes(final String przDecMedConcessoes) {
    if (przDecMedConcessoes == null) {
      throw new ValidationException("przDecMedConcessoes is required");
    }

    final var prz = Integer.parseInt(przDecMedConcessoes);

    if (prz == 0) {
      throw new ValidationException("O Prazo à Decorrer Médio das Concessões (PM Conc) não pode ser zero.");
    }
  }
}
