package com.noobietech.resumebuilder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.noobietech.resumebuilder.R;
import com.noobietech.resumebuilder.databinding.ActivityShowDetailsBinding;
import com.noobietech.resumebuilder.pojoClass.Models;

public class ShowDetails extends AppCompatActivity {

    ActivityShowDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(ContextCompat.getColor(ShowDetails.this , R.color.grey));
        getWindow().setStatusBarColor(ContextCompat.getColor(ShowDetails.this , R.color.grey));


        Models models = (Models) getIntent().getExtras().get("Models");
        binding.nameSignature.setText(models.getFirstName() + " " + models.getLastName());
        binding.address.setText(models.getCity() + " " + models.getState()+ " " + models.getLandmark());
        binding.mobile.setText(models.getMobile());
        binding.fatherName.setText(models.getFatherName());
        binding.motherName.setText(models.getMotherName());
        binding.email.setText(models.getEmail());
        binding.nationality.setText(models.getCountry());
        binding.sex.setText(models.getGender());
        binding.meritalStatus.setText(models.getMeritalStatus());
        binding.dob.setText(models.getDob());
        binding.poc.setText(models.getPoc());
        binding.universityName.setText(models.getUniversityName());
        binding.specialization.setText(models.getSpecialization());
        binding.aggregates.setText(models.getAggregatesUni());
        binding.schoolName.setText(models.getSchoolNameXII());
        binding.boardName.setText(models.getBoardXII());
        binding.aggregateXII.setText(models.getAggregateXII());
        binding.schoolNameX.setText(models.getSchoolNameX());
        binding.boardNameX.setText(models.getBoardX());
        binding.aggregatsX.setText(models.getAggregatesX());
        binding.languages.setText(models.getLanguage());
        binding.skills.setText(models.getSkills());
        binding.trainingintern.setText(models.getTraining());
        binding.experiences.setText(models.getFresher());


    }
}