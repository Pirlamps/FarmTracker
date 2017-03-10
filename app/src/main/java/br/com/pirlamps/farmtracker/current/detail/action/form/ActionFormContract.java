package br.com.pirlamps.farmtracker.current.detail.action.form;

import br.com.pirlamps.farmtracker.foundation.model.ActionVO;

/**
 * Created by root-matheus on 09/03/17.
 */

public interface ActionFormContract {

    interface View{
        void onSuccess();

        void onError();
    }

    interface Presenter{


        void sendAction(ActionVO action);
    }

}
