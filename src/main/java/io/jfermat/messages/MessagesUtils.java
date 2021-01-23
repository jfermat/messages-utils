package io.jfermat.messages;

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
    public static final String DEFAULT_MESSAGE_BUNDLE = "messages";

    private MessagesUtils() {
        super();
    }

    private static final ThreadLocal<Map<String, List<Message>>> MESSAGES =
            ThreadLocal.withInitial(HashMap::new);

    public static void addPrimary(Message message) {
        add(LEVEL_PRIMARY, message);
    }

    public static void addSecondary(Message message) {
        add(LEVEL_SECONDARY, message);
    }

    public static void addSuccess(Message message) {
        add(LEVEL_SUCCESS, message);
    }

    public static void addDanger(Message message) {
        add(LEVEL_DANGER, message);
    }

    public static void addWarning(Message message) {
        add(LEVEL_WARNING, message);
    }

    public static void addInfo(Message message) {
        add(LEVEL_INFO, message);
    }

    public static void addLight(Message message) {
        add(LEVEL_LIGHT, message);
    }

    public static void addDark(Message message) {
        add(LEVEL_DARK, message);
    }

    public static void addMuted(Message message) {
        add(LEVEL_MUTED, message);
    }

    public static void addWhite(Message message) {
        add(LEVEL_WHITE, message);
    }

    public static void add(String level, Message message) {
        if (!MESSAGES.get().containsKey(level)) {
            MESSAGES.get().put(level, new ArrayList<>());
        }
        MESSAGES.get().get(level).add(message);
    }

    public static Map<String, List<Message>> messages() {
        return MESSAGES.get();
    }

    public static Map<String, List<String>> messagesFormated() {
        return messagesFormat(null, Locale.getDefault());
    }

    public static Map<String, List<String>> messagesFormated(Locale locale) {
        return messagesFormat(null, locale);
    }


    public static Map<String, List<String>> messagesBundle() {
        return messagesBundle(DEFAULT_MESSAGE_BUNDLE, Locale.getDefault());
    }

    public static Map<String, List<String>> messagesBundle(Locale locale) {
        return messagesBundle(DEFAULT_MESSAGE_BUNDLE, locale);
    }

    public static Map<String, List<String>> messagesBundle(String bundle) {
        return messagesBundle(bundle, Locale.getDefault());
    }

    public static Map<String, List<String>> messagesBundle(String bundle, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, locale);
        return messagesFormat(resourceBundle, locale);
    }

    private static Map<String, List<String>> messagesFormat(ResourceBundle bundle, Locale locale) {
        Map<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, List<Message>> entry : MESSAGES.get().entrySet()) {

            List<String> messagesLevel = new ArrayList<>();

            for (Message message : entry.getValue()) {
                String text = message.getMessage();
                if (bundle != null) {
                    text = bundle.getString(message.getMessage());
                }
                messagesLevel.add(String.format(locale, text, message.getArgs()));
            }

            result.put(entry.getKey(), messagesLevel);
        }

        return result;
    }

    public static void clear() {
        MESSAGES.get().clear();
    }

    public void unload() {
        MESSAGES.remove();
    }

}
