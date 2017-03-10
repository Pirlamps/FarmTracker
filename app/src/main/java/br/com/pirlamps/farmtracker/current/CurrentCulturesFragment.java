package br.com.pirlamps.farmtracker.current;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.detail.CurrentCultureDetailFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentCurrentCulturesBinding;
import br.com.pirlamps.farmtracker.main.MainActivity;
import br.com.pirlamps.farmtracker.foundation.util.TesteAdapter;

/**
 * Created by root-matheus on 06/02/17.
 */

public class CurrentCulturesFragment extends Fragment {

    private TesteAdapter adapter;
    FragmentCurrentCulturesBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TesteAdapter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCurrentCulturesBinding.inflate(inflater,container,false);
        adapter.setData(5);
        binding.outletCurrentCultureList.setAdapter(adapter);
        binding.outletCurrentCultureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity activity =(MainActivity) getActivity();
                activity.hideFloatButton();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, new CurrentCultureDetailFragment(), "CurrentCultureDetail");
                ft.addToBackStack("CurrentCultureDetail");
                ft.commit();
            }
        });

        return binding.getRoot();
    }
}
