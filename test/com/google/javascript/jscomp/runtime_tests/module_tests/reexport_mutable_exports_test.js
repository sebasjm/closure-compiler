/*
 * Copyright 2016 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import * as Mutable from './module_test_resources/mutable_exports.js';
import * as Reexported from './module_test_resources/reexport_mutable_exports.js';

goog.require('goog.testing.asserts');

function testMutableExportS() {
  assertEquals(Mutable.a, Reexported.A);
  assertEquals(Mutable.b, Reexported.B);
  assertEquals(Mutable.c, Reexported.C);

  Mutable.set(1, 2, 3);

  assertEquals(Mutable.a, Reexported.A);
  assertEquals(Mutable.b, Reexported.B);
  assertEquals(Mutable.c, Reexported.C);

  Reexported.set(4, 5, 6);

  assertEquals(Mutable.a, Reexported.A);
  assertEquals(Mutable.b, Reexported.B);
  assertEquals(Mutable.c, Reexported.C);
}
