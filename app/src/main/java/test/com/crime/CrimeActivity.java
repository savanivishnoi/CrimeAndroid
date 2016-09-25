package test.com.crime;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class CrimeActivity extends AppCompatActivity {
   private static final String TAG = "Activity main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
//        if(fragment == null){
//            fragment = new CrimeFragment();
//            fm.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
//        }
        FragmentManager f = getSupportFragmentManager();
        Fragment fragment = f.findFragmentById(R.id.fragmentContainer);
        if(fragment == null){
            fragment = new CrimeListFragment();
            f.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on start" );
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
