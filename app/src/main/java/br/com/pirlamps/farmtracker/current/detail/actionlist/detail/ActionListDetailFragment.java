package br.com.pirlamps.farmtracker.current.detail.actionlist.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pirlamps.farmtracker.databinding.FragmentCultureActionBinding;
import br.com.pirlamps.farmtracker.foundation.model.ActionVO;

/**
 * Created by root-matheus on 09/04/17.
 */

public class ActionListDetailFragment extends Fragment {

    FragmentCultureActionBinding binding;
    private static final String ACTION_TAG = "action_tag";
    private ActionVO action;

    public static ActionListDetailFragment newInstance(ActionVO action) {

        Bundle args = new Bundle();
        args.putSerializable(ACTION_TAG,action);
        ActionListDetailFragment fragment = new ActionListDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        action = (ActionVO)getArguments().getSerializable(ACTION_TAG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCultureActionBinding.inflate(inflater,container,false);
        binding.setCultureAction(action);
        return binding.getRoot();
     }
}
