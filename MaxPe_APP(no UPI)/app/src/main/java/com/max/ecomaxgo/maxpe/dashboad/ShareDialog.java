package com.max.ecomaxgo.maxpe.dashboad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.max.ecomaxgo.maxpe.R;

import java.util.ArrayList;
import java.util.List;

public class ShareDialog extends AppCompatActivity {
    ListView rel_relatedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_dialog);

        rel_relatedList =findViewById(R.id.rel_relatedList);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("New Service");
        your_array_list.add("Loan");
        your_array_list.add("UPI");
        your_array_list.add("Daily bills");
        your_array_list.add("Bill sharing ");
        your_array_list.add("Security ");
        your_array_list.add("UI/ UX designs ");
        your_array_list.add("Others");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        rel_relatedList.setAdapter(arrayAdapter);
    }
}