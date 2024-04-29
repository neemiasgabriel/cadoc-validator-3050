package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;
import lombok.Getter;

import javax.xml.stream.events.XMLEvent;

@Getter
public class CrdPesConTraSetPublico extends CredPF {
  public CrdPesConTraSetPublico(final XMLEvent event, final Pre pre) {
    super(event, pre);
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitCrdPesConTraSetPublico(this);
  }
}
