package io.github.jfermat.messages;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MessagesUtilsTest {

    private static final Locale LOCALE_ENGLISH = Locale.forLanguageTag("en");
    private static final Locale LOCALE_SPANISH = Locale.forLanguageTag("es");

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

    public static final String FIRST = "first";
    public static final String SECOND = "second";

    public static final String SIMPLE_MESSAGE = "Simple message.";
    public static final String FORMATTED_MESSAGE = "Formatted %s message.";
    public static final String FROM_CLASS_MESSAGE_LEVEL = "From class Message. Level %s.";
    public static final String THIS_IS_FIRST_MESSAGE_FROM_LEVEL = "This is first message from level %s.";
    public static final String THIS_IS_A_SECOND_MESSAGE_FROM_LEVEL = "This is a second message from level %s.";

    @Test(expected= InvocationTargetException.class)
    public void newInstance() throws Exception {
        Constructor<MessagesUtils> c = MessagesUtils.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
        fail("MessagesUtils class constructor should be private");
    }

    @Test
    public void primaryTest() {

        String level = LEVEL_PRIMARY;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addPrimaryMessage(SIMPLE_MESSAGE);
        MessagesUtils.addPrimaryMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addPrimaryMessage(getCommonMessage(level));
        MessagesUtils.addPrimaryPropertyMessage(FIRST, level);
        MessagesUtils.addPrimaryPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);

    }

    @Test
    public void secondaryTest() {

        String level = LEVEL_SECONDARY;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addSecondaryMessage(SIMPLE_MESSAGE);
        MessagesUtils.addSecondaryMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addSecondaryMessage(getCommonMessage(level));
        MessagesUtils.addSecondaryPropertyMessage(FIRST, level);
        MessagesUtils.addSecondaryPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void successTest() {

        String level = LEVEL_SUCCESS;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addSuccessMessage(SIMPLE_MESSAGE);
        MessagesUtils.addSuccessMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addSuccessMessage(getCommonMessage(level));
        MessagesUtils.addSuccessPropertyMessage(FIRST, level);
        MessagesUtils.addSuccessPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);

    }

    @Test
    public void dangerTest() {

        String level = LEVEL_DANGER;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addDangerMessage(SIMPLE_MESSAGE);
        MessagesUtils.addDangerMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addDangerMessage(getCommonMessage(level));
        MessagesUtils.addDangerPropertyMessage(FIRST, level);
        MessagesUtils.addDangerPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void warningTest() {

        String level = LEVEL_WARNING;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addWarningMessage(SIMPLE_MESSAGE);
        MessagesUtils.addWarningMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addWarningMessage(getCommonMessage(level));
        MessagesUtils.addWarningPropertyMessage(FIRST, level);
        MessagesUtils.addWarningPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void infoTest() {

        String level = LEVEL_INFO;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addInfoMessage(SIMPLE_MESSAGE);
        MessagesUtils.addInfoMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addInfoMessage(getCommonMessage(level));
        MessagesUtils.addInfoPropertyMessage(FIRST, level);
        MessagesUtils.addInfoPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void lightTest() {

        String level = LEVEL_LIGHT;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addLightMessage(SIMPLE_MESSAGE);
        MessagesUtils.addLightMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addLightMessage(getCommonMessage(level));
        MessagesUtils.addLightPropertyMessage(FIRST, level);
        MessagesUtils.addLightPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void darkTest() {

        String level = LEVEL_DARK;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addDarkMessage(SIMPLE_MESSAGE);
        MessagesUtils.addDarkMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addDarkMessage(getCommonMessage(level));
        MessagesUtils.addDarkPropertyMessage(FIRST, level);
        MessagesUtils.addDarkPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void mutedTest() {

        String level = LEVEL_MUTED;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addMutedMessage(SIMPLE_MESSAGE);
        MessagesUtils.addMutedMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addMutedMessage(getCommonMessage(level));
        MessagesUtils.addMutedPropertyMessage(FIRST, level);
        MessagesUtils.addMutedPropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void whiteTest() {

        String level = LEVEL_WHITE;

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addWhiteMessage(SIMPLE_MESSAGE);
        MessagesUtils.addWhiteMessage(FORMATTED_MESSAGE, level);
        MessagesUtils.addWhiteMessage(getCommonMessage(level));
        MessagesUtils.addWhitePropertyMessage(FIRST, level);
        MessagesUtils.addWhitePropertyMessage(getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test
    public void customTest() {

        String level = "custom";

        // Clear previous test
        MessagesUtils.clear();

        // Set locale
        MessagesUtils.withLocale(LOCALE_ENGLISH);

        // Add messages
        MessagesUtils.addMessage(level, SIMPLE_MESSAGE);
        MessagesUtils.addMessage(level, FORMATTED_MESSAGE, level);
        MessagesUtils.addMessage(level, getCommonMessage(level));
        MessagesUtils.addPropertyMessage(level, FIRST, level);
        MessagesUtils.addPropertyMessage(level, getCommonPropertyMessage(level));

        assertMessagesLevels(level);
    }

    @Test(expected = MissingResourceException.class)
    public void bundleNotFoundTest() {
        MessagesUtils.clear();
        MessagesUtils.withBundle("notFound");
        MessagesUtils.withLocale(LOCALE_SPANISH);
        MessagesUtils.addPropertyMessage("notFound", "notFound");
    }

    @Test
    public void otherBundle() {
        MessagesUtils.clear();
        MessagesUtils.withLocale(LOCALE_SPANISH);
        MessagesUtils.withBundle("i18n/other");
        MessagesUtils.addPropertyMessage("other, ","message.key", "más");

        Map<String, List<String>> messages = MessagesUtils.messages();
        assertEquals("Este es otro mensaje más.", messages.values().iterator().next().get(0));

    }

    private Message getCommonMessage(String level) {
        return new Message() {
            @Override
            public String getMessage() {
                return FROM_CLASS_MESSAGE_LEVEL;
            }

            @Override
            public Object[] getArgs() {
                return new Object[] { level };
            }
        };
    }

    private Message getCommonPropertyMessage(String level) {
        return new Message() {
            @Override
            public String getMessage() {
                return SECOND;
            }

            @Override
            public Object[] getArgs() {
                return new Object[] { level };
            }
        };
    }

    private void assertMessagesLevels(String level) {
        // Get added messages
        Map<String, List<String>> messages = MessagesUtils.messages();

        // Checks
        assertFalse("Messages found.", messages.isEmpty());
        assertEquals("One level of messages.", 1, messages.size());
        assertEquals("Expected messages.", 5, messages.get(level).size());
        assertThat(messages.get(level), is(messagesExpected(level)));
    }

    private List<String> messagesExpected(String level) {
        List<String> messagesExpected = new ArrayList<>();
        messagesExpected.add(SIMPLE_MESSAGE);
        messagesExpected.add(String.format(FORMATTED_MESSAGE, level));
        messagesExpected.add(String.format(FROM_CLASS_MESSAGE_LEVEL, level));
        messagesExpected.add(String.format(THIS_IS_FIRST_MESSAGE_FROM_LEVEL, level));
        messagesExpected.add(String.format(THIS_IS_A_SECOND_MESSAGE_FROM_LEVEL, level));
        return messagesExpected;
    }

}
