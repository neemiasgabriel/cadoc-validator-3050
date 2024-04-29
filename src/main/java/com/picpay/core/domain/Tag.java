package com.picpay.core.domain;

import com.google.gson.Gson;
import com.picpay.core.enums.TokenType3050;
import com.picpay.core.parser.visitor.TagVisitor;

import javax.xml.namespace.QName;
import javax.xml.stream.events.XMLEvent;

public abstract class Tag {
  protected XMLEvent event;

  public String toJson() {
    return new Gson().toJson(this);
  }

  public String getAttribute(final TokenType3050 attribute) {
    final var attr = event.asStartElement().getAttributeByName(new QName(attribute.key()));
    return attr != null ? attr.getValue() : null;
  }

  public abstract void accept(final TagVisitor visitor);

  public String tagName() {
    return this.getClass().getSimpleName();
  }
}
