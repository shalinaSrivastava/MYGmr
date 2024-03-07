package com.max.ecomaxgo.maxpe.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigator
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.addmoney.AddMoneyActivity
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.model.login.WalletBalanceViewModel
import com.max.ecomaxgo.maxpe.paybill.PaybillActivity
import com.max.ecomaxgo.maxpe.quiz.QuizQuestPage
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.util.Util
import com.max.ecomaxgo.maxpe.view.AccessDeniedDialog
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import com.max.ecomaxgo.maxpe.view.LogoutDialog
import com.max.ecomaxgo.maxpe.view.ShareIdeaActivity
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment(){
    private lateinit var views : View
    private var mActivity: Activity?= null
    private lateinit var cardViewPaybill: CardView
    private lateinit var cardTransfer: CardView
    private lateinit var cardShareIdea: CardView
    private lateinit var cardQuiz: CardView
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var amount: TextView
    lateinit var walletBalanceViewModel: WalletBalanceViewModel
    private lateinit var progressBar: ProgressBar

    private lateinit var tvQuizComingTime: TextView
    lateinit var isNewDialog: IsNewDialog

    var myThread: Thread? = null
    val ha = Handler()
    internal lateinit var handler: Handler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = inflater.inflate(R.layout.fragment_home, container, false)
        maxPreference = MaxSharedPreference(requireContext())
        initView()
        val profileImage = maxPreference.UserProfileImg
        //System.out.println("profileImage----------------------------"+profileImage)

        if(Util.compareTimeFrom("12:01")  &&  Util.compareTimeTo("18:00")){
            tvQuizComingTime.visibility = View.VISIBLE
            countDownStart(Util.getTodayDate())
        }else if(Util.compareTimeFrom("18:01")  ||  Util.compareTimeTo("12:00")){
            tvQuizComingTime.visibility = View.VISIBLE
            countDownStart(Util.getTomorrowDate())
        }else{
            tvQuizComingTime.visibility = View.GONE
        }

        System.out.println("-------------------"+maxPreference.UserIsNew)
        isNewDialog = IsNewDialog()
        if (maxPreference.UserIsNew.equals("true")){
            //dialog show
            isNewDialog.show(parentFragmentManager, "")
            isNewDialog.isCancelable = false
        }else{
            //isNewDialog.dismiss()
            //dialog dismiss
        }
        handler =  Handler(Looper.getMainLooper())
        return views

    }


    private fun initView(){
        cardViewPaybill = views.findViewById(R.id.cardViewPaybill)
        cardTransfer = views.findViewById(R.id.cardTransfer)
        amount = views.findViewById(R.id.amount)
        progressBar = views.findViewById(R.id.progressBar)

        tvQuizComingTime = views.findViewById(R.id.tvTime)
        cardShareIdea = views.findViewById(R.id.cardShareIdea)
        cardQuiz = views.findViewById(R.id.cardQuiz)





        cardTransfer.setOnClickListener(View.OnClickListener {
            val intentSendMoney = Intent(context, AddMoneyActivity::class.java)
            startActivity(intentSendMoney)
        })
        cardViewPaybill.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, PaybillActivity::class.java)
            startActivity(intent)
        })

        cardShareIdea.setOnClickListener(View.OnClickListener {
            val intentShare = Intent(context, ShareIdeaActivity::class.java)
            startActivity(intentShare)
        })

        cardQuiz.setOnClickListener(View.OnClickListener {
            if (maxPreference.UserFName.equals("")){
                isNewDialog.show(parentFragmentManager, "")
            }else{
                val intent=Intent(context, QuizQuestPage::class.java)
                startActivity(intent)
            }

        })
    }
    private val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    private val handlerTimer = Handler()
    private var runnableTimer:Runnable ?= null
    private fun countDownStart(timerDate:String) {
        runnableTimer = object : Runnable {
            override fun run() {
                try {
                    handlerTimer.postDelayed(this, 1000)
                    val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
                    val event_date = dateFormat.parse(timerDate)
                    val current_date = Date()

                    //Log.e("countDownStart :: ", "${current_date} :: ${event_date}")
                    if (!current_date.after(event_date)) {
                        val diff:Long = event_date.time - current_date.time
//                        val Days = diff / (24 * 60 * 60 * 1000)
                        val Hours = diff / (60 * 60 * 1000) % 24
                        val Minutes = diff / (60 * 1000) % 60
                        val Seconds = diff / 1000 % 60

                        /*${Days} :*/
                        if(Seconds <= 9){
                            if(Minutes<=9){
                                tvQuizComingTime.text = "${Hours} : 0${Minutes} : 0${Seconds}"
                            }else if(Hours in 1..9){
                                tvQuizComingTime.text = "0${Hours} : ${Minutes} : 0${Seconds}"
                            }else if(Hours<1){
                                if(Minutes in 1..9){
                                    tvQuizComingTime.text = "0${Minutes} : ${Seconds}"
                                }else if(Minutes<1){
                                    if(Seconds<=9){
                                        tvQuizComingTime.text = "0${Seconds}"
                                    }else{
                                        tvQuizComingTime.text = "${Seconds}"
                                    }
                                }else if(Seconds<=9){
                                    tvQuizComingTime.text = "${Minutes} : 0${Seconds}"
                                }else{
                                    tvQuizComingTime.text = "${Minutes} : ${Seconds}"
                                }
//                                tvQuizComingTime.text = "0${Hours} : ${Minutes} : 0${Seconds}"
                            }else{
                                tvQuizComingTime.text = "${Hours} : ${Minutes} : 0${Seconds}"
                            }
                        }else if(Minutes<=9){
                            if(Seconds<=9){
                                tvQuizComingTime.text = "0${Hours} : 0${Minutes} : 0${Seconds}"
                            }else if(Hours<=9){
                                tvQuizComingTime.text = "0${Hours} : 0${Minutes} : ${Seconds}"
                            }else{
                                tvQuizComingTime.text = "${Hours} : 0${Minutes} : ${Seconds}"
                            }
                        }else if(Hours in 1..9){
                            if(Minutes<=9){
                                tvQuizComingTime.text = "0${Hours} : 0${Minutes} : ${Seconds}"
                            }else if(Seconds<=9){
                                tvQuizComingTime.text = "0${Hours} : ${Minutes} : 0${Seconds}"
                            }else{
                                tvQuizComingTime.text = "0${Hours} : ${Minutes} : ${Seconds}"
                            }
                        }else if(Hours<1){
                            if(Minutes in 1..9){
                                tvQuizComingTime.text = "0${Minutes} : ${Seconds}"
                            }else if(Minutes<1){
                                if(Seconds<=9){
                                    tvQuizComingTime.text = "0${Seconds}"
                                }else{
                                    tvQuizComingTime.text = "${Seconds}"
                                }
                            }else if(Seconds<=9){
                                tvQuizComingTime.text = "${Minutes} : 0${Seconds}"
                            }else{
                                tvQuizComingTime.text = "${Minutes} : ${Seconds}"
                            }
                        }else{
                            tvQuizComingTime.text = "${Hours} : ${Minutes} : ${Seconds}"
                        }
                    } else {
                        handler.removeCallbacks(runnable)
                    }
                } catch (e:Exception) {
                    e.printStackTrace()
                }
            }
        }
        handlerTimer.postDelayed(runnableTimer as Runnable, 0)
    }

    var pos = 0
    val runnable = Runnable {
        //changeImage(pos)
    }
    //get wallet balance details api integrated-----------------------
    private fun getLiveBalance(){
        progressBar.visibility = View.VISIBLE
        walletBalanceViewModel = ViewModelProvider(requireActivity()).
        get(WalletBalanceViewModel::class.java)
        walletBalanceViewModel.getWallet().observe(requireActivity(), Observer {
            if (it.status.equals("1")){
                maxPreference.AddMoneyAmountToWallet = it.data?.wallet?.amount
                System.out.println("wallet------------balance"+it.data?.wallet?.amount)
                amount.text = it.data?.wallet?.amount
                progressBar.visibility = View.GONE
            }else if (it.status.equals("0")){
                progressBar.visibility = View.GONE
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                val deniedDialog = AccessDeniedDialog()
                deniedDialog.isCancelable = false
                deniedDialog.show(parentFragmentManager, "")

            }
        })
        walletBalanceViewModel.getWalletBalance(Constant.skey, maxPreference.UserMobileNum!!, maxPreference.UserToken!!)

    }

    override fun onPause() {
        super.onPause()
       // isNewDialog.dismiss()
    }



    override fun onResume() {
        super.onResume()
        getLiveBalance()
        //isNewDialog.dismiss()

        if(Util.compareTimeFrom("12:01")  &&  Util.compareTimeTo("18:00")){
            tvQuizComingTime.visibility = View.VISIBLE
            countDownStart(Util.getTodayDate())
        }else if(Util.compareTimeFrom("18:01")  ||  Util.compareTimeTo("12:00")){
            tvQuizComingTime.visibility = View.VISIBLE
            countDownStart(Util.getTomorrowDate())
        }else{
            tvQuizComingTime.visibility = View.GONE
        }

        ha.postDelayed(object : Runnable {
            override fun run() {
                ha.postDelayed(this, 10000)

            }
        }, 10000)

    }

    class IsNewDialog : DialogFragment() {
        internal lateinit var view: View
        private lateinit var maxUserPrefs: MaxSharedPreference
        lateinit var updateUser: Login
        private var callback: OnAddFriendListener?= null

        fun interface OnAddFriendListener {
            fun onAddFriendSubmit(friendEmail: String?)
        }
        
           

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            view = inflater.inflate(R.layout.popup_layout, container, false)

            maxUserPrefs = MaxSharedPreference(requireContext()!!)
            val tvSkip: TextView = view.findViewById(R.id.tvSkip)
            val btnSubmit: Button = view.findViewById(R.id.btnSubmit)
            val editFName: EditText = view.findViewById(R.id.editFName)
            val editLName: EditText = view.findViewById(R.id.editLName)
            dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            tvSkip.setOnClickListener {
                dismiss()
                maxUserPrefs.UserIsNew = "false"
            }

            btnSubmit.setOnClickListener(View.OnClickListener {
                if (editFName.text.toString().equals("")){
                    Toast.makeText(context, "Please enter first name", Toast.LENGTH_LONG).show()
                    editFName.requestFocus()
                }else if (editLName.text.toString().equals("")){
                    Toast.makeText(context, "Please enter last name", Toast.LENGTH_LONG).show()
                    editFName.requestFocus()
                }else{
                    val loadingDialog = LoadingDialog()
                    val bundlePassText = Bundle()
                    loadingDialog.isCancelable = false
                    bundlePassText.putString("showText", "Progress....")
                    loadingDialog.arguments = bundlePassText
                    loadingDialog.show(parentFragmentManager, "Loading Dialog")

                    val call:Call<Login> =
                        retrofitconfig.endpoints.updateName(Constant.skey,
                            maxUserPrefs.UserMobileNum!!, maxUserPrefs.UserToken!!,
                            editFName.text.toString(), editLName.text.toString())
                    call.enqueue(object : Callback<Login> {
                        override fun onResponse(call: Call<Login>, response: Response<Login>) {
                            updateUser = response.body()!!
                            if (updateUser.status.equals("1")){
                                Toast.makeText(context, updateUser.message, Toast.LENGTH_LONG).show()
                                var fname = updateUser.data?.name?.first
                                var lname = updateUser.data?.name?.last
                                System.out.println("fname--------------------"+fname)
                                System.out.println("lname--------------------"+lname)

                                maxUserPrefs.UserFName = updateUser.data?.name?.first
                                maxUserPrefs.UserLName = updateUser.data?.name?.last

                                loadingDialog.dismiss()
                                dismiss()
                                maxUserPrefs.UserIsNew = "false"

                                Constant.strUserName = updateUser.data?.name?.first!!

//                                val friendEmail = updateUser.data?.name?.first
//                                callback?.onAddFriendSubmit(friendEmail);

                            }


                        }

                        override fun onFailure(call: Call<Login>, t: Throwable) {
                            loadingDialog.dismiss()
                        }
                    })
                }
            })
            return view
        }
    }
}