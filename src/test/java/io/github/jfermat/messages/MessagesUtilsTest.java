package io.github.jfermat.messages;

import io.github.jfermat.messages.model.ClassMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MessagesUtilsTest {

    private static final String THIS_IS_MESSAGE = "This is a %s message.";
    private static final String BUNDLE_KEY = "message.key";

    @Test
    public void addPrimary() {
        MessagesUtils.clear();
        String level = "primary";
        MessagesUtils.addPrimary(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addSecondary() {
        MessagesUtils.clear();
        String level = "secondary";
        MessagesUtils.addSecondary(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addSuccess() {
        MessagesUtils.clear();
        String level = "success";
        MessagesUtils.addSuccess(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addDanger() {
        MessagesUtils.clear();
        String level = "danger";
        MessagesUtils.addDanger(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addWarning() {
        MessagesUtils.clear();
        String level = "warning";
        MessagesUtils.addWarning(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addInfo() {
        MessagesUtils.clear();
        String level = "info";
        MessagesUtils.addInfo(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addLight() {
        MessagesUtils.clear();
        String level = "light";
        MessagesUtils.addLight(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addDark() {
        MessagesUtils.clear();
        String level = "dark";
        MessagesUtils.addDark(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addMuted() {
        MessagesUtils.clear();
        String level = "muted";
        MessagesUtils.addMuted(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addWhite() {
        MessagesUtils.clear();
        String level = "white";
        MessagesUtils.addWhite(new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addCustom() {
        MessagesUtils.clear();
        String level = "custom";
        MessagesUtils.add(level, new ClassMessage(THIS_IS_MESSAGE, level));
        assertMessage(level);
    }

    @Test
    public void addTwoCustom() {
        MessagesUtils.clear();
        String level = "custom";
        MessagesUtils.add(level, new ClassMessage(THIS_IS_MESSAGE, level));
        MessagesUtils.add(level, new ClassMessage("Other message"));
        Map<String, List<String>> messages = MessagesUtils.messagesFormated();
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertEquals(2, messages.get(level).size());
    }

    @Test
    public void bundleDefault() {
        MessagesUtils.clear();
        String level = "bundle";
        MessagesUtils.add(level, new ClassMessage(BUNDLE_KEY, level));
        Map<String, List<String>> messages = MessagesUtils.messagesBundle();
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals(String.format(THIS_IS_MESSAGE, level), messages.get(level).get(0));
    }

    @Test
    public void bundleDefaultSpanish() {
        MessagesUtils.clear();
        String level = "bundleSpanish";
        MessagesUtils.add(level, new ClassMessage(BUNDLE_KEY, level));
        Map<String, List<String>> messages = MessagesUtils.messagesBundle(Locale.forLanguageTag("es"));
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals("Este es un mensaje bundleSpanish.", messages.get(level).get(0));
    }

    @Test
    public void otherBundleDefault() {
        MessagesUtils.clear();
        String level = "otherBundle";
        MessagesUtils.add(level, new ClassMessage(BUNDLE_KEY, level));
        Map<String, List<String>> messages = MessagesUtils.messagesBundle("i18n/other");
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals("This is other otherBundle message.", messages.get(level).get(0));
    }

    @Test
    public void otherBundleDefaultSpanish() {
        MessagesUtils.clear();
        String level = "otherBundleSpanish";
        MessagesUtils.add(level, new ClassMessage(BUNDLE_KEY, level));
        Map<String, List<String>> messages = MessagesUtils.messagesBundle("i18n/other", Locale.forLanguageTag("es"));
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals("Este es otro mensaje otherBundleSpanish.", messages.get(level).get(0));
    }

    @Test
    public void messageLocale() {
        MessagesUtils.clear();
        String level = "messageLocale";
        MessagesUtils.add(level, new ClassMessage(THIS_IS_MESSAGE, level));
        Map<String, List<String>> messages = MessagesUtils.messagesFormated(Locale.ENGLISH);
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals(String.format(THIS_IS_MESSAGE, level), messages.get(level).get(0));
    }

    @Test
    public void messages() {
        MessagesUtils.clear();
        String level = "messageLocale";
        MessagesUtils.add(level, new ClassMessage(THIS_IS_MESSAGE, level));
        Map<String, List<Message>> messages = MessagesUtils.messages();
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals(THIS_IS_MESSAGE, messages.get(level).get(0).getMessage());
        assertArrayEquals(new Object[]{level}, messages.get(level).get(0).getArgs());
    }

    private void assertMessage(String level) {
        Map<String, List<String>> messages = MessagesUtils.messagesFormated();
        assertFalse(messages.isEmpty());
        assertEquals(1, messages.size());
        assertTrue(messages.containsKey(level));
        assertEquals(String.format(THIS_IS_MESSAGE, level), messages.get(level).get(0));
    }

}
