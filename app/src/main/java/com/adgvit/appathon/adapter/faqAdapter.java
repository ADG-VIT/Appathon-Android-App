package com.adgvit.appathon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.appathon.R;
import com.adgvit.appathon.model.faqModel;


import java.util.List;

public class faqAdapter extends RecyclerView.Adapter<faqAdapter.MyViewHolder> {
    List<faqModel> list1;
    Context mcontext;

    public faqAdapter(List<faqModel> list1, Context mcontext) {
        this.list1 = list1;
        this.mcontext = mcontext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question,answer;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.faqQuestion);
            answer = itemView.findViewById(R.id.faqAnswer);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.faq_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        faqModel item = list1.get(position);
        holder.question.setText("Q. "+item.getQuestion());
        holder.answer.setText(item.getAns());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
    public void filterList(List<faqModel> searchList){
        list1=searchList;
        notifyDataSetChanged();
    }


}
