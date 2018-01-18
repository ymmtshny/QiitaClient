package sample.qiitaclient

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import sample.qiitaclient.model.Article
import sample.qiitaclient.model.User
import sample.qiitaclient.view.ArticleListAdapter

import sample.qiitaclient.view.ArticleView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        listAdapter.articels = listOf(
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Kotlin入門", "たろう"),
                dummyArticle( "Java入門", "次郎")
                )
        val listView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter
        listView.setOnItemClickListener{ adpterView, view, position, id ->
            val article = listAdapter.articels[position]
            ArticleActivity.intent(this, article).let {
                startActivity(it)
            }
        }

    }

    private fun dummyArticle(title: String, userName: String) : Article {
        return Article("1",title, "https://qiita.com/RyotaMurohoshi/items/01b370f34a4bf96f5c39",
                User("",userName,"")
        )
    }
}
