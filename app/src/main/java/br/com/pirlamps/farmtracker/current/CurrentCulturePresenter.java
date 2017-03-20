package br.com.pirlamps.farmtracker.current;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.pirlamps.farmtracker.foundation.model.CultureVO;

/**
 * Created by root-matheus on 16/03/17.
 */

public class CurrentCulturePresenter {

    private DatabaseReference ref;
    private String TAG = CurrentCulturePresenter.class.getSimpleName();

    public void createNewCulture(CultureVO culture){
        //userSingleton
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            ref = FirebaseDatabase.getInstance().getReference()
                    .child("farmTracker")
                    .child("cultures")
                    .child(user.getUid())
                    .child(culture.getCultureId());

            ref.setValue(culture).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "onComplete: Error", task.getException());
                    } else {
                        Log.d(TAG, "onComplete: Success");

                    }
                }
            });
        }

    }


}
