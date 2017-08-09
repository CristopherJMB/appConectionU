package com.example.hp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class registroA extends AppCompatActivity {

    Button btnGrabarAlumno;
    TextView txtNomUserA, txtApeUserA, txtMailUserA, txtPassUserA;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        setContentView(R.layout.activity_registro2);
        btnGrabarAlumno=(Button)findViewById(R.id.btnRegA);
        txtNomUserA=(TextView)findViewById(R.id.txtNomA);
        txtApeUserA=(TextView)findViewById(R.id.txtApeA);
        txtMailUserA=(TextView)findViewById(R.id.txtMailA);
        txtPassUserA=(TextView)findViewById(R.id.txtPassA);
        btnGrabarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarRegA(String.valueOf(txtNomUserA.getText()),
                        String.valueOf(txtApeUserA.getText()),
                        String.valueOf(txtMailUserA.getText()),
                        String.valueOf(txtPassUserA.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
