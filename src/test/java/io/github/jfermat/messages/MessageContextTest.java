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

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MessageContextTest {

    private static final String CATEGORY = "category";
    private static final String MESSAGE = "Message";
    private static final Object[] ARGS = new Object[]{"a", 2, new Date()};

    @Test
    public void addPrimaryMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addPrimaryMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_PRIMARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addPrimaryMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addPrimaryMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_PRIMARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

        context.addPrimaryMessage(CATEGORY, "other message");
        Assert.assertEquals(2, context.messages().get(entry.getKey()).size());

    }

    @Test
    public void addPrimaryMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addPrimaryMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_PRIMARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addPrimaryMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addPrimaryMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_PRIMARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSecondaryMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addSecondaryMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SECONDARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSecondaryMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addSecondaryMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SECONDARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSecondaryMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addSecondaryMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SECONDARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSecondaryMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addSecondaryMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SECONDARY, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSuccessMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addSuccessMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SUCCESS, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSuccessMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addSuccessMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SUCCESS, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSuccessMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addSuccessMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SUCCESS, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addSuccessMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addSuccessMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_SUCCESS, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDangerMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addDangerMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DANGER, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDangerMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addDangerMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DANGER, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDangerMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addDangerMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DANGER, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDangerMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addDangerMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DANGER, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWarningMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addWarningMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WARNING, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWarningMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addWarningMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WARNING, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWarningMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addWarningMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WARNING, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWarningMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addWarningMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WARNING, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addInfoMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addInfoMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_INFO, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addInfoMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addInfoMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_INFO, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addInfoMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addInfoMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_INFO, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addInfoMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addInfoMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_INFO, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addLightMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addLightMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_LIGHT, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addLightMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addLightMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_LIGHT, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addLightMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addLightMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_LIGHT, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addLightMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addLightMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_LIGHT, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDarkMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addDarkMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DARK, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDarkMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addDarkMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DARK, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDarkMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addDarkMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DARK, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addDarkMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addDarkMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_DARK, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addMutedMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addMutedMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_MUTED, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addMutedMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addMutedMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_MUTED, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addMutedMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addMutedMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_MUTED, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addMutedMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addMutedMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_MUTED, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWhiteMessageCategoryAndMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addWhiteMessage(CATEGORY, createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WHITE, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWhiteMessageCategoryAndStringTest() {

        MessageContext context = new MessageContext();
        context.addWhiteMessage(CATEGORY, MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertEquals(CATEGORY, entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WHITE, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWhiteMessageMessageInstanceTest() {

        MessageContext context = new MessageContext();
        context.addWhiteMessage(createMessage());

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WHITE, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    @Test
    public void addWhiteMessageStringTest() {

        MessageContext context = new MessageContext();
        context.addWhiteMessage(MESSAGE, ARGS);

        Map.Entry<MessageBox, List<Message>> entry = context.messages().entrySet().iterator().next();

        Assert.assertNull(entry.getKey().getCategory());
        Assert.assertEquals(MessagesUtils.SEVERITY_WHITE, entry.getKey().getSeverity());

        Message message = entry.getValue().get(0);
        Assert.assertEquals(MESSAGE, message.getMessage());
        Assert.assertArrayEquals(ARGS, message.getArgs());

    }

    private Message createMessage() {
        return new Message() {
            @Override
            public String getMessage() {
                return MESSAGE;
            }

            @Override
            public Object[] getArgs() {
                return ARGS;
            }
        };

    }
}
