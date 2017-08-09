package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;
public class registro extends AppCompatActivity {

    Button btnGrabarUser;
    EditText txtNomUserp,txtApeUserp,txtMilUserp,txtPassUserp;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnGrabarUser=(Button)findViewById(R.id.btnRegP);
        txtNomUserp=(EditText)findViewById(R.id.txtNomP);
        txtApeUserp=(EditText)findViewById(R.id.txtApeP);
        txtMilUserp=(EditText)findViewById(R.id.txtMailP);
        txtPassUserp=(EditText)findViewById(R.id.txtPassP);
        btnGrabarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUserp.getText()),
                        String.valueOf(txtApeUserp.getText()),
                        String.valueOf(txtMilUserp.getText()),
                        String.valueOf(txtPassUserp.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso"
                ,Toast.LENGTH_LONG).show();

                Intent i=new Intent(getApplicationContext(),crearGrupo.class);
                startActivity(i);

            }
        });
    }
}
