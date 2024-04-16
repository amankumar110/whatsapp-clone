package in.amankumar110.whatsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    RecyclerView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getWindow().setStatusBarColor(Color.parseColor("#128C7E"));

        contactList = findViewById(R.id.contacts);

        List contactsAndFeatures = new ArrayList();
        contactsAndFeatures.add(new Feature("New group",R.drawable.group));
        contactsAndFeatures.add(new Feature("New contact",R.drawable.group));
        contactsAndFeatures.add(new Feature("New community",R.drawable.group));
        contactsAndFeatures.add(new Contact(R.drawable.sonic,"soni","I am available 24X7 for work"));
        contactsAndFeatures.add(new Contact(R.drawable.sonic,"soni","I am available 24X7 for work"));
        contactsAndFeatures.add(new Contact(R.drawable.sonic,"soni","I am available 24X7 for work"));
        contactsAndFeatures.add(new Contact(R.drawable.sonic,"soni","I am available 24X7 for work"));
        contactsAndFeatures.add(new Contact(R.drawable.sonic,"soni","I am available 24X7 for work"));
        contactsAndFeatures.add(new Feature("Share invite link",R.drawable.share));
        contactsAndFeatures.add(new Feature("Get help",R.drawable.question));

        ContactAdapter contactAdapter = new ContactAdapter(contactsAndFeatures, (v,position) -> {

            if(position==contactsAndFeatures.size()-2) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT,"MySUB");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        contactList.setAdapter(contactAdapter);
        contactList.setLayoutManager(new LinearLayoutManager(this));
    }
}