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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Messages utils.
 */
public final class MessagesUtils {

    /**
     * Severity primary.
     */
    public static final String SEVERITY_PRIMARY = "primary";
    /**
     * Severity secondary.
     */
    public static final String SEVERITY_SECONDARY = "secondary";
    /**
     * Severity success.
     */
    public static final String SEVERITY_SUCCESS = "success";
    /**
     * Severity danger.
     */
    public static final String SEVERITY_DANGER = "danger";
    /**
     * Severity warning.
     */
    public static final String SEVERITY_WARNING = "warning";
    /**
     * Severity info.
     */
    public static final String SEVERITY_INFO = "info";
    /**
     * Severity light.
     */
    public static final String SEVERITY_LIGHT = "light";
    /**
     * Severity dark.
     */
    public static final String SEVERITY_DARK = "dark";
    /**
     * Severity muted.
     */
    public static final String SEVERITY_MUTED = "muted";
    /**
     * Severity white.
     */
    public static final String SEVERITY_WHITE = "white";

    private MessagesUtils() {
        throw new UnsupportedOperationException();
    }

    private static final ThreadLocal<ConcurrentHashMap<String, MessageContext>> CONTEXTS =
            ThreadLocal.withInitial(ConcurrentHashMap::new);

    /**
     * Default context message context.
     *
     * @return the message context
     */
    public static MessageContext defaultContext() {
        return context("default");
    }

    /**
     * Gets the context by name.
     *
     * @param context the context
     * @return the message context
     */
    public static MessageContext context(String context) {
        if (!CONTEXTS.get().containsKey(context)) {
            CONTEXTS.get().put(context, new MessageContext());
        }
        return CONTEXTS.get().get(context);
    }

    /**
     * Gets all messages from all contexts.
     *
     * @return the map
     */
    public static Map<String, MessageContext> messages() {
        return CONTEXTS.get();
    }

    /**
     * Clear all contexts.
     */
    public static void clear() {
        CONTEXTS.remove();
    }
}
