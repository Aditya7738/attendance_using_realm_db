package com.example.internalexamrealm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class UpdateActivity extends AppCompatActivity {


    //TextView firstStu, secondStu, thirdStu, forthStu;
    EditText firstStuAttend, secondStuAttend, thirdStuAttend, forthStuAttend;
    Button updateButton1, updateButton2, updateButton3, updateButton4;
    Button deleteButton1, deleteButton2, deleteButton3, deleteButton4;

    Realm realm;

    DataModel usetmodel = new DataModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        realm = Realm.getDefaultInstance();
        /*firstStu = (TextView) findViewById(R.id.ufirstStu);
        secondStu = (TextView) findViewById(R.id.usecondStu);
        thirdStu = (TextView) findViewById(R.id.uthirdStu);
        forthStu = (TextView) findViewById(R.id.uforthStu);*/

        firstStuAttend = (EditText) findViewById(R.id.uattend1);
        secondStuAttend = (EditText) findViewById(R.id.uattend2);
        thirdStuAttend = (EditText) findViewById(R.id.uattend3);
        forthStuAttend = (EditText) findViewById(R.id.uattend4);

        updateButton1 = (Button) findViewById(R.id.update1);
        updateButton2 = (Button) findViewById(R.id.update2);
        updateButton3 = (Button) findViewById(R.id.update3);
        updateButton4 = (Button) findViewById(R.id.update4);

        deleteButton1 = (Button) findViewById(R.id.delete_btn1);
        deleteButton2 = (Button) findViewById(R.id.delete_btn2);
        deleteButton3 = (Button) findViewById(R.id.delete_btn3);
        deleteButton4 = (Button) findViewById(R.id.delete_btn4);

        Intent intent = getIntent();
        /*firstStu.setText(intent.getStringExtra("student1name"));
        secondStu.setText(intent.getStringExtra("student2name"));
        thirdStu.setText(intent.getStringExtra("student3name"));
        forthStu.setText(intent.getStringExtra("student4name"));*/

        firstStuAttend.setText(intent.getStringExtra("fattend"));
        secondStuAttend.setText(intent.getStringExtra("sattend"));
        thirdStuAttend.setText(intent.getStringExtra("tattend"));
        forthStuAttend.setText(intent.getStringExtra("foattend"));

        updateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String newfStudentName = firstStu.getText().toString();
                String newfStuAttendance = firstStuAttend.getText().toString();
                Long id1 = intent.getLongExtra("id1", 0);

                //usetmodel.setFirstStudentName(newfStudentName);
                //usetmodel.setFirstStudentAttendance(newfStuAttendance);

                updateStuAttendanceToDatabase(id1, newfStuAttendance);
                Toast.makeText(UpdateActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        updateButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String newsStudentName = secondStu.getText().toString();
                String newsStuAttendance = secondStuAttend.getText().toString();
                Long id2 = intent.getLongExtra("id2", 0);

                //usetmodel.setFirstStudentName(newsStudentName);
                //usetmodel.setFirstStudentAttendance(newsStuAttendance);

                updateStuAttendanceToDatabase(id2, newsStuAttendance);
                Toast.makeText(UpdateActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        updateButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String newtStudentName = thirdStu.getText().toString();
                String newtStuAttendance = thirdStuAttend.getText().toString();
                Long id3 = intent.getLongExtra("id3", 0);

                //usetmodel.setFirstStudentName(newtStudentName);
                //usetmodel.setFirstStudentAttendance(newtStuAttendance);

                updateStuAttendanceToDatabase(id3, newtStuAttendance);
                Toast.makeText(UpdateActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        updateButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String newfoStudentName = forthStu.getText().toString();
                String newfoStuAttendance = forthStuAttend.getText().toString();
                Long id4 = intent.getLongExtra("id4", 0);

                //usetmodel.setFirstStudentName(newfoStudentName);
                //usetmodel.setFirstStudentAttendance(newfoStuAttendance);

                updateStuAttendanceToDatabase(id4, newfoStuAttendance);
                Toast.makeText(UpdateActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        deleteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long did1 = intent.getLongExtra("id1", 0);

                deleteFromDatabase(did1);
                Toast.makeText(UpdateActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        deleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long did2 = intent.getLongExtra("id2", 0);

                deleteFromDatabase(did2);
                Toast.makeText(UpdateActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));

            }
        });

        deleteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long did3 = intent.getLongExtra("id3", 0);

                deleteFromDatabase(did3);
                Toast.makeText(UpdateActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

        deleteButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long did4 = intent.getLongExtra("id4", 0);

                deleteFromDatabase(did4);
                Toast.makeText(UpdateActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, DisplayActivity.class));
            }
        });

    }

    private void deleteFromDatabase(Long did) {
        DataModel deleteModel = realm.where(DataModel.class).equalTo("id",did).findFirst();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                deleteModel.deleteFromRealm();
            }
        });
    }

    private void updateStuAttendanceToDatabase(Long id, String newfStuAttendance) {
        DataModel updatemodel = realm.where(DataModel.class).equalTo("id",id).findFirst();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (updatemodel != null) {
                    updatemodel.setStudentAttendance(newfStuAttendance);
                }
                realm.copyToRealmOrUpdate(updatemodel);
            }
        });
    }
}