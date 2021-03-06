package com.abhirva.sqlitedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abhirva.sqlitedemo.data.MyDbHandler;
import com.abhirva.sqlitedemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        // Creating a contact object for the db
        Contact abhirva = new Contact();
        abhirva.setPhoneNumber("9131994504");
        abhirva.setName("Abhirva");

        //Adding a contact to the db
        db.addContact(abhirva);

        // Creating a contact object for the db
        Contact sourabh = new Contact();
        sourabh.setPhoneNumber("8770994504");
        sourabh.setName("Sourabh");

        //Adding a contact to the db
        db.addContact(sourabh);

        // Creating a contact object for the db
        Contact aditya = new Contact();
        aditya.setPhoneNumber("9239194504");
        aditya.setName("Aditya");

        //Adding a contact to the db
        db.addContact(aditya);
        Log.d("dbabhi", "Contact data of abhirva, sourabh & aditya are successfully added to the db");

        //Updating Aditya contact
        aditya.setId(3);
        aditya.setName("Changed Aditya Gour");
        aditya.setPhoneNumber("0000000000");
        int affectedRows = db.updateContact(aditya);

        Log.d("dbabhi", "No. of affected rows are: " + affectedRows);
//        db.deleteContactById(1);
//        db.deleteContactById(5);
//        db.deleteContactById(12);
//
//        db.deleteContact(aditya);

        // Showing contact list in a aap
        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);

        // Get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for (Contact contact: allContacts){
            Log.d("dbabhi", "\nId: " + contact.getId() + "\n" +
                                     "Name: " + contact.getName() + "\n" +
                                     "Phone Number: " + contact.getPhoneNumber() +  "\n");
            contacts.add(contact.getName() + " (" + contact.getPhoneNumber() + ")");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);
        Log.d("dbabhi", "Bro you have " + db.getCount() + " contacts in your database");
    }



}
