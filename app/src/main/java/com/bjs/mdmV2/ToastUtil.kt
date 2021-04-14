package com.bjs.mdmV2

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 *
 * Created by chauhan  :)  on 21/8/20.
 *
 */

class ToastUtil {

    companion object {

      //asdaaaaaaaaaaaaaaaaa
        @JvmStatic
        fun showShortToast(context: Context, message: String) {
            runOnMainThread({
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            })
        }


        @JvmStatic
        fun showShortToast(context: Context, @StringRes messageId: Int) =
            showShortToast(context, context.getString(messageId))


        @JvmStatic
        fun showLongToast(context: Context, message: String) {
            runOnMainThread({
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            })
        }


        @JvmStatic
        fun showLongToast(context: Context, @StringRes messageId: Int) =
            showLongToast(context, context.getString(messageId))


    }


}

fun Activity.showLongToast(message: String) {
    runIfNotDestroyed {
        ToastUtil.showLongToast(this, message)
    }
}


fun Activity.showLongToast(@StringRes messageId: Int) = showLongToast(getString(messageId))


fun Activity.showShortToast(message: String) {
    runIfNotDestroyed {
        ToastUtil.showShortToast(this, message)
    }
}

fun Activity.showShortToast(@StringRes messageId: Int) = showShortToast(getString(messageId))

fun AppCompatActivity.showLongToast(message: String) {
    runIfNotDestroyed {
        ToastUtil.showLongToast(this, message)
    }
}


fun AppCompatActivity.showLongToast(@StringRes messageId: Int) = showLongToast(getString(messageId))


fun AppCompatActivity.showShortToast(message: String) {
    runIfNotDestroyed {
        ToastUtil.showShortToast(this, message)
    }
}


fun AppCompatActivity.showShortToast(@StringRes messageId: Int) =
    showShortToast(getString(messageId))


fun Fragment.showLongToast(message: String) {
    context?.let {
        ToastUtil.showLongToast(it, message)
    }
}


fun Fragment.showLongToast(@StringRes messageId: Int) = showLongToast(getString(messageId))


fun Fragment.showShortToast(message: String) {
    context?.let {
        ToastUtil.showShortToast(it, message)
    }
}


fun Fragment.showShortToast(@StringRes messageId: Int) = showShortToast(getString(messageId))