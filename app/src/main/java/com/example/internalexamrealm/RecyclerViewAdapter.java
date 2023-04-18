package com.example.internalexamrealm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.realm.Realm;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<DataModel> dataModelList;
    Context context;

    Realm realm = Realm.getDefaultInstance();


    public RecyclerViewAdapter(List<DataModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {


        /*int i =1;
        DataModel dataModel;

        for (i = 1; i <= (Integer) realm.where(DataModel.class).max("id"); i++) {
            dataModel = dataModelList.get(position);

        }*/

        Number nid2 = realm.where(DataModel.class).max("id");
        Long newId1 = nid2.longValue();
        Log.d("Recycler", newId1+"");
        Long newId2 = newId1 -1;
        Log.d("Recycler", newId2+"");
        Long newId3 = newId2 -1;
        Log.d("Recycler", newId3+"");
        Long newId4 = newId3 -1;
        Log.d("Recycler", newId4+"");

        DataModel dataModel1 = realm.where(DataModel.class).equalTo("id",newId1).findFirst();

        DataModel dataModel2 = realm.where(DataModel.class).equalTo("id",newId2).findFirst();

        DataModel dataModel3 = realm.where(DataModel.class).equalTo("id",newId3).findFirst();

        DataModel dataModel4 = realm.where(DataModel.class).equalTo("id",newId4).findFirst();

        Long id1 = dataModel4.getId();
        Log.d("Recycler", id1+"");
        Long id2 = dataModel3.getId();
        Log.d("Recycler", id2+"");
        Long id3 = dataModel2.getId();
        Log.d("Recycler", id3+"");
        Long id4 = dataModel1.getId();
        Log.d("Recycler", id4+"");
        //DataModel dataModel = dataModelList.get(position);

        String student1name = dataModel4.getStudentName();
        String student2name = dataModel3.getStudentName();
        String student3name = dataModel2.getStudentName();
        String student4name = dataModel1.getStudentName();

        String attendance1 =  dataModel4.getStudentAttendance();
        String attendance2 =  dataModel3.getStudentAttendance();
        String attendance3 =  dataModel2.getStudentAttendance();
        String attendance4 =  dataModel1.getStudentAttendance();

        /*String student1name = dataModel.getFirstStudentName();
        String student2name = dataModel.getSecondStudentName();
        String student3name = dataModel.getThirdStudentName();
        String student4name = dataModel.getForthStudentName();

        String attendance1 =  dataModel.getFirstStudentAttendance();
        String attendance2 =  dataModel.getSecondStudentAttendance();
        String attendance3 =  dataModel.getThirdStudentAttendance();
        String attendance4 =  dataModel.getForthStudentAttendance();*/



        holder.student1.setText(student1name);
        holder.student2.setText(student2name);
        holder.student3.setText(student3name);
        holder.student4.setText(student4name);

        holder.student1Attend.setText(attendance1);
        holder.student2Attend.setText(attendance2);
        holder.student3Attend.setText(attendance3);
        holder.student4Attend.setText(attendance4);

        /*holder.student1.setText(student1name);
        holder.student2.setText(student2name);
        holder.student3.setText(student3name);
        holder.student4.setText(student4name);

        holder.student1Attend.setText(attendance1);
        holder.student2Attend.setText(attendance2);
        holder.student3Attend.setText(attendance3);
        holder.student4Attend.setText(attendance4);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                /*intent.putExtra("fname", student1name);
                intent.putExtra("sname", student2name);
                intent.putExtra("tname", student3name);
                intent.putExtra("foname", student4name);*/

                intent.putExtra("fattend", attendance1);
                intent.putExtra("sattend", attendance2);
                intent.putExtra("tattend", attendance3);
                intent.putExtra("foattend", attendance4);
                intent.putExtra("id1", id1);
                intent.putExtra("id2", id2);
                intent.putExtra("id3", id3);
                intent.putExtra("id4", id4);


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView student1;
        private final TextView student2;
        private final TextView student3;
        private final TextView student4;
        private final TextView student1Attend;
        private final TextView student2Attend;
        private final TextView student3Attend;
        private final TextView student4Attend;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            student1 = itemView.findViewById(R.id.rv_firstStu);
            student2 = itemView.findViewById(R.id.rv_secondStu);
            student3 = itemView.findViewById(R.id.rv_thirdStu);
            student4 = itemView.findViewById(R.id.rv_forthStu);

            student1Attend = itemView.findViewById(R.id.stu1attend);
            student2Attend = itemView.findViewById(R.id.stu2attend);
            student3Attend = itemView.findViewById(R.id.stu3attend);
            student4Attend = itemView.findViewById(R.id.stu4attend);


        }
    }
}
