package sample.qiitaclient.client

import android.database.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import sample.qiitaclient.model.Article

/**
 * Created by shinyayamamoto on 2018/01/18.
 */

interface ArticleClient {

    @GET("/api/v2/items")
    fun search(@Query("query") query: String): Observable<List<Article>>
}
