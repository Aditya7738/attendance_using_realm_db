package com.example.internalexamrealm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    TextView firstStu, secondStu, thirdStu, forthStu;
    EditText firstStuAttend, secondStuAttend, thirdStuAttend, forthStuAttend;
    Button storeButton1, storeButton2, storeButton3, storeButton4, displayBtn;

    Realm realm;

    DataModel setmodel = new DataModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        firstStu = (TextView) findViewById(R.id.firstStu);
        secondStu = (TextView) findViewById(R.id.secondStu);
        thirdStu = (TextView) findViewById(R.id.thirdStu);
        forthStu = (TextView) findViewById(R.id.forthStu);

        firstStuAttend = (EditText) findViewById(R.id.attend1);
        secondStuAttend = (EditText) findViewById(R.id.attend2);
        thirdStuAttend = (EditText) findViewById(R.id.attend3);
        forthStuAttend = (EditText) findViewById(R.id.attend4);

        storeButton1 = (Button) findViewById(R.id.store1);
        storeButton2 = (Button) findViewById(R.id.store2);
        storeButton3 = (Button) findViewById(R.id.store3);
        storeButton4 = (Button) findViewById(R.id.store4);

        displayBtn = (Button) findViewById(R.id.display_btn);

        storeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstStudentName = firstStu.getText().toString();
                /*String secondStudentName = secondStu.getText().toString();
                String thirdStudentName = thirdStu.getText().toString();
                String forthStudentName = forthStu.getText().toString();


                String secondStuAttendance = secondStuAttend.getText().toString();
                String thirdStuAttendance = thirdStuAttend.getText().toString();
                String forthtStuAttendance = forthStuAttend.getText().toString();*/

                String firstStuAttendance = firstStuAttend.getText().toString();

                //setmodel.setFirstStudentName(firstStudentName);
                //setmodel.setFirstStudentAttendance(firstStuAttendance);


                addStuAttendanceToDatabase(firstStudentName, firstStuAttendance);
                //addtoDatabase(firstStuAttendance, secondStuAttendance, thirdStuAttendance, forthtStuAttendance);
                Toast.makeText(MainActivity.this, "Data stored", Toast.LENGTH_SHORT).show();

            }
        });

        storeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String secondStudentName = secondStu.getText().toString();
                String secondStuAttendance = secondStuAttend.getText().toString();

                //setmodel.setSecondStudentName(secondStudentName);
                //setmodel.setSecondStudentAttendance(secondStuAttendance);
                addStuAttendanceToDatabase(secondStudentName, secondStuAttendance);
                Toast.makeText(MainActivity.this, "Data stored", Toast.LENGTH_SHORT).show();
            }
        });

        storeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thirdStudentName = thirdStu.getText().toString();
                String thirdStuAttendance = thirdStuAttend.getText().toString();

                //setmodel.setThirdStudentName(thirdStudentName);
                //setmodel.setThirdStudentAttendance(thirdStuAttendance);
                addStuAttendanceToDatabase(thirdStudentName, thirdStuAttendance);
                Toast.makeText(MainActivity.this, "Data stored", Toast.LENGTH_SHORT).show();
            }
        });

        storeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String forthStudentName = forthStu.getText().toString();
                String forthStuAttendance = forthStuAttend.getText().toString();

                //setmodel.setForthStudentName(forthStudentName);
                //setmodel.setForthStudentAttendance(forthStuAttendance);
                addStuAttendanceToDatabase(forthStudentName, forthStuAttendance);
                Toast.makeText(MainActivity.this, "Data stored", Toast.LENGTH_SHORT).show();
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
            }
        });





    }

    private void addStuAttendanceToDatabase(String StudentName, String StuAttendance) {
        DataModel dataModel = new DataModel();
        Number id = realm.where(DataModel.class).max("id");

        long nextId;
        if(id == null){
            nextId = 1;
        }else{
            nextId = id.intValue() + 1;
        }

        dataModel.setStudentName(StudentName);
        dataModel.setStudentAttendance(StuAttendance);
        dataModel.setId(nextId);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(dataModel);
            }
        });
    }

    private void addtoDatabase(String firstStuAttendance, String secondStuAttendance, String thirdStuAttendance, String forthtStuAttendance) {
        DataModel dataModel = new DataModel();
        Number id = realm.where(DataModel.class).max("id");

        int nextId;
        if(id == null){
            nextId = 1;
        }else{
            nextId = id.intValue() + 1;
        }

        /*dataModel.setFirstStudentAttendance(firstStuAttendance);
        dataModel.setSecondStudentAttendance(secondStuAttendance);
        dataModel.setThirdStudentAttendance(thirdStuAttendance);
        dataModel.setForthStudentAttendance(forthtStuAttendance);*/

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(dataModel);
            }
        });
    }
}