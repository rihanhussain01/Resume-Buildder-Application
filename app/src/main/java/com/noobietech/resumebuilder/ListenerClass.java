package com.noobietech.resumebuilder;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.noobietech.resumebuilder.activity.ShowDetails;
import com.noobietech.resumebuilder.pojoClass.Models;

import java.io.Serializable;

public class ListenerClass implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    MainActivity mainActivity;
    StringBuffer courses;
    Models models;
    String checkedmf;
    String checkedMU;
    StringBuffer lang;
    RadioButton radioButtonMF , radioButtonmeried;


    ListenerClass(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        models = new Models();
        courses = new StringBuffer();
        lang = new StringBuffer();
        if (mainActivity.binding.checkboxJava.isChecked()) {
            courses.append(mainActivity.binding.checkboxJava.getText().toString());
        }  if(mainActivity.binding.checkboxPython.isChecked()) {
            courses.append(mainActivity.binding.checkboxPython.getText().toString());
        }
        if(mainActivity.binding.checkboxMysql.isChecked()) {
            courses.append(mainActivity.binding.checkboxMysql.getText().toString());
        } if(mainActivity.binding.checkboxOracle.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxOracle.getText().toString());
        } if(mainActivity.binding.checkboxBootStrap.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxBootStrap.getText().toString());
        } if(mainActivity.binding.checkboxAndroid.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxAndroid.getText().toString());
        } if(mainActivity.binding.checkboxAngular.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxAngular.getText().toString());
        } if(mainActivity.binding.checkboxHTML.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxHTML.getText().toString());
        } if(mainActivity.binding.checkboxMERN.isChecked()){
            courses.append(" " +mainActivity.binding.checkboxMERN.getText().toString());
        } if(mainActivity.binding.checkboxPhp.isChecked()) {
            courses.append(" " +mainActivity.binding.checkboxPhp.getText().toString());
        }

        models.setSkills(courses.toString());
//        int selectedIdMF = mainActivity.binding.radioGroupMF.getCheckedRadioButtonId();
//        radioButtonMF = mainActivity.findViewById(selectedIdMF);
//        String mf1 = radioButtonMF.getText().toString();
//        models.setGender(mf1);
//
//        int selectedIdMeried = mainActivity.binding.radioGroupMeritalStatus.getCheckedRadioButtonId();
//        radioButtonmeried = mainActivity.findViewById(selectedIdMeried);
//        String mf = radioButtonmeried.getText().toString();
//        models.setMeritalStatus(mf);




        mainActivity.binding.radioGroupMeritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.unmeried:
                        checkedMU = " Unmeried";
                        break;
                    case R.id.maried :
                        checkedMU = " Meried";
                        break;
                }
            }
        });

        models.setGender(checkedmf);
        models.setMeritalStatus(checkedMU);

        String firstName = mainActivity.binding.firstName.getText().toString();
        models.setFirstName(firstName);

        String lastName = mainActivity.binding.lastName.getText().toString();
        models.setLastName(lastName);

        String email = mainActivity.binding.email.getText().toString();
        models.setEmail(email);

        String fatherName = mainActivity.binding.fatherName.getText().toString();
        models.setFatherName(fatherName);

        String motherName = mainActivity.binding.motherName.getText().toString();
        models.setMotherName(motherName);

        String mobile = mainActivity.binding.mobileNumber.getText().toString();
        models.setMobile(mobile);

        String universityName = mainActivity.binding.collageName.getText().toString();
        models.setUniversityName(universityName);

        String universityAggregates = mainActivity.binding.collageAggregates.getText().toString();
        models.setAggregatesUni(universityAggregates);

        String specialization = mainActivity.binding.specialization.getText().toString();
        models.setSpecialization(specialization);

        String schoolNameXII = mainActivity.binding.schoolNameXII.getText().toString();
        models.setSchoolNameXII(schoolNameXII);

        String schoolNameX = mainActivity.binding.schoolNamex.getText().toString();
        models.setSchoolNameX(schoolNameX);

        String aggregatesX = mainActivity.binding.xAggregates.getText().toString();
        models.setAggregatesX(aggregatesX);

        String aggregatesXII = mainActivity.binding.xiiAggregates.getText().toString();
        models.setAggregateXII(aggregatesXII);

        String boardX = mainActivity.binding.schoolBoardx.getText().toString();
        models.setBoardX(boardX);

        String boardXII = mainActivity.binding.schoolBoardXII.getText().toString();
        models.setBoardXII(boardXII);

        String country = mainActivity.binding.country.getText().toString();
        models.setCountry(country);

        String city = mainActivity.binding.city.getText().toString();
        models.setCity(city);

        String state = mainActivity.binding.state.getText().toString();
        models.setState(state);

        String landmark = mainActivity.binding.landmarkStreet.getText().toString();
        models.setLandmark(landmark);

        String dob  = mainActivity.binding.tvDob.getText().toString();
        models.setDob(dob);

        String pob = mainActivity.binding.pob.getText().toString();
        models.setPoc(pob);

        if(mainActivity.binding.checkboxHindi.isChecked()) {
//            lang.append("Hindi");
        } if(mainActivity.binding.checkboxEnglish.isChecked()){
            lang.append(" English");
        } if(mainActivity.binding.checkboxBengali.isChecked()) {
            lang.append(" Bengali");
        }if (mainActivity.binding.checkboxUrdu.isChecked()) {
            lang.append(" Urdu");
        }if(mainActivity.binding.checkboxPunjabi.isChecked()) {
            lang.append(" Punjabi");
        }  if (mainActivity.binding.checkboxRussia.isChecked()) {
            lang.append(" Russia");
        } if (mainActivity.binding.checkboxGermany.isChecked()) {
            lang.append(" Germany");
        } if (mainActivity.binding.checkboxJapani.isChecked()) {
            lang.append(" Japani");
        }  if(mainActivity.binding.checkboxChinies.isChecked()) {
            lang.append(" Chinies");
        }
        models.setLanguage(lang.toString());


        Intent intent = new Intent(mainActivity , ShowDetails.class);
        intent.putExtra("Models" , models);
        mainActivity.startActivity(intent);
        ;



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.male :
                Log.d("Male" , "Male");
                checkedmf = " Male";

                break;
            case R.id.female :
                Log.d("feMale" , "FeMale");
                checkedmf = " Female";
        }
    }
}
