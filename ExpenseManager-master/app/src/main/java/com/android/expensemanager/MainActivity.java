package com.android.expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ExpenseAdapter adapter;
    ArrayList<Expense> list;
    TextInputLayout exp,amount;
    TextView total;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        exp = findViewById(R.id.expense);
        amount = findViewById(R.id.amount);
        add = findViewById(R.id.addbutton);
        total = findViewById(R.id.totalamount);

        adapter = new ExpenseAdapter(this,list);
        LinearLayoutManager llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalAmount = 0;
                String ex = exp.getEditText().getText().toString();
                int a = Integer.parseInt(amount.getEditText().getText().toString());
                list.add(new Expense(ex,a));
                adapter.notifyDataSetChanged();
                exp.getEditText().setText("");
                amount.getEditText().setText("");

                for(int i = 0;i <list.size();i++){

                    totalAmount += list.get(i).getExpenseAmount();
                    total.setText("Total Rs. "+totalAmount);
                }

            }
        });




    }
}