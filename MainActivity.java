package com.example.simplenotesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private EditText editTextTitle, editTextContent;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextContent = findViewById(R.id.edit_text_content);
        Button buttonSave = findViewById(R.id.button_save);
        recyclerView = findViewById(R.id.recycler_view);

        noteViewModel = new NoteViewModel(getApplication());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();
                if (!title.isEmpty() && !content.isEmpty()) {
                    Note note = new Note();
                    note.setTitle(title);
                    note.setContent(content);
                    noteViewModel.insert(note);
                    displayNotes();
                }
            }
        });

        displayNotes();
    }

    private void displayNotes() {
        List<Note> notes = noteViewModel.getAllNotes();
        NoteAdapter adapter = new NoteAdapter(notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
