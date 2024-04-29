package com.picpay.core.domain;

import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

import static com.picpay.core.enums.TokenType3050.PRZ_DEC_MED_CONCESSOES;
import static com.picpay.core.enums.TokenType3050.SLD_CAR_ATIVA;
import static com.picpay.core.enums.TokenType3050.TX_MED_ENC_FISCAIS;
import static com.picpay.core.enums.TokenType3050.TX_MED_ENC_OPERACIONAIS;
import static com.picpay.core.enums.TokenType3050.TX_MED_JUROS;
import static com.picpay.core.enums.TokenType3050.VLR_CONCESSOES;

@Getter
public abstract class CredPF extends Tag {
  protected String txMedJuros;
  protected String txMedEncFiscais;
  protected String txMedEncOperacionais;
  protected String vlrConcessoes;
  protected String przDecMedConcessoes;
  protected String sldCardAtiva;

  protected Pre pre;

  public CredPF(final XMLEvent event, final Pre pre) {
    this.event = event;
    this.pre = pre;

    this.txMedJuros = getAttribute(TX_MED_JUROS);
    this.txMedEncFiscais = getAttribute(TX_MED_ENC_FISCAIS);
    this.txMedEncOperacionais = getAttribute(TX_MED_ENC_OPERACIONAIS);
    this.vlrConcessoes = getAttribute(VLR_CONCESSOES);
    this.przDecMedConcessoes = getAttribute(PRZ_DEC_MED_CONCESSOES);
    this.sldCardAtiva = getAttribute(SLD_CAR_ATIVA);
  }
}
