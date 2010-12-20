/*
 * Created on Dec 20, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.api;

import static junit.framework.Assert.assertSame;
import static org.fest.assertions.test.Arrays.arrayOfChars;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.CharArrays;
import org.junit.*;

/**
 * Tests for <code>{@link CharArrayAssert#containsOnly(char...)}</code>.
 *
 * @author Alex Ruiz
 */
public class CharArrayAssert_containsOnly_Test {

  private CharArrays arrays;
  private CharArrayAssert assertions;

  @Before public void setUp() {
    arrays = mock(CharArrays.class);
    assertions = new CharArrayAssert(new char[0]);
    assertions.arrays = arrays;
  }

  @Test public void should_verify_that_actual_contains_given_values_only() {
    assertions.containsOnly('a', 'b');
    verify(arrays).assertContainsOnly(assertions.info, assertions.actual, arrayOfChars('a', 'b'));
  }

  @Test public void should_return_this() {
    CharArrayAssert returned = assertions.containsOnly('a');
    assertSame(assertions, returned);
  }
}
