// IMyAidlInterface.aidl
package com.example.itarch;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String getURL(String operator_name);
}