package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
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
