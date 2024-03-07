package com.max.ecomaxgo.maxpe.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.google.android.material.snackbar.Snackbar

object RotationUtils {
    private val ROTATE_FROM = 0.0f
    private val ROTATE_TO = 359.0f
    var r: RotateAnimation? = null // = new RotateAnimation(ROTATE_FROM, ROTATE_TO)

    fun showSnackBar(view: View, msg: String) {
        val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
        /*snackbar.setAction("View", object : View.OnClickListener {
            override fun onClick(v: View?) {
                snackbar.dismiss()
            }

        });*/

        snackbar.show();
    }

    fun setRotateAnim(){
        r = RotateAnimation(
            ROTATE_FROM,
            ROTATE_TO,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        r!!.duration = 2.toLong() * 300
        r!!.repeatMode = Animation.RESTART
        r!!.repeatCount = Animation.INFINITE
    }
}