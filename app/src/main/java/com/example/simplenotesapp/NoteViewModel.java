package com.example.simplenotesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
    }

    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public List<Note> getAllNotes() {
        return repository.getAllNotes();
    }
}
