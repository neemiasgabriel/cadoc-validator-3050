package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.stream.events.XMLEvent;

public class Pre extends Tag {
  private PesFisica pesFisica;

  public Pre(final XMLEvent event, final PesFisica pesFisica) {
    this.event = event;
    this.pesFisica = pesFisica;
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitPre(this);
  }
}
