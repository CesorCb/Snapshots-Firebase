package com.cesor.android.snapshots.utils

import com.google.android.material.snackbar.Snackbar
import java.time.Duration

/****
 * Project: Snapshots
 * From: com.cesor.android.snapshots
 * Created by: César Castro on 2/07/2022 at 02:24.
 ***/
interface MainAux {

    fun showMessage(resId: Int, duration: Int = Snackbar.LENGTH_SHORT)
}