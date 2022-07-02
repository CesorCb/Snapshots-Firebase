package com.cesor.android.snapshots.entities

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

/****
 * Project: Snapshots
 * From: com.cesor.android.snapshots
 * Created by: César Castro on 30/06/2022 at 23:52.
 ***/
@IgnoreExtraProperties
data class Snapshot(@get: Exclude var id : String = "",
    var title: String = "",
    var photoUrl: String = "",
    var likeList: Map<String, Boolean> = mutableMapOf()
)
