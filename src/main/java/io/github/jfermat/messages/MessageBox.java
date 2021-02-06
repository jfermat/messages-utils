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

import java.util.Objects;

/**
 * The type Message box.
 */
public final class MessageBox {

    private final String category;
    private final String severity;

    /**
     * Instantiates a new Message box.
     *
     * @param category the category
     * @param severity the severity
     */
    public MessageBox(String category, String severity) {
        this.category = category;
        this.severity = severity;
    }

    /**
     * Get category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get severity.
     *
     * @return the severity
     */
    public String getSeverity() {
        return severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageBox))  {
            return false;
        }
        MessageBox that = (MessageBox) o;
        return Objects.equals(category, that.category) &&
                Objects.equals(severity, that.severity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, severity);
    }

    @Override
    public String toString() {
        return "MessageBox{" +
                "category='" + category + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
