package br.com.pirlamps.farmtracker.current.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.detail.action.NewActionFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentCultureBinding;

/**
 * Created by root-matheus on 06/02/17.
 */

public class CurrentCultureDetailFragment extends Fragment {

   FragmentCultureBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCultureBinding.inflate(inflater,container,false);
        binding.outletDayAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, new NewActionFragment(), "NewAction");
                ft.addToBackStack("NewAction");
                ft.commit();
            }
        });
        return binding.getRoot();
    }
}
