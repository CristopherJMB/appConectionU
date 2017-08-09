package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class crearGrupo extends AppCompatActivity {

    Spinner Cursos;
    Button btnCGrupo;
    EditText txtMateria;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grupo);

        Cursos=(Spinner)findViewById(R.id.sCursos);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Cursos, android.R.layout.simple_spinner_item);
        Cursos.setAdapter(adapter);

        btnCGrupo=(Button)findViewById(R.id.btnCrearGrup);
        txtMateria=(EditText)findViewById(R.id.txtMateria);
        //Cursos=(Spinner)findViewById(R.id.sCursos);

        btnCGrupo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertRegGrup(String.valueOf(txtMateria.getText()),
                        String.valueOf(Cursos)); //VERIFICAR EL .GETTEXT()

                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_LONG).show();

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }
        });

    }
}

