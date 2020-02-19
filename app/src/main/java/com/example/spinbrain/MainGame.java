package com.example.spinbrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {

    final String data = "Save";
    private int state;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);


        txt = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);

        sp = getSharedPreferences(data , MODE_PRIVATE);
        editor = sp.edit();
        //editor.putInt("State",1);
        //editor.commit();
        state = sp.getInt("State",1);
        if(savedInstanceState == null){
            setState();

        }

        txt.setText(Integer.toString(state));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("State",++state);
                editor.commit();
                txt.setText(Integer.toString(state));
            }
        });




    }

    public void setState(){
       getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,
                (Fragment) StateFactory.Instance().getState(state)).commit();


    }

}
