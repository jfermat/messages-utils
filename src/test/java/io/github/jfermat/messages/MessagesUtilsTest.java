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
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.fail;

public class MessagesUtilsTest {

    @Test(expected= InvocationTargetException.class)
    public void newInstance() throws Exception {
        Constructor<MessagesUtils> c = MessagesUtils.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
        fail("MessagesUtils class constructor should be private");
    }

    @Test
    public void getDefault() {
        Assert.assertFalse(MessagesUtils.messages().containsKey("default"));
        MessagesUtils.defaultContext();
        Assert.assertTrue(MessagesUtils.messages().containsKey("default"));
    }

    @Test
    public void getContext() {
        Assert.assertFalse(MessagesUtils.messages().containsKey("context"));
        MessagesUtils.context("context");
        Assert.assertTrue(MessagesUtils.messages().containsKey("context"));
    }

    @Test
    public void clearTest() {
        MessagesUtils.defaultContext();
        MessagesUtils.context("context");
        Assert.assertFalse(MessagesUtils.messages().isEmpty());
        MessagesUtils.clear();
        Assert.assertTrue(MessagesUtils.messages().isEmpty());
    }

}
