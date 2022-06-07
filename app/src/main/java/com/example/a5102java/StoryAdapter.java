package com.example.a5102java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.LinkedList;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    LinkedList<Story> list;

    public StoryAdapter(Context context, LinkedList<Story> photos) {
        this.context = context;
        this.list = photos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_view, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story story = list.get(position);
        if (holder instanceof StoryViewHolder) {
            ((StoryViewHolder) holder).imageView.setImageResource(story.profile);
            ((StoryViewHolder) holder).textView.setText(story.fullname);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StoryViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView imageView;
        TextView textView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.story_profile_id);
            textView = itemView.findViewById(R.id.story_fullname_id);
        }
    }
}

