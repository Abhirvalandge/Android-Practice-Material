package com.abhirva.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.abhirva.recyclerview.adapter.RecyclerViewAdapter;
import com.abhirva.recyclerview.data.MyDbHandler;
import com.abhirva.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // RecyclerViewAdapter
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView Initialization
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        // Creating a contact object for the db
        Contact abhirva = new Contact();
        abhirva.setPhoneNumber("9131994504");
        abhirva.setName("Abhirva");

        //Adding a contact to the db
        db.addContact(abhirva);

        contactArrayList = new ArrayList<>();

        // Get all contacts
        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList){
            Log.d("dbabhi", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n" +
                    "Phone Number: " + contact.getPhoneNumber() +  "\n");

            contactArrayList.add(contact);
        }

        // Use your RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbabhi", "Bro you have " + db.getCount() + " contacts in your database");
    }



}
