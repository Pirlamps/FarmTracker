package br.com.pirlamps.farmtracker.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.greeting.GreetingActivity;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import me.wangyuwei.particleview.ParticleView;

/**
 * Created by root-matheus on 20/01/17.
 */

public class SplashActivity extends Activity implements ParticleView.ParticleAnimListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        ParticleView pv = (ParticleView) findViewById(R.id.splash_animation);
        pv.startAnim();

        pv.setOnParticleAnimListener(this);
    }

    @Override
    public void onAnimationEnd() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent i = new Intent(SplashActivity.this, GreetingActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
