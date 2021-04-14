package com.bjs.mdmV2

import android.app.Activity
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

/**
 * Created by chauhan :) on 21/8/20.
 */

internal fun Any.runOnMainThread(process: () -> Any?, delayInMs: Long = 0L) {
    Handler(Looper.getMainLooper()).postDelayed({
        if (this is AppCompatActivity) {
            runIfNotDestroyed { process() }
        } else if (this is Fragment) {
            runIfNotDestroyed { process() }
        } else if (this is Activity) {
            runIfNotDestroyed { process() }
        } else {
            process()
        }

    }, delayInMs)

}


internal fun Activity.runIfNotDestroyed(process: () -> Any?) {
    process()
}

internal fun AppCompatActivity.runIfNotDestroyed(process: () -> Any?) {
    if (this.lifecycle.currentState != Lifecycle.State.DESTROYED) {
        process()
    }
}

internal fun Fragment.runIfNotDestroyed(process: () -> Any?) {
    if (this.lifecycle.currentState != Lifecycle.State.DESTROYED) {
        process()
    }
}
