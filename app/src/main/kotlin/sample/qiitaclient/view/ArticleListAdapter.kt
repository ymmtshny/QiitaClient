package sample.qiitaclient.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import sample.qiitaclient.model.Article

/**
 * Created by shinyayamamoto on 2018/01/16.
 */

class ArticleListAdapter(private val context: Context) : BaseAdapter() {

    var articels : List<Article> = emptyList()

    override fun getCount(): Int {
        return  articels.count()
    }

    override fun getItem(p0: Int): Any {
        return articels[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        return ((p1 as? ArticleView) ?: ArticleView(context)).apply {
            setArticle(articels[p0])
        }
    }

}
