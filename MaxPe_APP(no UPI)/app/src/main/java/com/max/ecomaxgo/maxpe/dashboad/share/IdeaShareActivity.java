package com.max.ecomaxgo.maxpe.dashboad.share;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.share.ShareIdea;
import com.max.ecomaxgo.maxpe.share.ShareThanksDialog;
import com.max.ecomaxgo.maxpe.util.Constant;
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdeaShareActivity extends AppCompatActivity {

  ImageView _imgBackShareIdea;
  Button _btnShareIdeaSubmit;
  TextView tv_related,_sharemessage;
  String msgRelated="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_share);

        _imgBackShareIdea=findViewById(R.id._imgBackShareIdea);
        _btnShareIdeaSubmit=findViewById(R.id._btnShareIdeaSubmit);
         tv_related=findViewById(R.id.tv_related);
         _sharemessage=findViewById(R.id._sharemessage);
        _btnShareIdeaSubmit.setOnClickListener(view->submit());
        _imgBackShareIdea.setOnClickListener(view->finish());
        tv_related.setOnClickListener(view->relatedList());


    }

    private void relatedList() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.dialog_share_idea, null);
        final android.app.AlertDialog deleteDialog = new android.app.AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        ListView rel_relatedList =deleteDialogView.findViewById(R.id.rel_relatedList);
        ImageView rel_cancel_img =deleteDialogView.findViewById(R.id.rel_cancel_img);
        deleteDialogView.findViewById(R.id.rel_cancel_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });

        deleteDialog.show();
        list(rel_relatedList,deleteDialog);
    }

    private void list(ListView rel_relatedList, AlertDialog deleteDialog) {
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("New Service");
        your_array_list.add("Loan");
        your_array_list.add("UPI");
        your_array_list.add("Daily bills");
        your_array_list.add("Bill sharing ");
        your_array_list.add("Security ");
        your_array_list.add("UI/ UX designs ");
        your_array_list.add("Others");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        rel_relatedList.setAdapter(arrayAdapter);
        rel_relatedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 msgRelated=your_array_list.get(position).toString();
                tv_related.setText(msgRelated);

                deleteDialog.dismiss();
            }
        });
    }



    private void submit() {
        if (TextUtils.isEmpty(_sharemessage.getText().toString())){

            Toast.makeText(IdeaShareActivity.this,"Please share your idea with him",Toast.LENGTH_SHORT).show();

        }else {
            shareMessage(_sharemessage.getText().toString());
        }
    }

    private void shareMessage(String message) {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.fragment_loading_dialog, null);
        final android.app.AlertDialog deleteDialog = new android.app.AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        deleteDialog.show();

        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.shareIdea(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(),msgRelated+":   "+message);

        call.enqueue(new Callback<ShareIdea>() {

            @Override
            public void onResponse(Call<ShareIdea> call, Response<ShareIdea> response) {
                if(response.isSuccessful()) {
                    ShareIdea data = response.body();

                    if (data.getStatus().equals("1")) {
                        submitStatus();
                    }
                }
                deleteDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ShareIdea> call, Throwable t) {

                Toast.makeText(IdeaShareActivity.this,"Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                deleteDialog.dismiss();

            }
        });

    }
    private void submitStatus() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View sView = factory.inflate(R.layout.share_thanks_layout, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(sView);
        TextView tvLogoutYes = sView.findViewById(R.id.tvLogoutYes);
        tvLogoutYes.setOnClickListener(view->dialog.dismiss());
        _sharemessage.setText("");
        tv_related.setText("");

        dialog.show();

    }
}