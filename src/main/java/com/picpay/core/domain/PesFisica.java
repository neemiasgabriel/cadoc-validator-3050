package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
public class PesFisica extends Tag {
  private CrdLivre crdLivre;

  public PesFisica(final XMLEvent event, final CrdLivre crdLivre) {
    this.event = event;
    this.crdLivre = crdLivre;
  }

  @Override
  public void accept(final TagVisitor visitor) {
    visitor.visitPesFisica(this);
  }
}
