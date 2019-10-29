package com.example.loginjhon;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private TextView email;
    private TextView password;
    private TextView contador;
    private int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        email = findViewById(R.id.temail);
        password = findViewById(R.id.password);
        Bundle datos = getIntent().getExtras();
        email.setText(datos.getString("email"));
        password.setText(datos.getString("password"));


        contador = findViewById(R.id.textView);

        if(savedInstanceState != null){
            cont = savedInstanceState.getInt("count");
            contador.setText(String.valueOf(cont));

        }
    }
    public void volver(View obj){
        Toast.makeText(this, "Cerrando sesión",Toast.LENGTH_SHORT).show();
        Intent ir = new Intent(Home.this, MainActivity.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);

    }

    public void increment(View obj){
        cont++;
        contador.setText(String.valueOf(cont));

    }

    public void decrement(View obj){

        cont--;
        contador.setText(String.valueOf(cont));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", cont);
    }


}
