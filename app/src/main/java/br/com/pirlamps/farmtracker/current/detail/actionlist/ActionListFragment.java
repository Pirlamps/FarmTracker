package br.com.pirlamps.farmtracker.current.detail.actionlist;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.pirlamps.farmtracker.BR;
import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.detail.CurrentCultureDetailFragment;
import br.com.pirlamps.farmtracker.current.detail.actionlist.detail.ActionListDetailFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentCultureActionsBinding;
import br.com.pirlamps.farmtracker.foundation.joat.JoatAdapter;
import br.com.pirlamps.farmtracker.foundation.joat.JoatObject;
import br.com.pirlamps.farmtracker.foundation.model.ActionVO;
import br.com.pirlamps.farmtracker.foundation.model.CultureVO;

/*
 * Created by root-matheus on 09/04/17.
 */

public class ActionListFragment extends Fragment {

    FragmentCultureActionsBinding binding;
    private static final String CULTURE_TAG = "culture_tag";
    private DatabaseReference ref;
    private JoatAdapter adapter;
    private CultureVO current;

    public static ActionListFragment newInstance(CultureVO culture) {

        Bundle args = new Bundle();
        args.putSerializable(CULTURE_TAG,culture);
        ActionListFragment fragment = new ActionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        adapter = new JoatAdapter(getContext());
        current = (CultureVO) getArguments().getSerializable(CULTURE_TAG);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCultureActionsBinding.inflate(inflater,container,false);

        getActionsFromCulture(current);
        binding.outletActionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActionVO action = ((ActionVO) ((JoatObject) adapter.getItem(position)).getBindingObject());
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, ActionListDetailFragment.newInstance(action), "ActionListDetail");
                ft.addToBackStack("ActionListDetail");
                ft.commit();
            }
        });
        return binding.getRoot();
    }

    public void getActionsFromCulture(CultureVO culture){

        ref = FirebaseDatabase.getInstance().getReference()
                .child("farmTracker")
                .child("actions")
                .child(culture.getCultureId());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ActionVO> actions = new ArrayList<>();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    actions.add(child.getValue(ActionVO.class));
                }

                List<JoatObject> adapterList = new ArrayList<>();
                for (ActionVO action : actions) {
                    adapterList.add(new JoatObject(R.layout.row_culture_action, BR.actionRow,action,action.getType().toString()));
                }
                adapter.setData(adapterList);
                binding.outletActionList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
