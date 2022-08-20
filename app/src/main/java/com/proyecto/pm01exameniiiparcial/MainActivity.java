package com.proyecto.pm01exameniiiparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.fxn.pix.Options;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore mFirestore;
    EditText description, quantity, period, time;
    Button save, picture;
    Options mOptions;

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

        mOptions = Options.init()
                .setRequestCode(100)                                           //Request code for activity results
                .setCount(1)                                                   //Number of images to restict selection count
                .setFrontfacing(false)                                         //Front Facing camera on start
//                .setPreSelectedUrls()                            //Pre selected Image Urls
                .setExcludeVideos(true)
                .setSpanCount(4)                                               //Span count for gallery min 1 & max 5
                .setMode(Options.Mode.All)                                     //Option to select only pictures or videos or both
                .setVideoDurationLimitinSeconds(0)                            //Duration for video recording
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                .setPath("/pix/images");

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