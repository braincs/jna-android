/* Copyright (c) 2007 Timothy Wall, All Rights Reserved
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.  
 */
package com.sun.jna.examples.win32;

import java.util.Calendar;
import java.util.TimeZone;
import junit.framework.TestCase;

public class Kernel32Test extends TestCase {
    
    public void testStructureOutArgument() {
        Kernel32 kernel = Kernel32.INSTANCE;
        Kernel32.SYSTEMTIME time = new Kernel32.SYSTEMTIME();
        kernel.GetSystemTime(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        assertEquals("Hour not properly set", 
                     cal.get(Calendar.HOUR_OF_DAY), time.wHour); 
        assertEquals("Day not properly set", 
                     cal.get(Calendar.DAY_OF_WEEK)-1, 
                     time.wDayOfWeek); 
        assertEquals("Year not properly set", 
                     cal.get(Calendar.YEAR), time.wYear); 
    }
    
    public void testGetLastError() {
        Kernel32 kernel = Kernel32.INSTANCE;
        kernel.GetLastError();
        if (kernel.GetProcessId(null) == 0) {
            final int INVALID_HANDLE = 6;
            int code = kernel.GetLastError();
            assertEquals("GetLastError failed", INVALID_HANDLE, code);
            // Unclear why this fails
            //int ERRCODE  = 8;
            //kernel.SetLastError(ERRCODE);
            //assertEquals("Wrong GetLastError value", ERRCODE, kernel.GetLastError());
        }
        else {
            fail("GetProcessId(NULL) should fail");
        }
    }
}