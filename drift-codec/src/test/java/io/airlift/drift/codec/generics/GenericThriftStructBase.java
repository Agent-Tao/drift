/*
 * Copyright (C) 2012 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.airlift.drift.codec.generics;

import io.airlift.drift.annotations.ThriftField;

import java.util.Objects;

public class GenericThriftStructBase<T>
{
    private T genericProperty;

    public GenericThriftStructBase(@ThriftField(1) T genericProperty)
    {
        this.genericProperty = genericProperty;
    }

    @ThriftField(1)
    public T getGenericProperty()
    {
        return genericProperty;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GenericThriftStructBase<?> other = (GenericThriftStructBase<?>) obj;
        return Objects.equals(this.genericProperty, other.genericProperty);
    }
}
