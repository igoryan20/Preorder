package ru.apps.igoryan20.gameformanandgirl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewOrderItemActivity extends AppCompatActivity {


    private Button increase, deasese, addOrder;
    private TextView count, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_item);

        Bundle arguments = getIntent().getExtras();
        final String name = arguments.get("Content").toString();

        increase = findViewById(R.id.increase);
        deasese = findViewById(R.id.desise);
        addOrder = findViewById(R.id.addOrder);
        count = findViewById(R.id.count);
        description = findViewById(R.id.description);

        description.setText(name);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt((String) count.getText());
                counter++;
                count.setText(counter + "");
            }
        });

        deasese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt((String) count.getText());
                if(counter > 1){
                    counter--;
                    count.setText(counter + "");
                }
            }
        });

        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Content", name + " x" + count.getText().toString());
                setResult(RESULT_OK, intent);
                Toast.makeText(NewOrderItemActivity.this, "Добавлено в заказ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
