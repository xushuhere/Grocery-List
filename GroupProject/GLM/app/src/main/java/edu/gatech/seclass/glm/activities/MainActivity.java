package edu.gatech.seclass.glm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import edu.gatech.seclass.glm.R;

public class MainActivity extends AppCompatActivity {

    private Button mJanetButton;
    private Button mBradButton;
    private RelativeLayout mActivityMainRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJanetButton = (Button) findViewById(R.id.btn_janet);
        mBradButton = (Button) findViewById(R.id.btn_brad);
        mActivityMainRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        mJanetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllGroceryListsActivity.class);
                intent.putExtra("user", "Janet");
                startActivity(intent);
            }
        });

        mBradButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllGroceryListsActivity.class);
                intent.putExtra("user", "Brad");
                startActivity(intent);
            }
        });
    }
}
