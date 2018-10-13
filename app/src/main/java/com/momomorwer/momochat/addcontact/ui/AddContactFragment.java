package com.momomorwer.momochat.addcontact.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.momomorwer.momochat.R;
import com.momomorwer.momochat.addcontact.AddContactPresenter;
import com.momomorwer.momochat.addcontact.AddContactPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddContactFragment extends DialogFragment implements AddContactView, DialogInterface.OnShowListener {
    @BindView(R.id.editTxtEmail)
    EditText inputEmail;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private AddContactPresenter addContactPresenter;

    public AddContactFragment() {
        this.addContactPresenter = new AddContactPresenterImpl();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.addcontact_message_title)
                .setPositiveButton(R.string.addcontact_message_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(R.string.addcontact_message_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        LayoutInflater i = getActivity().getLayoutInflater();
        View view = i.inflate(R.layout.fragment_add_contact,null);
        ButterKnife.bind(this, view);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(this);

        return dialog;
    }


    @Override
    public void onShow(DialogInterface dialog) {

    }

    @Override
    public void showInput() {

    }

    @Override
    public void hideInput() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void contactAdded() {

    }

    @Override
    public void contactNotAdded() {

    }

}
