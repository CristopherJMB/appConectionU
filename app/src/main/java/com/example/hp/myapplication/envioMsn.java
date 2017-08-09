package com.example.hp.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Beans.MensajeBeans;
import OpenHelper.SQLite_OpenHelper;
public class envioMsn extends AppCompatActivity {

    Button btnenvioMsn;
    EditText txtMsn, txtTt;
    ListView lv;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_msn);


        btnenvioMsn=(Button)findViewById(R.id.btnEnvMsn);

        txtMsn=(EditText)findViewById(R.id.txtEnvE);
        txtTt=(EditText)findViewById(R.id.txtTit);
        btnenvioMsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarMsn(String.valueOf(txtMsn.getText()),
                        String.valueOf(txtTt.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Mensaje Enviado"
                        ,Toast.LENGTH_LONG).show();
            }
        });

        lv=(ListView)findViewById(R.id.lvUsuarios);
       enviaMsn("");
    }

    private void enviaMsn(String tit){
        helper.abrir();
        Cursor cursor=null;
        if(tit==null||tit.length()==0){
            cursor=helper.mostrarMsn();
        }else {
        }

        ArrayList<MensajeBeans> item=new ArrayList<MensajeBeans>();
        do{
            MensajeBeans u=new MensajeBeans(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            item.add(u);
        }while (cursor.moveToNext());

        ArrayAdapter<MensajeBeans> adaptador=new ArrayAdapter<MensajeBeans>
                (this,android.R.layout.simple_list_item_1,item);
        lv.setAdapter(adaptador);
    }
}

        /*
        private void enviaMsn(String m){
        helper.abrir()
        ArrayList<UsuarioBeans> item=new ArrayList<UsuarioBeans>();
        do{
           UsuarioBeans u=new UsuarioBeans(cursor.getInt(0),cursor.getString(1),
                   cursor.getString(2),cursor.getString(3),cursor.getString(4));
            item.add(u);

        }while (cursor.moveToNext());

        ArrayAdapter<UsuarioBeans> adaptador=new ArrayAdapter<UsuarioBeans>(this,android.R.layout.simple_list_item_1,item);
        lv.setAdapter(adaptador);


    }*/
