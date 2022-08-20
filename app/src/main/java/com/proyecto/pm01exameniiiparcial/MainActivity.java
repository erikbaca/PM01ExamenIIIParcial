package com.proyecto.pm01exameniiiparcial;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore mFirestore;
    EditText description, quantity, period, time;
    Button save, picture;
    File mImageFile;
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

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

//        mDialog = new ProgressDialog(CompleteInfoActivity.this);
//        mDialog.setTitle("Espere un momento");
//        mDialog.setMessage("Guardando informacion");
//
//        mOptions = Options.init()
//                .setRequestCode(100)
//                .setCount(1)
//                .setFrontfacing(false)
//                .setPreSelectedUrls(mReturnValues)
//                .setExcludeVideos(true)
//                .setSpanCount(4)
//                .setMode(Options.Mode.All)
//                .setVideoDurationLimitinSeconds(0)
//                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
//                .setPath("/pix/images");

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
//
//    private void saveImage() {
//
//        mDialog.show();
//        mImageProvider.save(MainActivity.this, mImageFile).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//                if (task.isSuccessful()) {
//                    mImageProvider.getDownloadUri().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                        @Override
//                        public void onSuccess(Uri uri) {
//                            String url = uri.toString();
//                            updateUserInfo(url);
//                        }
//                    });
//                } else {
//                    //DETENER EL DIALOG
//                    mDialog.dismiss();
//                    Toast.makeText(MainActivity.this, "No se pudo almacenar la imagen", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//    // ------------------------------------------------------------------------------------------------

//    // MOSTRARA LAS IMAGENES DE LA GALERIA =========================================================
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
//            mReturnValues = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
//            mImageFile = new File(mReturnValues.get(0));
//            mCircleImagePhoto.setImageBitmap(BitmapFactory.decodeFile(mImageFile.getAbsolutePath()));
//        }
//    }
//
//    // Metodo para los permisos a uso de la camara y accesar a la galeria
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode == PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS) {
//            // If request is cancelled, the result arrays are empty.
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Pix.start(MainActivity.this, mOptions);
//            } else {
//                Toast.makeText(MainActivity.this, "Por favor concede los permisos para accesar a la camara!!", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}