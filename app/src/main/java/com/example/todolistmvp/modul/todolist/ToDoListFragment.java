package com.example.todolistmvp.modul.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.modul.add.AddActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ToDoListFragment extends BaseFragment<ToDoListActivity, ToDoListContract.Presenter> implements ToDoListContract.View {
    ListView itemListView;
    Button btnAdd;
    Button btnClear;
    String[] toDoArray = {"Tidur Malem", "Tidur Siang", "Nugas", "Ngebucin"};
    ArrayList<String> toDoArrayList;
    ArrayList<String> returnedList;
    ArrayAdapter adapter;

    public ToDoListFragment(ArrayList<String> returnedList) {
        this.returnedList = returnedList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_todolist, container, false);
        mPresenter = new ToDoListPresenter(this);
        mPresenter.start();

        itemListView = fragmentView.findViewById(R.id.itemListView);
        btnAdd = fragmentView.findViewById(R.id.btnAdd);
        btnClear = fragmentView.findViewById(R.id.btnClear);

        toDoArrayList = new ArrayList<>(Arrays.asList(toDoArray));
        adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, toDoArrayList);
        itemListView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addItem();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clearList();
            }
        });

        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.editList(toDoArrayList.get(position), position);
            }
        });

        itemListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.deleteItem(position);
                return true;
            }
        });

        setTitle("ToDoList");

        return fragmentView;
    }

    @Override
    public void setPresenter(ToDoListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToAdd() {
        Intent intent = new Intent(activity, AddActivity.class);
        intent.putStringArrayListExtra("todo", toDoArrayList);
        startActivity(intent);
    }

    @Override
    public void emptyList() {
        toDoArrayList.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEditBox(String uneditedItem, final int index) {
        final Dialog dialog = new Dialog(activity);
        dialog.setTitle("EDIT DATA");
        dialog.setContentView(R.layout.dialog_edit);

        TextView txtMessage = (TextView) dialog.findViewById(R.id.textMessage);
        txtMessage.setText("EDIT DATA");
        txtMessage.setTextColor(Color.parseColor("#000000"));

        final EditText editText = (EditText) dialog.findViewById(R.id.textInput);
        editText.setText(uneditedItem);
        Button bt = (Button) dialog.findViewById(R.id.btnEdit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDoArrayList.set(index, editText.getText().toString());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void showDeleteDialog(int position) {
        final int index = position;

        new AlertDialog.Builder(activity)
                .setIcon(android.R.drawable.ic_delete)
                .setTitle("DELETE ITEM")
                .setMessage("Are you sure you want to delete this item ?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toDoArrayList.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                })
                .show();
    }
}
