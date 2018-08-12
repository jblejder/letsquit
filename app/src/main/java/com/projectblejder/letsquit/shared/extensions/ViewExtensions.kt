package com.projectblejder.letsquit.shared.extensions

import android.view.View

fun View.click(listener: () -> Unit) {
    this.setOnClickListener { listener.invoke() }
}

fun View.click(listener: View.OnClickListener?) {
    this.setOnClickListener(listener)
}
