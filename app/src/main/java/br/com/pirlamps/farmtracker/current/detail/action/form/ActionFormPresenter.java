package br.com.pirlamps.farmtracker.current.detail.action.form;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.pirlamps.farmtracker.foundation.model.ActionVO;

/**
 * Created by root-matheus on 09/03/17.
 */

public class ActionFormPresenter implements ActionFormContract.Presenter{

    private final String TAG = ActionFormPresenter.class.getSimpleName();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("farmTracker").child("action");
    ActionFormContract.View view;

    public ActionFormPresenter(ActionFormContract.View view) {
        this.view = view;
    }

    @Override
    public void sendAction(ActionVO action) {
        ref.setValue(action).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "onComplete: "+task.isSuccessful());
                if(!task.isSuccessful()){
                    Log.w(TAG, "onComplete: failure",task.getException() );
                    view.onError();
                }else{
                    view.onSuccess();
                }
            }
        });
    }
}
