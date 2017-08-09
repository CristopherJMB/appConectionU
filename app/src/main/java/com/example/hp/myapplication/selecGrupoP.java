package com.example.hp.myapplication;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Beans.UsuarioBeans;
import OpenHelper.SQLite_OpenHelper;

public class selecGrupoP extends AppCompatActivity {

    ListView lv;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"DB1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_grupo_p);

        lv=(ListView)findViewById(R.id.lvConten);
        cargarDatos("");
    }

    private void cargarDatos(String nom){
        helper.abrir();
        Cursor cursor=null;

             try {
                 if (nom == null || nom.length() == 0) {
                        cursor = helper.listarUsuarios();
                    }else {

                    }

             }catch (SQLException e){
                 e.printStackTrace();
             }
        ArrayList<UsuarioBeans> item=new ArrayList<UsuarioBeans>();

        do{
            UsuarioBeans u=new UsuarioBeans(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4));
           item.add(u);

        }while (cursor.moveToNext());

        ArrayAdapter<UsuarioBeans> adaptador=new ArrayAdapter<UsuarioBeans>(this,android.R.layout.simple_list_item_1,item);
        lv.setAdapter(adaptador);

    }
}
