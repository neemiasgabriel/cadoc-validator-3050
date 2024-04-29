package com.picpay.core.parser.stack;


import com.picpay.core.domain.Tag;

public interface LifoStack {
  Tag peek();
  Tag pop(final String expectedTag);
  void push(Tag tag);
}