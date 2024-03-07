package com.max.ecomaxgo.maxpe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.adapter.HistoryAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.prepaid.History
import com.max.ecomaxgo.maxpe.model.prepaid.TransHistory
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class TransactionsFragment : Fragment() {
    private lateinit var rvHistory: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var maxPreference : MaxSharedPreference
    lateinit var mob_number: String
    lateinit var userToken: String

    lateinit var history: History
    val historyDetails = ArrayList<TransHistory>()
    private lateinit var historyAdapter: HistoryAdapter

    private lateinit var imgBackHistory: ImageView
    private lateinit var progressHistory: ProgressBar
    private lateinit var views: View
    private lateinit var ivEmpty: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_transactions, container, false)
        maxPreference =
            MaxSharedPreference(requireContext())

        mob_number = maxPreference.UserMobileNum.toString()
        userToken = maxPreference.UserToken.toString()

        System.out.println("mob_number-------------------+++"+mob_number)

        System.out.println("userToken-------------------+++"+userToken)
        initView()
        layoutManager = LinearLayoutManager(requireContext())
        rvHistory.layoutManager = layoutManager
        rvHistory.itemAnimator = DefaultItemAnimator()
        rvHistory.hasFixedSize()

        return views
    }

    private fun initView(){
        rvHistory = views.findViewById(R.id.rvHistory)
        imgBackHistory = views.findViewById(R.id.imgBackHistory)
        progressHistory = views.findViewById(R.id.progressHistory)
        ivEmpty = views.findViewById(R.id.ivEmpty)

        val call: Call<History> =
            retrofitconfig.endpoints.getHistory(Constant.skey, mob_number, userToken)
        call.enqueue(object : Callback<History> {
            override fun onResponse(call: Call<History>, response: Response<History>) {
                history = response.body()!!
                if (history.status.equals("1")){
                    historyDetails.addAll(history.data!!)
                    System.out.println("history_details-----------------"+historyDetails)
                    if (historyDetails.isEmpty()){
                        ivEmpty.visibility = View.VISIBLE
                        progressHistory.visibility = View.GONE

                    }else{
                        historyAdapter = HistoryAdapter(requireContext(), historyDetails)
                        rvHistory.adapter = historyAdapter
                        progressHistory.visibility = View.GONE
                    }
                }

            }

            override fun onFailure(call: Call<History>, t: Throwable) {

            }
        })
    }
}