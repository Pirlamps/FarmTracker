package br.com.pirlamps.farmtracker.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.CurrentCulturesFragment;
import br.com.pirlamps.farmtracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment = null;
    private FragmentManager fm;
    private FragmentTransaction ft;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        currentFragment = new CurrentCulturesFragment();

        ft.replace(R.id.mainFragment, currentFragment).commit();
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return replaceFragment(item);
            }
        });
    }

    public boolean replaceFragment(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_current:
                this.currentFragment = new CurrentCulturesFragment();
                break;
            case R.id.action_historic:
                break;
            case R.id.action_profile:
                break;


        }
        ft = fm.beginTransaction();
        ft.replace(R.id.mainFragment, currentFragment).commit();
        return true;
    }

    public void hideFloatButton(){
        binding.outletAddCultureButton.setVisibility(View.GONE);
    }
}
