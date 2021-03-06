package lc.lcwaikiki.com.mvvmdatabindinglivedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.ui.BannersFragments;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,BannersFragments.newInstance())
                    .commitNow();
        }
    }
}
