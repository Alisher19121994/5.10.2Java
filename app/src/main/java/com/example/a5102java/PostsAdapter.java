package com.example.a5102java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.LinkedList;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Main> list;

    public PostsAdapter(Context context, ArrayList<Main> list) {
        this.context = context;
        this.list = list;
    }

    private final int STORY = 0;
    private final int POST = 1;

    @Override
    public int getItemViewType(int position) {
        Main main = list.get(position);
        if (main.stories.size() > 0) {
            return STORY;
        }
        return POST;
    }

    void storyAdapter(LinkedList<Story> stories, RecyclerView recyclerView) {
        StoryAdapter storyAdapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(storyAdapter);
    }

    void photoAdapter(ArrayList<Photo> photos, RecyclerView recyclerView) {
        PhotoAdapter photoAdapter = new PhotoAdapter(context, photos);
        recyclerView.setAdapter(photoAdapter);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == STORY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story, parent, false);
            return new StoryViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Main main = list.get(position);

        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            storyAdapter(main.stories, recyclerView);
        }

        if (holder instanceof PhotoViewHolder) {
            RecyclerView recyclerView = ((PhotoViewHolder) holder).recyclerView;
            photoAdapter(main.photos, recyclerView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StoryViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView = itemView.findViewById(R.id.story_recyclerview);

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView = itemView.findViewById(R.id.post_recyclerview);

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        }
    }
}
