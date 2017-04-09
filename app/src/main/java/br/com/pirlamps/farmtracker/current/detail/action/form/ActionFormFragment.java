package br.com.pirlamps.farmtracker.current.detail.action.form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.pirlamps.farmtracker.databinding.FragmentActionFormBinding;
import br.com.pirlamps.farmtracker.foundation.model.ActionVO;
import br.com.pirlamps.farmtracker.foundation.util.JSONStringDate;

/**
 * Created by root-matheus on 02/03/17.
 */

public class ActionFormFragment extends Fragment implements ActionFormContract.View {

    FragmentActionFormBinding binding;
    ActionFormPresenter presenter;
    private ActionVO.TypeEnum type;

    public static ActionFormFragment newInstance(ActionVO.TypeEnum type) {

        Bundle args = new Bundle();
        args.putSerializable("type", type);
        ActionFormFragment fragment = new ActionFormFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.type = (ActionVO.TypeEnum) getArguments().getSerializable("type");
        presenter = new ActionFormPresenter(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentActionFormBinding.inflate(inflater,container,false);

        binding.outletSaveActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendAction(getAction());
            }
        });

        return binding.getRoot();
    }

    private ActionVO getAction(){

        String cost = binding.outletActionCost.getText().toString();
        String detail = binding.outletActionDetail.getText().toString();
        ActionVO action = new ActionVO(this.type,cost,detail, JSONStringDate.dateNow());
        return action;
    }



    @Override
    public void onSuccess() {
        Toast.makeText(getContext(), "yay :D", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "sem yay D:", Toast.LENGTH_SHORT).show();
    }
}
