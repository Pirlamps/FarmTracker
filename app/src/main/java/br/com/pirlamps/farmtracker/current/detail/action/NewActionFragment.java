package br.com.pirlamps.farmtracker.current.detail.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.detail.action.form.ActionFormFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentNewActionBinding;
import br.com.pirlamps.farmtracker.foundation.model.ActionVO;

/**
 * Created by root-matheus on 06/02/17.
 */

public class NewActionFragment extends Fragment{

    FragmentNewActionBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewActionBinding.inflate(inflater, container,false);

        binding.outletMechanicalOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment(ActionVO.TypeEnum.MECANICOS);
            }
        });

        binding.outletCultureCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment(ActionVO.TypeEnum.TRATOS);
            }
        });

        binding.outletFertilizationAndNutricion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment(ActionVO.TypeEnum.NUTRICAO);
            }
        });

        binding.outletPestControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment(ActionVO.TypeEnum.CONROLE_DOENCAS);
            }
        });



        return binding.getRoot();
    }



    private void nextFragment(ActionVO.TypeEnum actionType){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragment, ActionFormFragment.newInstance(actionType), "actionForm");
        ft.addToBackStack("actionForm");
        ft.commit();
    }
}
