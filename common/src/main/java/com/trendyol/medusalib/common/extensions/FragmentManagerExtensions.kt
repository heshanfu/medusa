package com.trendyol.medusalib.common.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commitAllowingStateLoss()
}

fun FragmentManager.commitAdd(containerId: Int, fragment: Fragment, fragmentTag: String) {
    beginTransaction()
            .add(containerId, fragment, fragmentTag)
            .commitAllowingStateLoss()
}

fun FragmentManager.commitRemove(fragmentTag: String) {
    val foundFragment = findFragmentByTag(fragmentTag)
    foundFragment?.let {
        beginTransaction()
                .remove(foundFragment)
                .commitAllowingStateLoss()
    }
}

fun FragmentManager.commitAttach(fragmentTag: String) {
    val foundFragment = findFragmentByTag(fragmentTag)
    foundFragment?.let {
        beginTransaction()
                .attach(foundFragment)
                .commitAllowingStateLoss()
    }
}

fun FragmentManager.commitDetach(fragmentTag: String) {
    val foundFragment = findFragmentByTag(fragmentTag)
    foundFragment?.let {
        beginTransaction()
            .detach(foundFragment)
            .commitAllowingStateLoss()
    }
}

fun FragmentManager.commitHide(fragmentTag: String) {
    val foundFragment = findFragmentByTag(fragmentTag)
    foundFragment?.let {
        beginTransaction()
            .hide(foundFragment)
            .commitAllowingStateLoss()
    }
}

fun FragmentManager.commitShow(fragmentTag: String) {
    val foundFragment = findFragmentByTag(fragmentTag)
    foundFragment?.let {
        beginTransaction()
            .show(foundFragment)
            .commitAllowingStateLoss()
    }
}
