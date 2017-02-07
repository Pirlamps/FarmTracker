package br.com.pirlamps.farmtracker.current.detail.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pirlamps.farmtracker.databinding.FragmentNewActionBinding;

/**
 * Created by root-matheus on 06/02/17.
 */

public class NewActionFragment extends Fragment{

    FragmentNewActionBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewActionBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }
}
