package com.dotinfiny.mvvmexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
public class NoteAdapter extends ListAdapter<Note, NoteAdapter.ViewHolder> {

    private OnItemClickListner onItemClickListner;

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }

    public static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getPriority() == newItem.getPriority();
        }
    };

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.title.setText(getItem(position).getTitle());
        holder.description.setText(getItem(position).getDescription());
        holder.priority.setText("" + getItem(position).getPriority());
    }

    public Note getNoteAt(int position) {
        return getItem(position);
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
                    if (onItemClickListner != null && position != RecyclerView.NO_POSITION) {
                        onItemClickListner.onItemClick(getItem(position));
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
