package br.com.pirlamps.farmtracker.greeting;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.databinding.ActivityGreetingBinding;
import br.com.pirlamps.farmtracker.main.MainActivity;

/**
 * Created by root-matheus on 21/01/17.
 */

public class GreetingActivity extends Activity implements View.OnClickListener {

    ActivityGreetingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(GreetingActivity.this,  R.layout.activity_greeting);
        binding.outletLoginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(GreetingActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
