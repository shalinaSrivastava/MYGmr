package com.max.ecomaxgo.maxpe.dth.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.bbps.BillerCustomerParam;

import java.util.List;

public class EditTextAdapter extends RecyclerView.Adapter<EditTextAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static List<BillerCustomerParam> editModelArrayList;


    public EditTextAdapter(Context ctx, List<BillerCustomerParam> editModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.editModelArrayList = editModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.et_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        BillerCustomerParam billerCustomerParams = editModelArrayList.get(position);
        if (billerCustomerParams.getOptional().equals("false")){
            holder.filledTextField.setHint(billerCustomerParams.getParamName()+"*");
            //holder.editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }else if (billerCustomerParams.getOptional().equals("true")){
            holder.filledTextField.setHint(billerCustomerParams.getParamName());
            //holder.editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }

        //holder.editText.setHint(billerCustomerParams.getParamName());

        Log.d("print","yes");

    }

    @Override
    public int getItemCount() {
        return this.editModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        protected TextInputLayout filledTextField;
        protected EditText editText;
        private TextView tvLabel;
        public MyViewHolder(View itemView) {
            super(itemView);

            filledTextField = (TextInputLayout) itemView.findViewById(R.id.filledTextField);
            editText = (EditText)itemView.findViewById(R.id.et);
            tvLabel = (TextView)itemView.findViewById(R.id.tvLabel);

        }

    }
}