package com.cesor.android.snapshots

import com.google.firebase.database.IgnoreExtraProperties

/****
 * Project: Snapshots
 * From: com.cesor.android.snapshots
 * Created by: César Castro on 30/06/2022 at 23:52.
 ***/
@IgnoreExtraProperties
data class Snapshot(
    val id : String = "",
    val title: String = "",
    val photoUrl: String = "",
    val likeList: Map<String, Boolean> = mutableMapOf()
)
