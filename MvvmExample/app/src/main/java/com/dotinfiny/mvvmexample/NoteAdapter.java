package com.dotinfiny.mvvmexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<Note> noteList = new ArrayList<>();
    private OnItemClickListner onItemClickListner;

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.title.setText(noteList.get(position).getTitle());
        holder.description.setText(noteList.get(position).getDescription());
        holder.priority.setText("" + noteList.get(position).getPriority());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }


    public void setNotes(List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return noteList.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, priority, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            priority = itemView.findViewById(R.id.priority);
            description = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(onItemClickListner != null && position != RecyclerView.NO_POSITION){
                        onItemClickListner.onItemClick(noteList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListner {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListner clickListener) {
        this.onItemClickListner = clickListener;
    }
}
