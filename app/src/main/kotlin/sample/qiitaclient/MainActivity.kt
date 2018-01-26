package sample.qiitaclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import sample.qiitaclient.client.ArticleClient
import sample.qiitaclient.model.Article
import sample.qiitaclient.model.User
import sample.qiitaclient.view.ArticleListAdapter
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers;


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val queryEditText = findViewById(R.id.query_edit_text) as EditText
        val searchButton = findViewById(R.id.search_button) as Button
        val listView = findViewById(R.id.list_view) as ListView

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

        listView.adapter = listAdapter
        listView.setOnItemClickListener{ adpterView, view, position, id ->
            val article = listAdapter.articels[position]
            ArticleActivity.intent(this, article).let {
                startActivity(it)
            }
        }


        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val articleClient = retrofit.create(ArticleClient::class.java)

        //検索
        searchButton.setOnClickListener {



        }
        Log.d("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@","hogehoge")
        val service = retrofit.create(ArticleClient::class.java)
        service.search("kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({  list ->
                        Log.d("list",list.toString())
                        listAdapter.articels = list
                });


    }

    private fun dummyArticle(title: String, userName: String) : Article {
        return Article("1",title, "https://qiita.com/RyotaMurohoshi/items/01b370f34a4bf96f5c39",
                User("",userName,"https://scontent-nrt1-1.xx.fbcdn.net/v/t1.0-9/26814525_806848632835064_3725210286736551885_n.jpg?oh=b2f55ca083688436f3998d4f71999eea&oe=5AE40326")
        )
    }
}


