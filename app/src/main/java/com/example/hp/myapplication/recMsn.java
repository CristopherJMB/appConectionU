package com.example.hp.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Beans.MensajeBeans;
import OpenHelper.SQLite_OpenHelper;

public class recMsn extends AppCompatActivity {


    ListView liV;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_msn);

        liV=(ListView)findViewById(R.id.lvrecMsn);
        enviaMSN("");
    }

    private void enviaMSN(String tit){
        helper.abrir();
        Cursor cursor=null;
        if(tit==null||tit.length()==0){
            cursor=helper.mostrarMsn();
        }else{

        }
        ArrayList<MensajeBeans> item=new ArrayList<MensajeBeans>();
        do{
            MensajeBeans u=new MensajeBeans(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            item.add(u);
        }while(cursor.moveToNext());

        ArrayAdapter<MensajeBeans> adaptador=new ArrayAdapter<MensajeBeans>
                (this,android.R.layout.simple_list_item_1,item);

        liV.setAdapter(adaptador);
    }
}
