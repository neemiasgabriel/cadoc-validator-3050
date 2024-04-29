package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.stream.events.XMLEvent;

import java.util.ArrayList;
import java.util.List;

import static com.picpay.core.enums.TokenType3050.CNPJ_INSTITUICAO;
import static com.picpay.core.enums.TokenType3050.DATA_BASE;
import static com.picpay.core.enums.TokenType3050.IND_REMESSA;
import static com.picpay.core.enums.TokenType3050.NM_CONTATO;
import static com.picpay.core.enums.TokenType3050.TEL_CONTATO;

public class DocTxb extends Tag {
  private String cnpjInstituicao;
  private String dataBase;
  private String indRemessa;
  private String nmContato;
  private String telContato;
  private List<Referencia> referencias;

  public DocTxb(final XMLEvent event) {
    this.event = event;

    this.cnpjInstituicao = getAttribute(CNPJ_INSTITUICAO);
    this.dataBase = getAttribute(DATA_BASE);
    this.indRemessa = getAttribute(IND_REMESSA);
    this.nmContato = getAttribute(NM_CONTATO);
    this.telContato = getAttribute(TEL_CONTATO);
    this.referencias = new ArrayList<>();
  }

  @Override
  public void accept(final TagVisitor visitor) {
    visitor.visitDocTxb(this);
  }
}
