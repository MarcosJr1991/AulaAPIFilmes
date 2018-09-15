package marcosjr.com.apidefilmes;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import marcosjr.com.apidefilmes.Fragments.FragmentNowPlaying;
import marcosjr.com.apidefilmes.Fragments.FragmentPopular;
import marcosjr.com.apidefilmes.Fragments.FragmentTopRated;
import marcosjr.com.apidefilmes.ViewAdapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);

        viewPager = (ViewPager) findViewById(R.id.viewoager);
        WebView webView = findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://www.themoviedb.org/");

        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager());

       //adicionando Fragmentos
        adapter.AddFragment(new FragmentNowPlaying(),"Lista  1");
        adapter.AddFragment(new FragmentPopular(),"Lista  2");
        adapter.AddFragment(new FragmentTopRated(),"Lista  3");

        //configuração do adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
