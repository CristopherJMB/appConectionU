package com.example.hp.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {


    TextView tvRegistrar;
    Button btnIngresar,btnIngresarA;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1); //INSTANCIA DE LOS REGISTROS QUE CONTIENE LA BD


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegistrar = (TextView) findViewById(R.id.tvRegistro);
        tvRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), identidad.class);
                startActivity(i);
            }
        });

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresarA=(Button)findViewById(R.id.btnINgresarA);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu = (EditText) findViewById(R.id.TxtUsuario);
                EditText txtpas = (EditText) findViewById(R.id.TxtPass);

                try {
                    Cursor cursor = helper.ConsulUsuPass(txtusu.getText().toString(), txtpas.getText().toString());

                    if (cursor.getCount() > 0) {
                        Intent i = new Intent(getApplicationContext(),envioMsn.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();
                    }

                    txtusu.setText("");
                    txtpas.setText("");
                    txtusu.findFocus();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

/*


        //LOGUEO DE ALUMNO
        btnIngresarA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText txtusu=(EditText)findViewById(R.id.TxtUsuario);
                EditText txtpas=(EditText)findViewById(R.id.TxtPass);


                try {
                    Cursor cursor = helper.ConsultarUsuPassA(txtusu.getText().toString(), txtpas.getText().toString());
                    if (cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(),recMsn.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(),"usuario y/o contraseña Incorrectos****",Toast.LENGTH_LONG).show();
                    }

                    txtusu.setText("");
                    txtpas.setText("");
                    txtusu.findFocus();

                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });*/
    }
}
