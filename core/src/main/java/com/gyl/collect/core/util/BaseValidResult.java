package com.gyl.collect.core.util;

import java.util.ArrayList;
import java.util.List;

public class BaseValidResult implements ValidResult {
    private int code;
    private List<String> messages;

    public BaseValidResult() {
        this.code = 1;
    }

    public BaseValidResult(int code) {
        this.code = code;
    }

    public BaseValidResult(int cod, String message) {
        this.code = code;
        this.messages = new ArrayList<>();
        this.messages.add(message);
    }

    public void addMessage(String message) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(message);
    }

    @Override
    public boolean isValid() {
        return code > 0 && (null == messages || messages.size() == 0);
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String mergeMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messages.size(); i++) {
            sb.append(i + 1).append(".").append(messages.get(i));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public int getCode() {
        return code;
    }
}
