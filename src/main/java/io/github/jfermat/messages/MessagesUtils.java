package io.github.jfermat.messages;

import java.util.*;

public final class MessagesUtils {

    private static final String LEVEL_PRIMARY = "primary";
    private static final String LEVEL_SECONDARY = "secondary";
    private static final String LEVEL_SUCCESS = "success";
    private static final String LEVEL_DANGER = "danger";
    private static final String LEVEL_WARNING = "warning";
    private static final String LEVEL_INFO = "info";
    private static final String LEVEL_LIGHT = "light";
    private static final String LEVEL_DARK = "dark";
    private static final String LEVEL_MUTED = "muted";
    private static final String LEVEL_WHITE = "white";
    public static final String MESSAGE_MUST_NOT_BE_NULL = "message must not be null";

    private MessagesUtils() {
        throw new UnsupportedOperationException();
    }

    private static final ThreadLocal<String> BUNDLE_NAME = ThreadLocal.withInitial(String::new);
    private static final ThreadLocal<Locale> LOCALE = ThreadLocal.withInitial(Locale::getDefault);
    private static final ThreadLocal<Map<String, List<String>>> MESSAGES =
            ThreadLocal.withInitial(HashMap::new);

    public static void withBundle(String bundleName) {
        BUNDLE_NAME.set(bundleName);
    }

    public static void withLocale(Locale locale) {
        LOCALE.set(locale);
    }

    public static void addPrimaryMessage(Message message) {
        addMessage(LEVEL_PRIMARY, message);
    }

    public static void addPrimaryMessage(String message, Object... args) {
        addMessage(LEVEL_PRIMARY, message, args);
    }

    public static void addPrimaryPropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_PRIMARY, message.getMessage(), message.getArgs());
    }

    public static void addPrimaryPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_PRIMARY, key, args);
    }

    public static void addSecondaryMessage(Message message) {
        addMessage(LEVEL_SECONDARY, message);
    }

    public static void addSecondaryMessage(String message, Object... args) {
        addMessage(LEVEL_SECONDARY, message, args);
    }

    public static void addSecondaryPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_SECONDARY, message.getMessage(), message.getArgs());
    }

    public static void addSecondaryPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_SECONDARY, key, args);
    }

    public static void addSuccessMessage(Message message) {
        addMessage(LEVEL_SUCCESS, message);
    }

    public static void addSuccessMessage(String message, Object... args) {
        addMessage(LEVEL_SUCCESS, message, args);
    }

    public static void addSuccessPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_SUCCESS, message.getMessage(), message.getArgs());
    }

    public static void addSuccessPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_SUCCESS, key, args);
    }

    public static void addDangerMessage(Message message) {
        addMessage(LEVEL_DANGER, message);
    }

    public static void addDangerMessage(String message, Object... args) {
        addMessage(LEVEL_DANGER, message, args);
    }

    public static void addDangerPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_DANGER, message.getMessage(), message.getArgs());
    }

    public static void addDangerPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_DANGER, key, args);
    }

    public static void addWarningMessage(Message message) {
        addMessage(LEVEL_WARNING, message);
    }

    public static void addWarningMessage(String message, Object... args) {
        addMessage(LEVEL_WARNING, message, args);
    }

    public static void addWarningPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_WARNING, message.getMessage(), message.getArgs());
    }

    public static void addWarningPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_WARNING, key, args);
    }

    public static void addInfoMessage(Message message) {
        addMessage(LEVEL_INFO, message);
    }

    public static void addInfoMessage(String message, Object... args) {
        addMessage(LEVEL_INFO, message, args);
    }

    public static void addInfoPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_INFO, message.getMessage(), message.getArgs());
    }

    public static void addInfoPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_INFO, key, args);
    }

    public static void addLightMessage(Message message) {
        addMessage(LEVEL_LIGHT, message);
    }

    public static void addLightMessage(String message, Object... args) {
        addMessage(LEVEL_LIGHT, message, args);
    }

    public static void addLightPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_LIGHT, message.getMessage(), message.getArgs());
    }

    public static void addLightPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_LIGHT, key, args);
    }

    public static void addDarkMessage(Message message) {
        addMessage(LEVEL_DARK, message);
    }

    public static void addDarkMessage(String message, Object... args) {
        addMessage(LEVEL_DARK, message, args);
    }

    public static void addDarkPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_DARK, message.getMessage(), message.getArgs());
    }

    public static void addDarkPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_DARK, key, args);
    }

    public static void addMutedMessage(Message message) {
        addMessage(LEVEL_MUTED, message);
    }

    public static void addMutedMessage(String message, Object... args) {
        addMessage(LEVEL_MUTED, message, args);
    }

    public static void addMutedPropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_MUTED, message.getMessage(), message.getArgs());
    }

    public static void addMutedPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_MUTED, key, args);
    }

    public static void addWhiteMessage(Message message) {
        addMessage(LEVEL_WHITE, message);
    }

    public static void addWhiteMessage(String message, Object... args) {
        addMessage(LEVEL_WHITE, message, args);
    }

    public static void addWhitePropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_WHITE, message.getMessage(), message.getArgs());
    }

    public static void addWhitePropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_WHITE, key, args);
    }

    public static void addMessage(String level, Message message) {
        Objects.requireNonNull(message, MESSAGE_MUST_NOT_BE_NULL);
        addMessage(level, message.getMessage(), message.getArgs());
    }

    public static void addMessage(String level, String message, Object... args) {
        if (!MESSAGES.get().containsKey(level)) {
            MESSAGES.get().put(level, new ArrayList<>());
        }
        String messageFormatted = String.format(LOCALE.get(), message, args);
        MESSAGES.get().get(level).add(messageFormatted);
    }

    public static void addPropertyMessage(String level, Message message) {
        addPropertyMessage(level, message.getMessage(), message.getArgs());
    }

    public static void addPropertyMessage(String level, String key, Object... args) {

        String bundleName = "messages";

        if (!"".equals(BUNDLE_NAME.get().trim())) {
            bundleName = BUNDLE_NAME.get();
        }

        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, LOCALE.get());
        String message = bundle.getString(key);
        addMessage(level, message, args);

    }

    public static Map<String, List<String>> messages() {
        return MESSAGES.get();
    }

    public static void clear() {
        BUNDLE_NAME.remove();
        LOCALE.remove();
        MESSAGES.remove();
    }

}
