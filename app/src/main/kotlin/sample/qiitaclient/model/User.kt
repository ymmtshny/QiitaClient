package sample.qiitaclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by shinyayamamoto on 2018/01/16.
 */

//data class Userpackage sample.qiitaclient.model
@Parcelize
data class User(val id: String,
                val name: String,
                val profileImageUrl: String) : Parcelable {
    constructor() : this("", "", "")
}
