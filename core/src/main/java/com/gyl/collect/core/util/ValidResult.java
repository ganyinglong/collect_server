package com.gyl.collect.core.util;

import java.util.List;

public interface ValidResult {

    boolean isValid();

    List<String> getMessages();

    String mergeMessage();

    int getCode();
}
