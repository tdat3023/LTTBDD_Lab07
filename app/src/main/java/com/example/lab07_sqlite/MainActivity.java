package com.example.lab07_sqlite_nguyenhoanganh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> listUser;
    private ListView listView;
    private Button btnAdd;
    private Button btnDelete;
    private TextView txtAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

//        //delete user
//        Intent intentReceived = getIntent();
//        Bundle data = intentReceived.getExtras();
//        int userId = -1;
//
//        if(data != null){
//            userId =  data.getInt("userId");
//
//        }else{
//            Toast.makeText(MainActivity.this, "err", Toast.LENGTH_LONG).show();
//        }



        //add user
        btnAdd = (Button) findViewById(R.id.button);
        btnDelete = (Button) findViewById(R.id.button2);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //get value in textAdd
                txtAdd = findViewById(R.id.editTextTextPersonName);
                String value =  txtAdd.getText().toString();
                if(value.length()!=0){
                    db.addContact(new User(value));
                    txtAdd.setText("");
                    Toast.makeText( MainActivity.this,"Add Succesfully!" , Toast.LENGTH_LONG).show();
//                    //render
                    UserAdaper adapter = new UserAdaper(MainActivity.this
                            , R.layout.activity_item_list,  renderData(db));
                    listView.setAdapter(adapter);
                }
                else{
                    Toast.makeText( MainActivity.this,"Add faild!" , Toast.LENGTH_LONG).show();
                }
            }
        });


        listView = (ListView) findViewById(R.id.mobile_list);
        UserAdaper adapter = new UserAdaper(this, R.layout.activity_item_list,  renderData(db));
        listView.setAdapter(adapter);
    }

    //render list user into array
    public List<User> renderData(DatabaseHandler db){
        // Reading all contacts
        List<User> list = new ArrayList<User>();
        List<User> contacts = db.getAllContacts();
        for (User cn : contacts) {
            list.add(cn);
        }

        return list;
    }
}