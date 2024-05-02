package com.picpay.core.log;

import com.picpay.core.enums.LogType;

public interface SimpleLog {
  default String log(final LogType logType, final String msg) {
    return logType.type() + "Message: " + msg;
  }
}
