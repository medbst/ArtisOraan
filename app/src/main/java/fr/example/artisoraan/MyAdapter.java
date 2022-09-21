package fr.example.artisoraan;

import android.content.Context;
import android.text.method.TextKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   Context context ;
   ArrayList<User> list ;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position) ;
        holder.name.setText(user.getNom());
        holder.number.setText(user.getNum());
        holder.surname.setText(user.getPrenom());
        holder.job.setText(user.getProfession());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name , surname ,number  , job ;
     public MyViewHolder(@NonNull View itemView) {
         super(itemView);
         name=itemView.findViewById(R.id.tvnom) ;

         number=itemView.findViewById(R.id.tvnum) ;
         surname=itemView.findViewById(R.id.tvprenom) ;
         job=itemView.findViewById(R.id.tvtype) ;

     }
 }
}

