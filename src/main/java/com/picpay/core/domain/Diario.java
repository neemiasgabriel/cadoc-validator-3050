package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
public class Diario extends Tag {
  private Referencia referencia;

  public Diario(final XMLEvent event, final Referencia referencia) {
    this.event = event;
    this.referencia = referencia;
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitDiario(this);
  }
}
