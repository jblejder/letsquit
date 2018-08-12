package com.projectblejder.letsquit.shared.framework.binding

import android.databinding.BaseObservable

open class BaseBindableModel : BaseObservable(), BindViewModel {
    override fun notifyPropertyChanged(fieldId: Int) {
        super.notifyPropertyChanged(fieldId)
    }
}