package com.proyecto.pm01exameniiiparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore mFirestore;
    EditText description, quantity, period, time;
    Button save, picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirestore = FirebaseFirestore.getInstance();
        description = findViewById(R.id.txtDescripcion);
        quantity = findViewById(R.id.txtCantidad);
        period = findViewById(R.id.txtPeriodo);
        time = findViewById(R.id.spTiempo);

        save = findViewById(R.id.btnGuardar);
        picture = findViewById(R.id.btnFotografia);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }


    private void saveData(){
        String mdescription = description.getText().toString();
        String mquantity = quantity.getText().toString();
        String mperiod = period.getText().toString();
        String mtime = time.getText().toString();

        if(mdescription.equals("") || mquantity.equals("") || mperiod.equals("") || mtime.equals("")){
            Toast.makeText(this, "Se deben llenar todos los campos", Toast.LENGTH_LONG).show();
        }else{
            Map<String, Object> data = new HashMap<>();
            data.put("description", mdescription);
            data.put("quantity", mquantity);
            data.put("period", mperiod);
            data.put("time", mtime);

            mFirestore.collection("Medicines").document().set(data);

            description.setText("");
            quantity.setText("");
            period.setText("");
            time.setText("");
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();
        }
    }
}