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
package io.airlift.drift.codec;

import io.airlift.drift.annotations.ThriftField;
import io.airlift.drift.annotations.ThriftUnion;
import io.airlift.drift.annotations.ThriftUnionId;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftUnion("Union")
public final class UnionField
{
    @ThriftField(1)
    public String stringValue;

    @ThriftField(2)
    public Long longValue;

    @ThriftField(3)
    public Fruit fruitValue;

    @ThriftUnionId
    public short _id;

    public UnionField()
    {
    }

    public UnionField(String stringValue)
    {
        this._id = 1;
        this.stringValue = stringValue;
    }

    public UnionField(Long longValue)
    {
        this._id = 2;
        this.longValue = longValue;
    }

    public UnionField(Fruit fruitValue)
    {
        this._id = 3;
        this.fruitValue = fruitValue;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(stringValue, longValue, fruitValue);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UnionField that = (UnionField) obj;
        return this._id == that._id
                && Objects.equals(this.stringValue, that.stringValue)
                && Objects.equals(this.longValue, that.longValue)
                && Objects.equals(this.fruitValue, that.fruitValue);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("_id", _id)
                .add("stringValue", stringValue)
                .add("longValue", longValue)
                .add("fruitValue", fruitValue)
                .toString();
    }
}
