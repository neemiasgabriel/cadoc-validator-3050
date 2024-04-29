package com.picpay.core.parser.validators;

import com.picpay.core.domain.Tag;

public interface Validator<T extends Tag> {
  void accept(final T event);
}
