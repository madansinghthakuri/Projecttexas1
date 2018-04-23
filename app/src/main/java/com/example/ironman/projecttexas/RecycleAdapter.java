package com.example.ironman.projecttexas;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ironman.projecttexas.model.UserListDto;

import java.util.List;



public class RecycleAdapter  extends RecyclerView.Adapter<RecycleAdapter.myViewHolder>{
    private List<UserListDto> userListDtos;
    public RecycleAdapter(List<UserListDto> userListDtos){
        this.userListDtos = userListDtos;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_iteam,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.fullName.setText(userListDtos.get(position).getFirstName());
        holder.fmail.setText(userListDtos.get(position).getEmail());
        holder.userName.setText(userListDtos.get(position).getUsername());
        holder.mobileNo.setText(userListDtos.get(position).getMobileNumber());

    }

    @Override
    public int getItemCount() {
        return userListDtos.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView fullName,fmail,userName,mobileNo;
        public myViewHolder(View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullname);
            fmail = itemView.findViewById(R.id.email);
            userName = itemView.findViewById(R.id.username);
            mobileNo = itemView.findViewById(R.id.mobileno);


        }
    }
}
