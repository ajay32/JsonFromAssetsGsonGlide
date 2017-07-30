package ajaymehta.jsonfromassetsgsonglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import ajaymehta.jsonfromassetsgsonglide.adapter.CustomAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView people = (ListView)findViewById(R.id.myList);

        CustomAdapter adapter = new CustomAdapter(getLayoutInflater(),this);

        people.setAdapter(adapter);
    }
    
}
