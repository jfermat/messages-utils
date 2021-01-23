package io.jfermat.messages.model;

public class ClassMessage implements io.jfermat.messages.Message {

    private final String message;
    private final Object[] args;

    public ClassMessage(String message, Object... args) {
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArgs() {
        return args;
    }
}
