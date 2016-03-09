package com.hanjunchen.maze;

public class CallerClass {
	public static String getCallerClassName() { 
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(CallerClass.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                return ste.getClassName();
            }
        }
        return null;
     }
}
