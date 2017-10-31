package com.example.abdulrahman.sqlitedb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Abdulrahman on 23/10/17.
 */

public class Showss extends DialogFragment implements View.OnClickListener {
    View view1;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view1=inflater.inflate(R.layout.test,container,false);


         button=(Button) view1.findViewById(R.id.button5);

button.setOnClickListener(this);
        return view1;
    }

    @Override
    public void onClick(View v) {
       this.dismiss();
      
        EditText editText=(EditText) view1.findViewById(R.id.editText3);
        MainActivity mainActivity=(MainActivity) getActivity();

        mainActivity.pass(editText.getText().toString());
    }
}

