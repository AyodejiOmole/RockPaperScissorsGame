package com.example.rockpaperscissors.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rockpaperscissors.R;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList date, level_played, you_played, computer_played, winner;

    public MyAdapter(Context context, ArrayList date, ArrayList level_played, ArrayList you_played, ArrayList computer_played, ArrayList winner) {
        this.context = context;
        this.date = date;
        this.level_played = level_played;
        this.you_played = you_played;
        this.computer_played = computer_played;
        this.winner = winner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.date.setText(String.valueOf(date.get(position)));
        holder.level_played.setText(String.valueOf(level_played.get(position)));
        holder.you_played.setText(String.valueOf(you_played.get(position)));
        holder.computer_played.setText(String.valueOf(computer_played.get(position)));
        holder.winner.setText(String.valueOf(winner.get(position)));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, level_played, you_played, computer_played, winner;
        
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.datePlayed);
            level_played = itemView.findViewById(R.id.levelPlayed);
            you_played = itemView.findViewById(R.id.youPlayed);
            computer_played = itemView.findViewById(R.id.computerPlayed);
            winner = itemView.findViewById(R.id.winner);
        }
    }
}
