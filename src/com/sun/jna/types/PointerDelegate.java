/* Copyright (c) 2007 Wayne Meissner, All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.  
 */

package com.sun.jna.types;

import com.sun.jna.Pointer;

/**
 *
 * @author wayne
 */
public class PointerDelegate implements NativeValue {
    Pointer pointer;
    public PointerDelegate(Pointer pointer) {
        this.pointer = pointer;
    }
    void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }
    public Object toNativeValue() {
        return pointer;
    }
    static Class nativeType() {
        return Pointer.class;
    }
}
