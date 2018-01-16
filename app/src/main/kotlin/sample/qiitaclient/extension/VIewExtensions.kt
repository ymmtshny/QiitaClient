package sample.qiitaclient.extension

/**
 * Created by shinyayamamoto on 2018/01/16.
 */

import android.support.annotation.IdRes
import android.view.View

fun <T: View> View.bindView(@IdRes id:Int): Lazy<T> = lazy {
    findViewById(id) as T
}
