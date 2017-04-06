package com.example.nehal.frag_example;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Nehal on 4/3/2017.
 */

public class SecondFragment extends android.support.v4.app.Fragment implements View.OnClickListener
{

    private Button send_content;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText message;

    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance(int page, String title)
    {
        SecondFragment fragmentSecond = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_second, container, false );
        send_content = (Button)view.findViewById(R.id.send);
        name = (EditText)view.findViewById(R.id.name);
        phone = (EditText)view.findViewById(R.id.number);
        email = (EditText)view.findViewById(R.id.email);
        message = (EditText)view.findViewById(R.id.message);



        send_content.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view)
    {
        senddata(view);

    }

    public void senddata(View v)
    {
        String s="The item ";
        String s1 = " cannot be empty";
        //get message from message box
        if(TextUtils.isEmpty(name.getText()))
        {
            name.setError(s+"name"+s1);
        }
        else if(TextUtils.isEmpty(phone.getText() ))
        {
            phone.setError(s+"phone"+s1);
        }
        else if(TextUtils.isEmpty(email.getText() ))
        {
            email.setError(s+"email"+s1);
        }
        else if(TextUtils.isEmpty(message.getText() ))
        {
            message.setError(s+"message"+s1);
        }

        else {
            try {

                String n = (name.getText() + "").replaceAll("\\s", "");
                String m = (message.getText() + "").replaceAll("\\s", "..");

                String utext = "http://unstoppered-syntax.000webhostapp.com/xyz.php?name=" + n + "&phone=" + phone.getText() +
                        "&email=" + email.getText() + "&message=" + m;

             new Send_Form_Data(getActivity()).execute(utext);


            } catch (Exception e) {
                Log.e("Sending data ", "senddata: " + e);
            }

        }

        }
    }




