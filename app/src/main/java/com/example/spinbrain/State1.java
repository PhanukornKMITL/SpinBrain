package com.example.spinbrain;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class State1 extends Fragment {
    Button btn;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    int thisState;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.state1,container,false);
        btn = v.findViewById(R.id.button);
        sp = getActivity().getSharedPreferences("Save", Context.MODE_PRIVATE);
        editor = sp.edit();
        thisState = sp.getInt("State",1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("State",++thisState);
                editor.commit();
                //StateFactory.Instance().setState(thisState);

                //replace fragment
                getFragmentManager().beginTransaction().replace(R.id.FragmentContainer,
                        (Fragment) StateFactory.Instance().getState(thisState)).commit();


            }
        });
        return v;
    }

}
