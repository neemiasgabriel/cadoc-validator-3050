package com.picpay.core.domain;

import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.stream.events.XMLEvent;

public class CrdPesNaoConVinComposicao extends CredPF {
  public CrdPesNaoConVinComposicao(final XMLEvent event, final Pre pre) {
    super(event, pre);
  }

  @Override
  public void accept(TagVisitor visitor) {
    visitor.visitCrdPesNaoConVinComposicao(this);
  }
}
