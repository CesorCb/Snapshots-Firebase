package com.cesor.android.snapshots

import android.app.Application
import com.google.firebase.auth.FirebaseUser

/****
 * Project: Snapshots
 * From: com.cesor.android.snapshots
 * Created by: César Castro on 2/07/2022 at 15:57.
 ***/
class SnapshotsApplication : Application() {

    companion object {
        const val PATH_SNAPSHOTS = "snapshots"
        const val PROPERTY_LIKE_LIST = "likeList"

        lateinit var currentUser: FirebaseUser
    }
}