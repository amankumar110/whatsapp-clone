package in.amankumar110.whatsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView messageList;

    Button addButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.parseColor("#128C7E"));

        messageList = findViewById(R.id.messagesRecyclerView);
        addButton = findViewById(R.id.addButton);

        addButton.setBackgroundTintList(null);
        addButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ContactsActivity.class)));


        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Professor","Hello!!","9:00",R.drawable.ic_launcher_background));
        messages.add(new Message("dorthy","hey sir!!","10:01",R.drawable.sonic));
        messages.add(new Message("Professor","Hello!!","9:00",R.drawable.ic_launcher_background));
        messages.add(new Message("dorthy","hey sir!!","10:01",R.drawable.sonic));
        messages.add(new Message("Professor","Hello!!","9:00",R.drawable.ic_launcher_background));
        messages.add(new Message("dorthy","hey sir!!","10:01",R.drawable.sonic));
        messages.add(new Message("Professor","Hello!!","9:00",R.drawable.ic_launcher_background));
        messages.add(new Message("dorthy","hey sir!!","10:01",R.drawable.sonic));
        messages.add(new Message("Professor","Hello!!","9:00",R.drawable.ic_launcher_background));
        messages.add(new Message("dorthy","hey sir!!","10:01",R.drawable.sonic));

        MessageAdapter messageAdapter = new MessageAdapter(messages);

        messageList.setAdapter(messageAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messageList.setLayoutManager(layoutManager);

    }
}