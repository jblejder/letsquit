package com.projectblejder.letsquit.shared.framework.binding

import android.databinding.Observable

interface BindViewModel : Observable {
    fun notifyPropertyChanged(fieldId: Int)
}