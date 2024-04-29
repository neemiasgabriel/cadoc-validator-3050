package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
public class CrdLivre extends Tag {
  private Diario diario;

  public CrdLivre(final XMLEvent event, final Diario diario) {
    this.event = event;
    this.diario = diario;
  }

  @Override
  public void accept(final TagVisitor visitor) {
    visitor.visitCrdLivre(this);
  }
}
