/*
 * Copyright (c)2021. Jordi Ferré Matamoros. All rights reserved.
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Context to store different messages by category and severity.
 */
public final class MessageContext {

    private final Map<MessageBox, List<Message>> messagesBoxed = new HashMap<>();

    /**
     * Instantiates a new Message context.
     */
    public MessageContext() {
        super();
    }

    /**
     * Add primary  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addPrimaryMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_PRIMARY, message);
    }

    /**
     * Add primary  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addPrimaryMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_PRIMARY, message, args);
    }

    /**
     * Add primary  severity message.
     *
     * @param message the message
     */
    public void addPrimaryMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_PRIMARY, message);
    }

    /**
     * Add primary  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addPrimaryMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_PRIMARY, message, args);
    }

    /**
     * Add secondary  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addSecondaryMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_SECONDARY, message);
    }

    /**
     * Add secondary  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addSecondaryMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_SECONDARY, message, args);
    }

    /**
     * Add secondary  severity message.
     *
     * @param message the message
     */
    public void addSecondaryMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_SECONDARY, message);
    }

    /**
     * Add secondary  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addSecondaryMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_SECONDARY, message, args);
    }

    /**
     * Add success  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addSuccessMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_SUCCESS, message);
    }

    /**
     * Add success  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addSuccessMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_SUCCESS, message, args);
    }

    /**
     * Add success  severity message.
     *
     * @param message the message
     */
    public void addSuccessMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_SUCCESS, message);
    }

    /**
     * Add success  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addSuccessMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_SUCCESS, message, args);
    }

    /**
     * Add danger  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addDangerMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_DANGER, message);
    }

    /**
     * Add danger  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addDangerMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_DANGER, message, args);
    }

    /**
     * Add danger  severity message.
     *
     * @param message the message
     */
    public void addDangerMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_DANGER, message);
    }

    /**
     * Add danger  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addDangerMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_DANGER, message, args);
    }

    /**
     * Add warning  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addWarningMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_WARNING, message);
    }

    /**
     * Add warning  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addWarningMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_WARNING, message, args);
    }

    /**
     * Add warning  severity message.
     *
     * @param message the message
     */
    public void addWarningMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_WARNING, message);
    }

    /**
     * Add warning  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addWarningMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_WARNING, message, args);
    }

    /**
     * Add info  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addInfoMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_INFO, message);
    }

    /**
     * Add info  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addInfoMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_INFO, message, args);
    }

    /**
     * Add info  severity message.
     *
     * @param message the message
     */
    public void addInfoMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_INFO, message);
    }

    /**
     * Add info  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addInfoMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_INFO, message, args);
    }

    /**
     * Add light  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addLightMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_LIGHT, message);
    }

    /**
     * Add light  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addLightMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_LIGHT, message, args);
    }

    /**
     * Add light  severity message.
     *
     * @param message the message
     */
    public void addLightMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_LIGHT, message);
    }

    /**
     * Add light  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addLightMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_LIGHT, message, args);
    }

    /**
     * Add dark  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addDarkMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_DARK, message);
    }

    /**
     * Add dark  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addDarkMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_DARK, message, args);
    }

    /**
     * Add dark  severity message.
     *
     * @param message the message
     */
    public void addDarkMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_DARK, message);
    }

    /**
     * Add dark  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addDarkMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_DARK, message, args);
    }

    /**
     * Add muted  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addMutedMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_MUTED, message);
    }

    /**
     * Add muted  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addMutedMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_MUTED, message, args);
    }

    /**
     * Add muted  severity message.
     *
     * @param message the message
     */
    public void addMutedMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_MUTED, message);
    }

    /**
     * Add muted  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addMutedMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_MUTED, message, args);
    }

    /**
     * Add white  severity message.
     *
     * @param category the category
     * @param message  the message
     */
    public void addWhiteMessage(String category, Message message) {
        addMessage(category, MessagesUtils.SEVERITY_WHITE, message);
    }

    /**
     * Add white  severity message.
     *
     * @param category the category
     * @param message  the message
     * @param args     the args
     */
    public void addWhiteMessage(String category, String message, Object... args) {
        addMessage(category, MessagesUtils.SEVERITY_WHITE, message, args);
    }

    /**
     * Add white  severity message.
     *
     * @param message the message
     */
    public void addWhiteMessage(Message message) {
        addMessage(MessagesUtils.SEVERITY_WHITE, message);
    }

    /**
     * Add white  severity message.
     *
     * @param message the message
     * @param args    the args
     */
    public void addWhiteMessage(String message, Object... args) {
        addMessage(MessagesUtils.SEVERITY_WHITE, message, args);
    }

    /**
     * Add message.
     *
     * @param category the category
     * @param severity the severity
     * @param message  the message
     */
    public void addMessage(String category, String severity, Message message) {
        MessageBox messageBox = new MessageBox(category, severity);
        messagesBoxed.computeIfAbsent(messageBox, k -> new ArrayList<>()).add(message);
    }

    /**
     * Add message.
     *
     * @param category the category
     * @param severity the severity
     * @param message  the message
     * @param args     the args
     */
    public void addMessage(String category, String severity, String message, Object... args) {
        addMessage(category, severity, new Message() {
            @Override
            public String getMessage() {
                return message;
            }
            @Override
            public Object[] getArgs() {
                return args;
            }
        });
    }

    /**
     * Add message.
     *
     * @param severity the severity
     * @param message  the message
     */
    public void addMessage(String severity, Message message) {
        addMessage(null, severity, message);
    }

    /**
     * Add message.
     *
     * @param severity the severity
     * @param message  the message
     * @param args     the args
     */
    public void addMessage(String severity, String message, Object... args) {
        addMessage(null, severity, message, args);
    }

    /**
     * Messages map.
     *
     * @return the map
     */
    public Map<MessageBox, List<Message>> messages() {
        return messagesBoxed;
    }
}
