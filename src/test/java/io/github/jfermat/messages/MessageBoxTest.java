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

import java.lang.reflect.Constructor;

import static org.junit.Assert.fail;

public class MessageBoxTest {

    @Test(expected= NoSuchMethodException.class)
    public void messageBoxDefaultConstructorTest() throws Exception {
        Constructor<MessageBox> c = MessageBox.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
        fail("MessagesUtils class constructor should be private");
    }

    @Test
    public void messageBoxConstructorTest() {
        MessageBox messageBox = new MessageBox("category", "severity");
        Assert.assertEquals("category", messageBox.getCategory());
        Assert.assertEquals("severity", messageBox.getSeverity());
    }

    @Test
    public void equalsTest() {

        MessageBox messageBoxOne = new MessageBox("category", "severity");
        MessageBox messageBoxTwo = new MessageBox("category", "severity");

        Assert.assertEquals(messageBoxOne, messageBoxOne);
        Assert.assertEquals(messageBoxOne, messageBoxTwo);
        Assert.assertNotEquals(messageBoxOne, null);
        Assert.assertNotEquals(messageBoxOne, "false");
    }

    @Test
    public void hashCodeTest() {
        MessageBox messageBoxOne = new MessageBox("category", "severity");
        MessageBox messageBoxTwo = new MessageBox("category", "severity");
        MessageBox messageBoxThree = new MessageBox("category3", "severity");
        MessageBox messageBoxFour = new MessageBox("category", "severity4");

        Assert.assertEquals(messageBoxOne.hashCode(), messageBoxTwo.hashCode());
        Assert.assertNotEquals(messageBoxOne.hashCode(), messageBoxThree.hashCode());
        Assert.assertNotEquals(messageBoxOne.hashCode(), messageBoxFour.hashCode());
    }

}
