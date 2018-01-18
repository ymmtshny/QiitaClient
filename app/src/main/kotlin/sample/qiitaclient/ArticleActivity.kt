package sample.qiitaclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import sample.qiitaclient.R
import sample.qiitaclient.model.Article

/**
 * Created by shinyayamamoto on 2018/01/18.
 */

class ArticleActivity: AppCompatActivity() {

    companion object {
        private const val ARTICLE_EXTRE = "article"

        fun intent(context: Context, article: Article): Intent {
            val intent = Intent(context, ArticleActivity::class.java)

            intent.putExtra(ARTICLE_EXTRE, article)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val webView = findViewById(R.id.article_webview) as WebView
        val article = intent.getParcelableExtra(ARTICLE_EXTRE) as Article
        webView.loadUrl(article.url)

    }

}
