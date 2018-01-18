package sample.qiitaclient.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by shinyayamamoto on 2018/01/16.
 */

@Parcelize
data class Article(val id: String,
                   val title: String,
                   val url: String,
                   val user: User) : Parcelable {
    private constructor() : this("","","",User())
}
