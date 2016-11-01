package com.example.mwilson.ieee_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                
                ImageAdapter imageAdapter = (ImageAdapter) gridView.getAdapter();

                Log.i("Id", "" + imageAdapter.getItemId(position));

                //if id above is empty, shift element up
                if (position > 3 && gridView.getAdapter().getItemId(position - 4) == 0) {
                    imageAdapter.switchViews(position, position - 4);
                    imageAdapter.notifyDataSetChanged();

                }
                //shift down
                else if (position < 12 && gridView.getAdapter().getItemId(position + 4) == 0) {
                    imageAdapter.switchViews(position, position + 4);
                    imageAdapter.notifyDataSetChanged();

                }
                //shift left
                else if (position % 4 != 0 && gridView.getAdapter().getItemId(position -1) == 0) {
                    imageAdapter.switchViews(position, position - 1);
                    imageAdapter.notifyDataSetChanged();

                }
                //shift right
                else if (position % 4 != 3 && gridView.getAdapter().getItemId(position + 1) == 0) {
                    imageAdapter.switchViews(position, position + 1);
                    imageAdapter.notifyDataSetChanged();
                }


                //check for win
                if (imageAdapter.isWin()) {
                    Toast.makeText(MainActivity.this, "Congratulations, you won!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //instantiate button
        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageAdapter imageAdapter = (ImageAdapter) gridView.getAdapter();
                imageAdapter.shufflePuzzle();
                imageAdapter.notifyDataSetChanged();
            }
        });


    }
}
