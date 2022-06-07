package com.example.a5102java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        getAdapter(data());
    }

    ArrayList<Main> data() {
        ArrayList<Main> list = new ArrayList<>();
        ArrayList<Photo> photo = new ArrayList<>();
        LinkedList<Story> story = new LinkedList<>();

        list.add(new Main(story));
        for (int i = 0; i < 20; i++) {
            story.add(new Story(R.drawable.ali, "Alisher"));
        }
        for (int i = 0; i < 4; i++) {
            photo.add(new Photo(R.drawable.rasms));
        }
        for (int i = 0; i < 20; i++) {
            list.add(new Main(photo));
        }
        return list;
    }

    void getAdapter(ArrayList<Main> mains) {
        PostsAdapter postsAdapter = new PostsAdapter(this, mains);
        recyclerView.setAdapter(postsAdapter);
    }
}