package br.com.pirlamps.farmtracker.greeting;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.pirlamps.farmtracker.foundation.model.UserVO;

/**
 * Created by root-matheus on 14/03/17.
 */

public class GreetingPresenter {

    interface GreetingPresenterDelegate{
        void didLoginWithSuccess();
        void didLoginWithError(String message);
    }

    private  GreetingPresenterDelegate delegate;
    private FirebaseAuth auth;
    private DatabaseReference ref;
    private FirebaseUser user;

    public GreetingPresenter(GreetingPresenterDelegate delegate) {
        this.delegate = delegate;
        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("farmTracker").child("users");
    }

    public void login(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    user = auth.getCurrentUser();
                    if(user!=null){
                        ref.setValue(new UserVO(user.getEmail()
                                ,user.getUid())).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                delegate.didLoginWithSuccess();
                            }
                        });
                    }
                }else{
                    delegate.didLoginWithError(task.getException().getLocalizedMessage());
                }
            }
        });
    }
}
