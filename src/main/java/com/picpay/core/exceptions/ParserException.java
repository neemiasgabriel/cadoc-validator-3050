package com.picpay.core.exceptions;

public final class ParserException extends RuntimeException {
  public ParserException(final String message) {
    super(message);
  }

  public ParserException(final String message, final Throwable e) {
    super(message, e);
  }
}
