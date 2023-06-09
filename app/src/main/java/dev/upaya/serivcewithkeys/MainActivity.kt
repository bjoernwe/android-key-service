package dev.upaya.serivcewithkeys

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
import android.util.Log
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.upaya.serivcewithkeys.ui.MainScreen


class MainActivity : ComponentActivity() {

    private val TAG = "AccessKeyDetector"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(onButtonClick = ::checkAccessibilityPermission)
        }
    }

    private fun checkAccessibilityPermission(): Boolean {

        var accessEnabled = 0

        try {
            accessEnabled = Settings.Secure.getInt(this.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED)
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }
        return if (accessEnabled == 0) {
            /** if not construct intent to request permission  */
            val intent = Intent(ACTION_ACCESSIBILITY_SETTINGS)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            /** request permission via start activity for result  */
            startActivity(intent)
            false
        } else {
            true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d(TAG, "Key pressed")
        //this prevents the key from performing the base function. Replace with super.onKeyDown to let it perform it's original function, after being consumed by your app.
        return true
    }

}
