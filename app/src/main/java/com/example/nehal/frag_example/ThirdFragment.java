package com.example.nehal.frag_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Nehal on 4/4/2017.
 */

public class ThirdFragment extends Fragment implements View.OnClickListener
{
    private String title;
    private int page;
    private Button file_button;


    public static ThirdFragment newInstance(int page, String title)
    {
        ThirdFragment fragmentThird = new ThirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentThird.setArguments(args);
        return fragmentThird;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_third, container,false);
        file_button = (Button)view.findViewById(R.id.button33);
        file_button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view)
    {
        Toast.makeText(getContext(),"Clicking?",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getContext(),UserActivity.class);
        startActivity(i);
    }

}
