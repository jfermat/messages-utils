/*
 * Copyright (c)2021. Jordi Ferré Matamaoros. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.jfermat.messages;

import java.util.*;

/**
 * The type Messages utils.
 */
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

    private static final String MESSAGE_MUST_NOT_BE_NULL = "message must not be null";

    private MessagesUtils() {
        throw new UnsupportedOperationException();
    }

    private static final ThreadLocal<String> BUNDLE_NAME = ThreadLocal.withInitial(String::new);
    private static final ThreadLocal<Locale> LOCALE = ThreadLocal.withInitial(Locale::getDefault);
    private static final ThreadLocal<Map<String, List<String>>> MESSAGES =
            ThreadLocal.withInitial(HashMap::new);

    /**
     * With bundle.
     *
     * @param bundleName the bundle name
     */
    public static void withBundle(String bundleName) {
        BUNDLE_NAME.set(bundleName);
    }

    /**
     * With locale.
     *
     * @param locale the locale
     */
    public static void withLocale(Locale locale) {
        LOCALE.set(locale);
    }

    /**
     * Add primary message.
     *
     * @param message the message
     */
    public static void addPrimaryMessage(Message message) {
        addMessage(LEVEL_PRIMARY, message);
    }

    /**
     * Add primary message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addPrimaryMessage(String message, Object... args) {
        addMessage(LEVEL_PRIMARY, message, args);
    }

    /**
     * Add primary property message.
     *
     * @param message the message
     */
    public static void addPrimaryPropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_PRIMARY, message.getMessage(), message.getArgs());
    }

    /**
     * Add primary property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addPrimaryPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_PRIMARY, key, args);
    }

    /**
     * Add secondary message.
     *
     * @param message the message
     */
    public static void addSecondaryMessage(Message message) {
        addMessage(LEVEL_SECONDARY, message);
    }

    /**
     * Add secondary message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addSecondaryMessage(String message, Object... args) {
        addMessage(LEVEL_SECONDARY, message, args);
    }

    /**
     * Add secondary property message.
     *
     * @param message the message
     */
    public static void addSecondaryPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_SECONDARY, message.getMessage(), message.getArgs());
    }

    /**
     * Add secondary property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addSecondaryPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_SECONDARY, key, args);
    }

    /**
     * Add success message.
     *
     * @param message the message
     */
    public static void addSuccessMessage(Message message) {
        addMessage(LEVEL_SUCCESS, message);
    }

    /**
     * Add success message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addSuccessMessage(String message, Object... args) {
        addMessage(LEVEL_SUCCESS, message, args);
    }

    /**
     * Add success property message.
     *
     * @param message the message
     */
    public static void addSuccessPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_SUCCESS, message.getMessage(), message.getArgs());
    }

    /**
     * Add success property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addSuccessPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_SUCCESS, key, args);
    }

    /**
     * Add danger message.
     *
     * @param message the message
     */
    public static void addDangerMessage(Message message) {
        addMessage(LEVEL_DANGER, message);
    }

    /**
     * Add danger message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addDangerMessage(String message, Object... args) {
        addMessage(LEVEL_DANGER, message, args);
    }

    /**
     * Add danger property message.
     *
     * @param message the message
     */
    public static void addDangerPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_DANGER, message.getMessage(), message.getArgs());
    }

    /**
     * Add danger property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addDangerPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_DANGER, key, args);
    }

    /**
     * Add warning message.
     *
     * @param message the message
     */
    public static void addWarningMessage(Message message) {
        addMessage(LEVEL_WARNING, message);
    }

    /**
     * Add warning message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addWarningMessage(String message, Object... args) {
        addMessage(LEVEL_WARNING, message, args);
    }

    /**
     * Add warning property message.
     *
     * @param message the message
     */
    public static void addWarningPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_WARNING, message.getMessage(), message.getArgs());
    }

    /**
     * Add warning property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addWarningPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_WARNING, key, args);
    }

    /**
     * Add info message.
     *
     * @param message the message
     */
    public static void addInfoMessage(Message message) {
        addMessage(LEVEL_INFO, message);
    }

    /**
     * Add info message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addInfoMessage(String message, Object... args) {
        addMessage(LEVEL_INFO, message, args);
    }

    /**
     * Add info property message.
     *
     * @param message the message
     */
    public static void addInfoPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_INFO, message.getMessage(), message.getArgs());
    }

    /**
     * Add info property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addInfoPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_INFO, key, args);
    }

    /**
     * Add light message.
     *
     * @param message the message
     */
    public static void addLightMessage(Message message) {
        addMessage(LEVEL_LIGHT, message);
    }

    /**
     * Add light message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addLightMessage(String message, Object... args) {
        addMessage(LEVEL_LIGHT, message, args);
    }

    /**
     * Add light property message.
     *
     * @param message the message
     */
    public static void addLightPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_LIGHT, message.getMessage(), message.getArgs());
    }

    /**
     * Add light property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addLightPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_LIGHT, key, args);
    }

    /**
     * Add dark message.
     *
     * @param message the message
     */
    public static void addDarkMessage(Message message) {
        addMessage(LEVEL_DARK, message);
    }

    /**
     * Add dark message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addDarkMessage(String message, Object... args) {
        addMessage(LEVEL_DARK, message, args);
    }

    /**
     * Add dark property message.
     *
     * @param message the message
     */
    public static void addDarkPropertyMessage(Message message) {
        addPropertyMessage(LEVEL_DARK, message.getMessage(), message.getArgs());
    }

    /**
     * Add dark property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addDarkPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_DARK, key, args);
    }

    /**
     * Add muted message.
     *
     * @param message the message
     */
    public static void addMutedMessage(Message message) {
        addMessage(LEVEL_MUTED, message);
    }

    /**
     * Add muted message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addMutedMessage(String message, Object... args) {
        addMessage(LEVEL_MUTED, message, args);
    }

    /**
     * Add muted property message.
     *
     * @param message the message
     */
    public static void addMutedPropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_MUTED, message.getMessage(), message.getArgs());
    }

    /**
     * Add muted property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addMutedPropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_MUTED, key, args);
    }

    /**
     * Add white message.
     *
     * @param message the message
     */
    public static void addWhiteMessage(Message message) {
        addMessage(LEVEL_WHITE, message);
    }

    /**
     * Add white message.
     *
     * @param message the message
     * @param args    the args
     */
    public static void addWhiteMessage(String message, Object... args) {
        addMessage(LEVEL_WHITE, message, args);
    }

    /**
     * Add white property message.
     *
     * @param message the message
     */
    public static void addWhitePropertyMessage(Message message)  {
        addPropertyMessage(LEVEL_WHITE, message.getMessage(), message.getArgs());
    }

    /**
     * Add white property message.
     *
     * @param key  the key
     * @param args the args
     */
    public static void addWhitePropertyMessage(String key, Object... args) {
        addPropertyMessage(LEVEL_WHITE, key, args);
    }

    /**
     * Add message.
     *
     * @param level   the level
     * @param message the message
     */
    public static void addMessage(String level, Message message) {
        Objects.requireNonNull(message, MESSAGE_MUST_NOT_BE_NULL);
        addMessage(level, message.getMessage(), message.getArgs());
    }

    /**
     * Add message.
     *
     * @param level   the level
     * @param message the message
     * @param args    the args
     */
    public static void addMessage(String level, String message, Object... args) {
        if (!MESSAGES.get().containsKey(level)) {
            MESSAGES.get().put(level, new ArrayList<>());
        }
        String messageFormatted = String.format(LOCALE.get(), message, args);
        MESSAGES.get().get(level).add(messageFormatted);
    }

    /**
     * Add property message.
     *
     * @param level   the level
     * @param message the message
     */
    public static void addPropertyMessage(String level, Message message) {
        addPropertyMessage(level, message.getMessage(), message.getArgs());
    }

    /**
     * Add property message.
     *
     * @param level the level
     * @param key   the key
     * @param args  the args
     */
    public static void addPropertyMessage(String level, String key, Object... args) {

        String bundleName = "messages";

        if (!"".equals(BUNDLE_NAME.get().trim())) {
            bundleName = BUNDLE_NAME.get();
        }

        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, LOCALE.get());
        String message = bundle.getString(key);
        addMessage(level, message, args);

    }

    /**
     * Messages map.
     *
     * @return the map
     */
    public static Map<String, List<String>> messages() {
        return MESSAGES.get();
    }

    /**
     * Clear.
     */
    public static void clear() {
        BUNDLE_NAME.remove();
        LOCALE.remove();
        MESSAGES.remove();
    }

}
