package com.noobietech.resumebuilder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.noobietech.resumebuilder.databinding.ActivityMainBinding;
import com.noobietech.resumebuilder.databinding.ImageDailogBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    ActivityMainBinding binding;
    DatePickerDialog.OnDateSetListener setListener;
    CheckBox java  , php , mern , android , html , css , bootstrap , python , mysql , oracledb ;
    RadioButton male , female;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this , R.color.grey));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MainActivity.this , R.color.grey));



//        java = findViewById(R.id.checkboxJava);
//        php = findViewById(R.id.checkboxPhp);
//        mern = findViewById(R.id.checkboxMERN);
//        android = findViewById(R.id.checkboxAndroid);
//        html = findViewById(R.id.checkboxHTML);
//        css = findViewById(R.id.checkboxCSS);
//        bootstrap = findViewById(R.id.checkboxBootStrap);
//        python = findViewById(R.id.checkboxPython);
//        mysql = findViewById(R.id.checkboxMysql);
//        oracledb = findViewById(R.id.checkboxOracle);




        ListenerClass listenerClass = new ListenerClass(MainActivity.this);
        binding.radioGroupMF.setOnCheckedChangeListener(listenerClass);
        binding.buildResumeButton.setOnClickListener(listenerClass);

        Calendar calendar = Calendar.getInstance();

        final int year= calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get((Calendar.DAY_OF_MONTH));

        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseProfilePicture();
            }
        });






//        binding.tvDob.setOnClickListener(V -> {
//            DatePickerDialog datePickerDialog = new DatePickerDialog(
//                    MainActivity.this , android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
//                    setListener , year , month , day
//            );
//            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            datePickerDialog.show();
//        });
//
//        setListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                month = month+1;
//                String date = day+"/"+month+"/"+year;
//                binding.tvDob.setText(date);
//            }
//        };

        binding.tvDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = "" + day + "/" + month + "/" + year;
                        binding.tvDob.setText(date);
                    }
                },year , month , day
                );
                datePickerDialog.show();
            }
        });

    }

    private void chooseProfilePicture() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dailogView = inflater.inflate( R.layout.image_dailog, null);
        builder.setCancelable(false);
        builder.setView(dailogView);

        AlertDialog alertDialogProfilePicture = builder.create();
        alertDialogProfilePicture.show();

        ImageView imgcam = dailogView.findViewById(R.id.imgcamera);
        ImageView imggallery = dailogView.findViewById(R.id.imggallery);

        imggallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent , 1);
                alertDialogProfilePicture.cancel();
            }
        });

        imgcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null ) {
                    startActivityForResult(intent , 2);
                    alertDialogProfilePicture.cancel();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1 :
                if(resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    binding.profileImage.setImageURI(uri);
                }
                break;

            case 2 :
                if(resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    binding.profileImage.setImageURI(uri);

//                    Bundle bundle = data.getExtras();
//                   Bitmap bitmap = (Bitmap) bundle.get("data");
//                   binding.profileImage.setImageBitmap(bitmap);
                }
                break;
        }
    }
}