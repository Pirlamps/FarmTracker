package br.com.pirlamps.farmtracker.current.detail.action.form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.pirlamps.farmtracker.databinding.FragmentActionFormBinding;
import br.com.pirlamps.farmtracker.foundation.model.ActionVO;
import br.com.pirlamps.farmtracker.foundation.model.CultureVO;
import br.com.pirlamps.farmtracker.foundation.util.JSONStringDate;

/**
 * Created by root-matheus on 02/03/17.
 */

public class ActionFormFragment extends Fragment implements ActionFormContract.View {

    FragmentActionFormBinding binding;
    ActionFormPresenter presenter;
    private ActionVO.TypeEnum type;
    private CultureVO current;
    private static final String CULTURE_TAG = "culture_tag";
    private static final String TYPE_TAG = "type_tag";

    public static ActionFormFragment newInstance(CultureVO current, ActionVO.TypeEnum type) {

        Bundle args = new Bundle();
        args.putSerializable(TYPE_TAG, type);
        args.putSerializable(CULTURE_TAG,current);
        ActionFormFragment fragment = new ActionFormFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.type = (ActionVO.TypeEnum) getArguments().getSerializable(TYPE_TAG);
        this.current = (CultureVO) getArguments().getSerializable(CULTURE_TAG);
        presenter = new ActionFormPresenter(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentActionFormBinding.inflate(inflater,container,false);

        binding.outletSaveActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendAction(current,getAction());
            }
        });

        return binding.getRoot();
    }

    private ActionVO getAction(){

        String name = binding.outletActionName.getText().toString();
        String cost = binding.outletActionCost.getText().toString();
        String detail = binding.outletActionDetail.getText().toString();
        ActionVO action = new ActionVO(this.type,name,cost,detail, JSONStringDate.dateNow());
        action.setActionId(UUID.randomUUID().toString());
        return action;
    }



    @Override
    public void onSuccess() {
        Toast.makeText(getContext(), "Nova entrada enviada com sucesso!", Toast.LENGTH_SHORT).show();
        //TODO voltar a tela
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Erro ao enviar nova entrada.", Toast.LENGTH_SHORT).show();
    }
}
