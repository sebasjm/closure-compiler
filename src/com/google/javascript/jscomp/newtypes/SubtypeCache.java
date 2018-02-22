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

package com.google.javascript.jscomp.newtypes;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Used to cut-off recursion when checking structural interfaces for subtyping.
 */
final class SubtypeCache {
  // For each pair (key, val) in this map, we are in the process of checking
  // whether key is a subtype of val (during regular subtype checking or during
  // unification). The values of the map are always interfaces.
  private final PersistentMap<NominalType, NominalType> m;

  private SubtypeCache(PersistentMap<NominalType, NominalType> m) {
    this.m = m;
  }

  static SubtypeCache create() {
    return new SubtypeCache(PersistentMap.<NominalType, NominalType>create());
  }

  NominalType get(NominalType key) {
    return this.m.get(key);
  }

  SubtypeCache with(NominalType key, NominalType value) {
    checkArgument(value.isInterface());
    return new SubtypeCache(this.m.with(key, value));
  }
}
