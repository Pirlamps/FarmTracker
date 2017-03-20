package br.com.pirlamps.farmtracker.greeting;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.databinding.ActivityGreetingBinding;
import br.com.pirlamps.farmtracker.main.MainActivity;

/**
 * Created by root-matheus on 21/01/17.
 */

public class GreetingActivity extends Activity implements GreetingPresenter.GreetingPresenterDelegate{

    ActivityGreetingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(GreetingActivity.this,  R.layout.activity_greeting);
        final GreetingPresenter presenter = new GreetingPresenter(this);
        binding.outletLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.outletEmail.getText().toString();
                String password = binding.outletPassword.getText().toString();

                presenter.login(email,password);
            }
        });
    }


    @Override
    public void didLoginWithSuccess() {

        Intent i = new Intent(GreetingActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void didLoginWithError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
