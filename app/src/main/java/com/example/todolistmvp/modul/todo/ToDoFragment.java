package com.example.todolistmvp.modul.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.data.model.Task;
import com.example.todolistmvp.modul.add.AddActivity;
import com.example.todolistmvp.modul.login.LoginActivity;
import com.example.todolistmvp.utils.Database;
import com.example.todolistmvp.utils.RecyclerViewAdapterTodolist;

import java.util.ArrayList;

public class ToDoFragment extends BaseFragment<ToDoActivity, ToDoContract.Presenter> implements ToDoContract.View {
    private Button btnAdd;
    private Button btnClear;
    private Button btnLogout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database database;
    private ArrayList<Task> taskList;

    public ToDoFragment() {
        this.database = Database.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_todolist, container, false);
        mPresenter = new ToDoPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewTodolist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        btnAdd = fragmentView.findViewById(R.id.btnAdd);
        btnClear = fragmentView.findViewById(R.id.btnClear);
        btnLogout = fragmentView.findViewById(R.id.btnLogout);

        taskList = database.getTasks();
        mAdapter = new RecyclerViewAdapterTodolist(taskList);
        mRecyclerView.setAdapter(mAdapter);

        ((RecyclerViewAdapterTodolist) mAdapter).setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                mPresenter.editList(taskList.get(position));
            }
        });

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

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performLogout();
            }
        });

        setTitle("TO DO LIST");

        return fragmentView;
    }

    @Override
    public void setPresenter(ToDoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToAdd() {
        Intent intent = new Intent(activity, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void emptyList() {
        database.deleteAll();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEditBox(final Task uneditedItem) {
        final Dialog dialog = new Dialog(activity);
        dialog.setTitle("EDIT DIALOG");
        dialog.setContentView(R.layout.dialog_edit);

        TextView txtMessage = (TextView) dialog.findViewById(R.id.textMessage);
        txtMessage.setText("ITEM DETAIL");
        txtMessage.setTextColor(Color.parseColor("#000000"));

        final EditText titleEdit = (EditText) dialog.findViewById(R.id.titleEdit);
        final EditText descriptionEdit = (EditText) dialog.findViewById(R.id.descriptionEdit);
        titleEdit.setText(uneditedItem.getTitle());
        descriptionEdit.setText(uneditedItem.getDescription());
        Button btnEdit = (Button) dialog.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.editTask(uneditedItem.getId(), titleEdit.getText().toString(), descriptionEdit.getText().toString());
                mAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        Button btnDelete = (Button) dialog.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                mPresenter.deleteItem(uneditedItem.getId());
            }
        });

        dialog.show();
    }

    @Override
    public void showDeleteDialog(final int position) {
        final int index = position;

        new AlertDialog.Builder(activity)
                .setIcon(android.R.drawable.ic_delete)
                .setTitle("DELETE ITEM")
                .setMessage("Are you sure you want to delete this item ?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        database.deleteTask(index);
                        mAdapter.notifyDataSetChanged();
                    }
                })
                .show();
    }

    @Override
    public void redirectToLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
