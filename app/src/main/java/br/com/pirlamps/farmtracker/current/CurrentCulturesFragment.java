package br.com.pirlamps.farmtracker.current;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import br.com.pirlamps.farmtracker.R;
import br.com.pirlamps.farmtracker.current.detail.CurrentCultureDetailFragment;
import br.com.pirlamps.farmtracker.databinding.FragmentCurrentCulturesBinding;
import br.com.pirlamps.farmtracker.main.MainActivity;
import br.com.pirlamps.farmtracker.foundation.util.TesteAdapter;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

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
        this.prepareButtons();


        return binding.getRoot();
    }

    private void prepareButtons(){
        binding.outletCurrentCultureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFragment, new CurrentCultureDetailFragment(), "CurrentCultureDetail");
                ft.addToBackStack("CurrentCultureDetail");
                ft.commit();
            }
        });


        binding.outletAddCultureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCulture();
            }
        });
    }

    public void newCulture(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_new_culture, (ViewGroup) getActivity().findViewById(R.id.activity_main),false);

//layout_root should be the name of the "top-level" layout node in the dialog_layout.xml file.
        final EditText cultureName = (EditText) layout.findViewById(R.id.outletCultureName);
        final EditText cultureLocation = (EditText) layout.findViewById(R.id.outletCultureLocation);

        //Building dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.AlertDialogCustom);
        builder.setView(layout);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //save info where you want it
                Toast.makeText(getContext(), "Nova cultura: "+cultureName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();

//        dialog.setOnShowListener( new DialogInterface.OnShowListener() {
//                                      @Override
//                                      public void onShow(DialogInterface arg0) {
//                                          dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(getResources().getColor(R.color.background));
//                                          dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.background));
//                                      }
//                                  });
        dialog.show();
    }
}
