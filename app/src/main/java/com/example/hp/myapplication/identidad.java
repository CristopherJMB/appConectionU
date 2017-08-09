package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class identidad extends AppCompatActivity {

    Button btnIdent, btnIdentA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identidad);

        btnIdent=(Button)findViewById(R.id.btnProf);
        btnIdentA=(Button)findViewById(R.id.btnStudi);

        btnIdent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),registro.class);
                startActivity(i);
            }
        });

        btnIdentA.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),registroA.class);
                startActivity(i);
            }
        });
    }
}
