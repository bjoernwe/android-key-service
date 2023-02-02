package dev.upaya.serivcewithkeys

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent


class AccessibilityKeyDetector : AccessibilityService() {

    private val TAG = "AccessKeyDetector"

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        if (event != null) {
            Log.d(TAG, "Key pressed via accessibility is: $event")
        }
        return true
    }

    override fun onServiceConnected() {
        Log.i(TAG, "Service connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        Log.i(TAG, "Received event: $event")
    }
    override fun onInterrupt() {}
}
