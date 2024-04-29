package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
public class CrdPesConTraSetPublico extends CrdLivrePF {
  public CrdPesConTraSetPublico(final XMLEvent event, final Pre pre) {
    super(event, pre);
  }

  @Override
  public void accept(final TagVisitor visitor) {
    visitor.visitCrdLivrePf(this);
  }
}
