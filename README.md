# Messages Utils

![Build](https://github.com/jfermat/messages-utils/workflows/Build/badge.svg) ![Publishing artifacts](https://github.com/jfermat/messages-utils/workflows/Publishing%20artifacts/badge.svg) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jfermat_messages-utils&metric=alert_status)](https://sonarcloud.io/dashboard?id=jfermat_messages-utils) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=jfermat_messages-utils&metric=coverage)](https://sonarcloud.io/dashboard?id=jfermat_messages-utils) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=jfermat_messages-utils&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=jfermat_messages-utils)

## Requirements

Building the API client library requires:
1. Java 11+
2. Maven/Gradle

## Installation

To install the Messages Utils library to your local Maven repository, simply execute:

```shell
mvn clean install
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.github.jfermat</groupId>
  <artifactId>messages-utils</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.github.jfermat:messages-utils:1.0.0"
```

##Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.github.jfermat.messages.Message;
import io.github.jfermat.messages.MessagesUtils;

import java.util.Locale;

public class MessagesUtilsExample {

    /*
        i18n/messages_en.properties content:
        message.simple = This is a simple property message.
        message.simple.formated = This is a simple property message.
        message.class = This is a class message.
     */
    public static void main(String... args) {

        // Sets the bundle that will be used to do the translation when a property is passed to it.
        // The default bundle is 'messages'.
        MessagesUtils.withBundle("i18n/messages");

        // Set the language to be used for translation when a property is passed to you.
        // The default locale is the system locale.
        MessagesUtils.withLocale(Locale.ENGLISH);

        // Add a simple information message.
        MessagesUtils.addInfoMessage("Add a simple information message.");
        // Information message added: Add a simple information message.

        // Add a simple information message formated.
        MessagesUtils.addInfoMessage("This is %s message formated.", "information");
        // Information message added: This is information message formated.

        // Add a simple information message formated.
        MessagesUtils.addInfoPropertyMessage("message.simple");
        // Information message added: This is a simple property message.

        // Add property message from interface io.github.jfermat.messages.Message
        MessagesUtils.addInfoMessage(new Message() {
            @Override
            public String getMessage() {
                return "Error %s.";
            }

            @Override
            public Object[] getArgs() {
                return new Object[]{"404"};
            }
        });
        // Information message added: Error 404.

        // Add property message from interface io.github.jfermat.messages.Message
        MessagesUtils.addWarningPropertyMessage(new Message() {
            @Override
            public String getMessage() {
                return "message.class";
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }
        });
        // Information message added: This is a class message.

        // Gets all the added messages listed by level.
        MessagesUtils.messages();
        // Return:
        // ** Level: info **
        // - Add a simple information message.
        // - This is information message formated.
        // - This is a simple property message.
        // - Error 404.
        // ** Level: warning **
        // - This is a class message.
    }
}
```