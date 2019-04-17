package com.example.cateringplatform.Utills

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.kaopiz.kprogresshud.KProgressHUD


fun showToast(context: Context,message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

private var kProgressHUD: KProgressHUD? = null

fun showProgressBar(activity: Activity) {
    kProgressHUD = KProgressHUD.create(activity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(1)
            .setDimAmount(0.5f)

    kProgressHUD?.show()
}

fun hideProgressBar() {
    if (kProgressHUD != null)
        kProgressHUD?.dismiss()
}
