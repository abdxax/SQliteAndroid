package com.example.abdulrahman.sqlitedb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void busave(View view) {
         user=(EditText) findViewById(R.id.editText);
         pass=(EditText) findViewById(R.id.editText2);
        DBSql sql=new DBSql(this);
      long id=  sql.insert(user.getText().toString(),pass.getText().toString());
        if(id>0){
            Toast.makeText(this,"the id user is "+id,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"has problem in database is not saved "+id,Toast.LENGTH_LONG).show();
        }
    }

    public void loadList(){

        DBSql dbSql=new DBSql(this);
       Cursor cursor= dbSql.querasy(null,null,null,DBmodle.Coluuser);
        ArrayList<Bmodel> bmodels=new ArrayList<Bmodel>();
        if (cursor.moveToFirst()){
            do {
                bmodels.add(new Bmodel (cursor.getString(cursor.getColumnIndex(DBmodle.Coluuser)),cursor.getString(cursor.getColumnIndex(DBmodle.Coluuser)),cursor.getInt(cursor.getColumnIndex("ID"))));
            }while (cursor.moveToNext());
        }
        Adapt adapt=new Adapt(bmodels);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(adapt);

    }

    public void buload(View view) {
      /*  DBSql sql=new DBSql(this);
        Cursor cursor=sql.querasy(null,null,null,DBmodle.Coluuser);
        if(cursor.moveToFirst()){
            String dst="";
            List<String> user =new ArrayList<String>();
            int i=0;
            do {
                dst+=cursor.getString(cursor.getColumnIndex(DBmodle.Coluuser))+" pass: "+cursor.getColumnIndex(DBmodle.ColuPassword)+" :: ";
               user.add(cursor.getString(cursor.getColumnIndex(DBmodle.Coluuser)) );
            }while (cursor.moveToNext());
           Toast.makeText(this,dst,Toast.LENGTH_LONG).show();
            ListView listView=(ListView) findViewById(R.id.list);
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,user);
            listView.setAdapter(arrayAdapter);
        }
        else{
            Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show();
        }
        */
       loadList();
    }

    public void Shwoss(View view) {
        Showss shwoss=new Showss();
        FragmentManager fragmentManager=getSupportFragmentManager();
        Showss showss=new Showss();
        showss.show(fragmentManager,"TEST FRO");


    }
public void pass (String s){
    String g=s;
    Toast.makeText(this,g,Toast.LENGTH_LONG).show();
//    pass.setText(s);
}
    public class Adapt extends BaseAdapter{

         ArrayList<Bmodel> bmodels;

        public Adapt(ArrayList<Bmodel> bmodels) {
            this.bmodels = bmodels;
        }

        @Override
        public int getCount() {
            return bmodels.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=getLayoutInflater();
            View views=layoutInflater.inflate(R.layout.list_tr,null);
            TextView user=(TextView) views.findViewById(R.id.textView5);
            TextView pass=(TextView) views.findViewById(R.id.textView6);
            Button del=(Button) views.findViewById(R.id.button3);
          user.setText(bmodels.get(position).UserName);
            pass.setText(bmodels.get(position).Password);

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] arg={String.valueOf(bmodels.get(position).ID)};
                    DBSql s=new DBSql(getApplicationContext());
                    s.delect("ID=?",arg);
                    loadList();
                }
            });
            return views;
        }
    }
}
