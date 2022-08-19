package com.proyecto.pm01exameniiiparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirestore = FirebaseFirestore.getInstance();

        saveData();

    }


    private void saveData(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Josue");
        mFirestore.collection("User").document().set(map);
    }
}