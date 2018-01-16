package sample.qiitaclient

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
    }

    private fun dummyArticle(title: String, userName: String) : Article {
        return Article("1",title, "https://",
                User("",userName,"")
        )
    }
}
