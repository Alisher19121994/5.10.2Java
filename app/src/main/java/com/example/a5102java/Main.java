package com.example.a5102java;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    ArrayList<Photo> photos = null;
    LinkedList<Story> stories = new LinkedList<>();

    public Main(LinkedList<Story> stories) {
        this.stories = stories;
    }

    public Main(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
