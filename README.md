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
  <version>2.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.github.jfermat:messages-utils:2.0.0"
```

##Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.github.jfermat.messages.Message;
import io.github.jfermat.messages.MessageBox;
import io.github.jfermat.messages.MessageContext;
import io.github.jfermat.messages.MessagesUtils;

import java.util.List;
import java.util.Map;

public class MessagesUtilsExample {

    public static void main(String[] args) {

        MessageContext context = MessagesUtils.defaultContext();

        context.addPrimaryMessage("This is a primary message uncategorized in the default context.");

        context.addSecondaryMessage("Messages", "This is a secondary severity message in the default context in the Messages category.");

        Map<MessageBox, List<Message>> messagesDefaultContext = context.messages();

        /* messagesDefaultContext value:
            MessageBox{category='Messages', severity='secondary'} = [
                Message{message='This is a secondary severity message in the default context in the Messages category.', args='{}'}
            ],
            MessageBox{category='null', severity='primary'} = [
                Message{message='This is a primary message uncategorized in the default context.', args='{}'}
            ]
         */

        MessageContext otherContext = MessagesUtils.context("other");

        otherContext.addInfoMessage(new Message() {
            @Override
            public String getMessage() {
                return "This is a info message uncategorized in the default context.";
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }
        });

        otherContext.addDangerMessage("Messages", new Message() {
            @Override
            public String getMessage() {
                return "This is a info message uncategorized in the default context.";
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }
        });

        Map<MessageBox, List<Message>> messagesOtherContext = context.messages();

        /* messagesOtherContext value:
            MessageBox{category='Messages', severity='secondary'} = [
                Message{message='This is a info message uncategorized in the default context.', args='{}'}
            ],
            MessageBox{category='null', severity='primary'} = [
                Message{message='This is a info message uncategorized in the default context.', args='{}'}
            ]
         */

        Map<String, MessageContext> allMessages = MessagesUtils.messages();
        /* allMessages value:
            "default" -> {
                MessageBox{category='Messages', severity='secondary'} = [
                    Message{message='This is a secondary severity message in the default context in the Messages category.', args='{}'}
                ],
                MessageBox{category='null', severity='primary'} = [
                    Message{message='This is a primary message uncategorized in the default context.', args='{}'}
                ]
            },
            "other" -> {
                MessageBox{category='Messages', severity='secondary'} = [
                    Message{message='This is a info message uncategorized in the default context.', args='{}'}
                ],
                MessageBox{category='null', severity='primary'} = [
                    Message{message='This is a info message uncategorized in the default context.', args='{}'}
                ]
            }
         */

    }
}
```

##Documentation

Javadoc: https://jfermat.github.io/docs/messages-utils