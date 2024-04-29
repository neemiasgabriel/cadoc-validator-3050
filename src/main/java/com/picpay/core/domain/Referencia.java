package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

import static com.picpay.core.enums.TokenType3050.DATA_REF;

@Getter
public class Referencia extends Tag {
  private String dataRef;
  private DocTxb docTxb;

  public Referencia(final XMLEvent event, final DocTxb docTxb) {
    this.event = event;
    this.docTxb = docTxb;
    this.dataRef = getAttribute(DATA_REF);
  }

  @Override
  public void accept(final TagVisitor visitor) {
    visitor.visitReferencia(this);
  }
}
