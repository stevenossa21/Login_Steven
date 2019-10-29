package com.example.loginjhon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.nombre);
        password = (EditText)findViewById(R.id.password);
    }
    public void entrar(View obj){
        Intent ir = new Intent(MainActivity.this, Home.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle datos = new Bundle();
        String e = nombre.getText().toString();
        String p = password.getText().toString();
        boolean em = validarEmail(e);

        if(nombre.length() > 0 && password.length() > 0 && em){
            datos.putString("email", e);
            datos.putString("password", p);
            ir.putExtras(datos);
            startActivity(ir);
        }else{

            if(nombre.length() == 0 && password.length() == 0){

                Toast.makeText(this, "Los campos estan vacios",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Email no valido",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
