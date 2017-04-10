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
import br.com.pirlamps.farmtracker.current.detail.actionlist.ActionListFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentCultureBinding;
import br.com.pirlamps.farmtracker.foundation.model.CultureVO;

/**
 * Created by root-matheus on 06/02/17.
 */

public class CurrentCultureDetailFragment extends Fragment {

    FragmentCultureBinding binding;
    private static final String CULTURE_TAG = "culture_tag";

    public static CurrentCultureDetailFragment newInstance(CultureVO culture) {

        Bundle args = new Bundle();
        args.putSerializable(CULTURE_TAG, culture);
        CurrentCultureDetailFragment fragment = new CurrentCultureDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCultureBinding.inflate(inflater,container,false);
        final CultureVO culture = (CultureVO) getArguments().getSerializable(CULTURE_TAG);
        binding.setCultureDetail(culture);
        binding.outletDayAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, NewActionFragment.newInstance(culture), "NewAction");
                ft.addToBackStack("NewAction");
                ft.commit();
            }
        });

        binding.outletCultureActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, ActionListFragment.newInstance(culture), "actionList");
                ft.addToBackStack("actionList");
                ft.commit();
            }
        });
        return binding.getRoot();
    }
}
