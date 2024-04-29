package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.stream.events.XMLEvent;

public class PesFisica extends Tag {
  private CrdLivre crdLivre;

  public PesFisica(final XMLEvent event, final CrdLivre crdLivre) {
    this.event = event;
    this.crdLivre = crdLivre;
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitPesFisica(this);
  }
}
