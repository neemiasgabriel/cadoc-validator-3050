package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.stream.events.XMLEvent;

public class CrdPesConApoINSS extends CredPF {
  public CrdPesConApoINSS(final XMLEvent event, final Pre pre) {
    super(event, pre);
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitCrdPesConApoINSS(this);
  }
}
