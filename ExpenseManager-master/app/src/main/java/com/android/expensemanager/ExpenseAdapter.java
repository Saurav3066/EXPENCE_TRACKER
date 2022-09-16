package com.android.expensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Expense> list;

    public ExpenseAdapter(Context context, ArrayList<Expense> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ViewHolder holder, int position) {
        holder.exp.setText(list.get(position).getExpenseName());
        holder.amount.setText(Integer.toString(list.get(position).getExpenseAmount()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView exp,amount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exp = itemView.findViewById(R.id.expensedesign);
            amount = itemView.findViewById(R.id.amountdesign);


        }
    }
}
