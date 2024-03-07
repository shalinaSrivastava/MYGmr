package com.max.ecomaxgo.maxpe.quiz

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.quiz.adapter.QuizParticpateRVAdapter
import com.max.ecomaxgo.maxpe.quiz.model.Participant
import com.max.ecomaxgo.maxpe.quiz.model.Quiz
import com.max.ecomaxgo.maxpe.quiz.model.QuizAns
import com.max.ecomaxgo.maxpe.quiz.model.QuizCancelListener
import com.max.ecomaxgo.maxpe.receiver.NetworkReceiver
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.util.RotationUtils
import com.max.ecomaxgo.maxpe.util.Util
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import okhttp3.internal.checkDuration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class QuizQuestPage : AppCompatActivity(), QuizCancelListener {
    private lateinit var imgDailyQuiz: ImageView
    private lateinit var rvQuizParticipate: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    private lateinit var tvNextQuizText: TextView
    private lateinit var tvTimingQuizText: TextView
    private lateinit var tvQuizFailedText: TextView
    private lateinit var tvQuizAnswered: TextView
    private lateinit var cvQuizQuesMsgtLayout: CardView
    private lateinit var cvQuizQuestLayout: CardView
    private lateinit var btnQuizQuestValue: Button
    private lateinit var rlQuinWinnerLayout: RelativeLayout
    private lateinit var tvQuizQuest: TextView
    private lateinit var btnAllreayAns: TextView
    private lateinit var quiz1: RadioButton
    private lateinit var quiz2: RadioButton
    private lateinit var quiz3: RadioButton
    private lateinit var quiz4: RadioButton

    private lateinit var imgQuizGif: ImageView
    private lateinit var rgQuizGroup: RadioGroup
    private lateinit var radioRroupTwo: RadioGroup
    private var rdTripSelect: RadioButton?= null
    private var QuizAnswer = ""
    private lateinit var quizId: String
    private lateinit var maxPreference: MaxSharedPreference

    //quiz Timer view declaration here...
    private lateinit var tvNextQuizTimer: TextView
    private val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    private val handler = Handler()
    private var runnable:Runnable ?= null
    private lateinit var llTimerLayout: LinearLayout
    private lateinit var cvQuizTimerLayout: CardView
    private lateinit var tvUsernameQuiz: TextView
    private lateinit var tvAmount: TextView

    private var mNetworkReceiver: BroadcastReceiver? = null
    private lateinit var quizQuest: Quiz
    private lateinit var quizAns: QuizAns
    private lateinit var linearWinnerLayout: LinearLayout
    private lateinit var imgUserProfileQuiz: ImageView

    var participantList:ArrayList<Participant> ?= null
    var lastWinerList:ArrayList<Participant> ?= null
    //var lastWinnerList:ArrayList<QuizParticipants> ?= null

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(
            context: Context?,
            intent: Intent
        ) {
            // Get extra data included in the Intent
//            Munirka lat lng :- 28.554079, 77.177277
//            Nirman Bhawan :- 28.617438, 77.220901
//            Nagar Nigarm, Lucknow :- 26.8477, 80.9419
            val message = intent.getStringExtra("message")
            val isNetworkAvailable = intent.getBooleanExtra("checkNetwork", false)
            Log.e("broadcast check network", " :: ${message} :: ${isNetworkAvailable}")

            if(isNetworkAvailable){

            }else{
                getQuizData()

            }
        }
    }

    private lateinit var quizImportantNoticeDialog: QuizImportantNoticeDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quest_page)

        initViews()
        setUpRecyclerView()

        RotationUtils.setRotateAnim()
        mNetworkReceiver = NetworkReceiver()
        registerNetworkBroadcastForNougat()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver, IntentFilter("custom-event-name"))

        //quizImportantNoticeDialog = QuizImportantNoticeDialog()
        //quizImportantNoticeDialog.show(supportFragmentManager, "Show Important notice")

        //Log.e("checkTime :: 12:01", " :: ${Util.compareTime("12:01")}")
        //Log.e("checkTime :: 18:01", " :: ${Util.compareTime("18:01")}")

        if(Util.compareTimeFrom("12:01")  &&  Util.compareTimeTo("18:00")){
            llTimerLayout.visibility = View.VISIBLE
            countDownStart(Util.getTodayDate())
        }else if(Util.compareTimeFrom("18:01")  ||  Util.compareTimeTo("12:00")){
            llTimerLayout.visibility = View.VISIBLE
            countDownStart(Util.getTomorrowDate())
        }else{
            llTimerLayout.visibility = View.GONE
        }

        maxPreference = MaxSharedPreference(this@QuizQuestPage)
        getQuizData()

        rgQuizGroup.setOnCheckedChangeListener { group, checkedId ->
            rdTripSelect = findViewById(checkedId)
            System.out.println("radio payment------------"+rdTripSelect!!.text)
            QuizAnswer = rdTripSelect!!.text.toString()

        }

        radioRroupTwo.setOnCheckedChangeListener { group, checkedId ->
            rdTripSelect = findViewById(checkedId)
            System.out.println("radio payment------------"+rdTripSelect!!.text)
            QuizAnswer = rdTripSelect!!.text.toString()
            rgQuizGroup.clearCheck()

        }

        imgDailyQuiz.setOnClickListener { finish() }
        btnQuizQuestValue.filterTouchesWhenObscured = true
        btnQuizQuestValue.setOnClickListener{
            submitQuizAnswerApi()
//            Toast.makeText(this@QuizQuestPage, "You have to select : ${QuizAnswer}", Toast.LENGTH_SHORT).show()
        }



    }

    private fun countDownStart(timerDate:String) {
        runnable = object : Runnable {
            override fun run() {
                try {
                    handler.postDelayed(this, 1000)
                    val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
                    val event_date = dateFormat.parse(timerDate)
                    val current_date = Date()

//                    Log.e("countDownStart :: ", "${current_date} :: ${event_date}")
                    if (!current_date.after(event_date)) {
                        val diff:Long = event_date.time - current_date.time
//                        val Days = diff / (24 * 60 * 60 * 1000)
                        val Hours = diff / (60 * 60 * 1000) % 24
                        val Minutes = diff / (60 * 1000) % 60
                        val Seconds = diff / 1000 % 60

                        /*${Days} :*/
                        if(Seconds <= 9){
                            if(Minutes<=9){
                                tvNextQuizTimer.text = "${Hours} : 0${Minutes} : 0${Seconds}"
                            }else if(Hours in 1..9){
                                tvNextQuizTimer.text = "0${Hours} : ${Minutes} : 0${Seconds}"
                            }else if(Hours<1){
                                if(Minutes in 1..9){
                                    tvNextQuizTimer.text =  "00 : 0${Minutes} : ${Seconds}"
                                }else if(Minutes<1){
                                    if(Seconds<=9){
                                        tvNextQuizTimer.text =  "00 : 00 : 0${Seconds}"
                                    }else{
                                        tvNextQuizTimer.text = "00 : 00 : ${Seconds}"
                                    }
                                }else if(Seconds<=9){
                                    tvNextQuizTimer.text = "00 : ${Minutes} : 0${Seconds}"
                                }else{
                                    tvNextQuizTimer.text = "00 : ${Minutes} : ${Seconds}"
                                }
//                                tvNextQuizTimer.text = "0${Hours} : ${Minutes} : 0${Seconds}"
                            }else{
                                tvNextQuizTimer.text = "${Hours} : ${Minutes} : 0${Seconds}"
                            }
                        }else if(Minutes<=9){
                            if(Seconds<=9){
                                tvNextQuizTimer.text = "0${Hours} : 0${Minutes} : 0${Seconds}"
                            }else if(Hours<=9){
                                tvNextQuizTimer.text ="0${Hours} : 0${Minutes} : ${Seconds}"
                            }else{
                                tvNextQuizTimer.text = "${Hours} : 0${Minutes} : ${Seconds}"
                            }
                        }else if(Hours in 1..9){
                            if(Minutes<=9){
                                tvNextQuizTimer.text ="0${Hours} : 0${Minutes} : ${Seconds}"
                            }else if(Seconds<=9){
                                tvNextQuizTimer.text ="0${Hours} : ${Minutes} : 0${Seconds}"
                            }else{
                                tvNextQuizTimer.text =  "0${Hours} : ${Minutes} : ${Seconds}"
                            }
                        }else if(Hours<1){
                            if(Minutes in 1..9){
                                tvNextQuizTimer.text = "00 : 0${Minutes} : ${Seconds}"
                            }else if(Minutes<1){
                                if(Seconds<=9){
                                    tvNextQuizTimer.text ="00 : 00 : 0${Seconds}"
                                }else{
                                    tvNextQuizTimer.text = "00 : 00 : ${Seconds}"
                                }
                            }else if(Seconds<=9){
                                tvNextQuizTimer.text = "00 : ${Minutes} : 0${Seconds}"
                            }else{
                                tvNextQuizTimer.text ="00 : ${Minutes} : ${Seconds}"
                            }
                        }else{
                            tvNextQuizTimer.text = "${Hours} : ${Minutes} : ${Seconds}"
                        }
                    } else {
                        handler.removeCallbacks(runnable!!)
                    }
                } catch (e:Exception) {
                    e.printStackTrace()
                }
            }
        }
        handler.postDelayed(runnable as Runnable, 0)
    }

    val ha = Handler()
    val quizNoticeHandler = Handler()

    override fun onResume() {
        super.onResume()
        quizNoticeHandler.postDelayed(object : Runnable {
            override fun run() {

                //quizImportantNoticeDialog.dismissAllowingStateLoss()
                /*  quizNoticeHandler.postDelayed(this, 1000)*/ }
        }, 5000)

        ha.postDelayed(object : Runnable {
            override fun run() {

                if(Util.compareTimeEquality("12:00:01")) {
                    getQuizData()
                }else if(Util.compareTimeFrom("12:00")  &&  Util.compareTimeTo("12:01")) {
                    getQuizData()
                }else if(Util.compareTimeEquality("12:01:01")) {
                    getQuizData()
                }else if(Util.compareTimeEquality("18:00:01")) {
                    getQuizData()
                }else if(Util.compareTimeFrom("18:00")  &&  Util.compareTimeTo("18:01")) {
                    getQuizData()
                }else if(Util.compareTimeEquality("18:01:00")) {
                    getQuizData()
                }else if(Util.compareTimeEquality("18:01:01")) {
                    countDownStart(Util.getTomorrowDate())
                }else if(Util.compareTimeEquality("12:01:01")) {
                    countDownStart(Util.getTodayDate())
                }
                ha.postDelayed(this, 1000) }
        }, 1000)
    }

    override fun quizClose(isClose: Boolean) {
        getQuizData()

    }

    private fun registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(
                mNetworkReceiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(
                mNetworkReceiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
    }

    private fun unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    private fun setUpRecyclerView(){
        layoutManager = LinearLayoutManager(this@QuizQuestPage, LinearLayoutManager.HORIZONTAL, false)
        rvQuizParticipate.layoutManager = layoutManager
        rvQuizParticipate.itemAnimator = DefaultItemAnimator()
        rvQuizParticipate.hasFixedSize()
    }
    private fun initViews(){
        tvUsernameQuiz = findViewById(R.id.tvUsernameQuiz)
        tvAmount = findViewById(R.id.tvAmount)
        imgUserProfileQuiz = findViewById(R.id.imgUserProfileQuiz)
        linearWinnerLayout = findViewById(R.id.linearWinnerLayout)
        btnAllreayAns = findViewById(R.id.btnAllreayAns)
        tvQuizAnswered = findViewById(R.id.tvQuizAnswered)
        imgDailyQuiz = findViewById(R.id.imgDailyQuiz)
        cvQuizTimerLayout = findViewById(R.id.cvQuizTimerLayout)
        llTimerLayout = findViewById(R.id.llTimerLayout)
        tvNextQuizTimer = findViewById(R.id.tvNextQuizTimer)
        //imgQuizGif = findViewById(R.id.imgQuizGif)
        rlQuinWinnerLayout = findViewById(R.id.rlQuinWinnerLayout)
        rvQuizParticipate = findViewById(R.id.rvQuizParticipate)
        tvQuizFailedText = findViewById(R.id.tvQuizFailedText)
        cvQuizQuesMsgtLayout = findViewById(R.id.cvQuizQuesMsgtLayout)
        cvQuizQuestLayout = findViewById(R.id.cvQuizQuestLayout)
        btnQuizQuestValue = findViewById(R.id.btnQuizQuestValue)
        rgQuizGroup = findViewById(R.id.rgQuizGroup)
        radioRroupTwo = findViewById(R.id.radioRroupTwo)
        tvTimingQuizText = findViewById(R.id.tvTimingQuizText)
        tvNextQuizText= findViewById(R.id.tvNextQuizText)
        tvQuizQuest = findViewById(R.id.tvQuizQuest)
        quiz1 = findViewById(R.id.quiz1)
        quiz2 = findViewById(R.id.quiz2)
        quiz3 = findViewById(R.id.quiz3)
        quiz4 = findViewById(R.id.quiz4)

    }

    private fun getQuizData() {
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Fetching data....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")

        //participantList = ArrayList()
        //lastWinnerList = ArrayList()
        val call: Call<Quiz> = retrofitconfig.endpoints.quizDo(maxPreference.UserMobileNum!!, maxPreference.UserToken!!,
            Constant.skey)
        call.enqueue(object : Callback<Quiz> {
            override fun onFailure(call: Call<Quiz>, t: Throwable) {
                Toast.makeText(this@QuizQuestPage,"Please check your Internet Connection", Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
                RotationUtils.r!!.cancel()
            }

            override fun onResponse(call: Call<Quiz>, response: Response<Quiz>) {
                RotationUtils.r!!.cancel()
                quizQuest = response.body()!!
                System.out.println("----------------------------------")

                if(quizQuest.status.equals("1")) {
                    //Toast.makeText(this@QuizQuestPage, quizQuest.message, Toast.LENGTH_LONG).show()
                    participantList = quizQuest.data?.participant as ArrayList<Participant>?
                    System.out.println("participantsize-----------------" + participantList?.size)
                    lastWinerList = quizQuest.data?.lastWinner as ArrayList<Participant>?
                    System.out.println("lastWinerList-----------------" + lastWinerList?.size)

                    if (lastWinerList.isNullOrEmpty()){
                        linearWinnerLayout.visibility = View.GONE
                        rlQuinWinnerLayout.visibility = View.GONE

                    }else{
                        linearWinnerLayout.visibility = View.VISIBLE
                        rlQuinWinnerLayout.visibility = View.VISIBLE
                        for (lastwinner in lastWinerList!!){
                            Glide.with(this@QuizQuestPage)
                                .load(lastwinner.image)
                                .centerCrop()
                                .placeholder(R.drawable.personicon)
                                .into(imgUserProfileQuiz)

                            tvUsernameQuiz.text = lastwinner.fname
                            tvAmount.text = "₹ ${lastwinner.credited}"
                            if (quizQuest.data?.duration.equals("18")){
                                tvNextQuizText.text="Next Quiz at "+ "6 PM"
                            }else{
                                tvNextQuizText.text="Next Quiz at "+ "12 PM"
                            }

                            System.out.println("fname+++++++++++++++++++++"+lastwinner.fname)
                        }

                    }

                    quizId = quizQuest.data?.quizid!!
                    if (participantList.isNullOrEmpty()) {
                        rlQuinWinnerLayout.visibility = View.VISIBLE
                        rvQuizParticipate.visibility = View.GONE
                    } else {
                        rlQuinWinnerLayout.visibility = View.VISIBLE
                        rvQuizParticipate.visibility = View.VISIBLE
                        val quizParticpateRVAdapter =
                            QuizParticpateRVAdapter(this@QuizQuestPage, participantList!!)
                        rvQuizParticipate.adapter = quizParticpateRVAdapter
                    }
                    //lastWinnerList = quizQuestData.lastWinner
                    if (quizQuest.data?.result.equals("success", true)) {
                        cvQuizQuesMsgtLayout.visibility = View.GONE
                        cvQuizTimerLayout.visibility = View.GONE
                        cvQuizQuestLayout.visibility = View.VISIBLE
                        btnQuizQuestValue.visibility = View.VISIBLE
                        btnAllreayAns.visibility = View.GONE

                        tvQuizQuest.text = quizQuest.data?.question
                        quiz1.text = quizQuest.data?.option!!.a
                        quiz2.text = quizQuest.data?.option!!.b
                        quiz3.text = quizQuest.data?.option!!.c
                        quiz4.text = quizQuest.data?.option!!.d

                    } else {
                        if (quizQuest.data?.result.equals("over", true)) {
//                                ha.removeCallbacksAndMessages(null)
                            btnQuizQuestValue.visibility = View.GONE
                            cvQuizTimerLayout.visibility = View.VISIBLE
                            cvQuizQuesMsgtLayout.visibility = View.GONE
                            cvQuizQuestLayout.visibility = View.GONE
                            //cvQuizTimerLayout.visibility = View.GONE
                            btnAllreayAns.visibility = View.GONE
//                                tvTimingQuizText.visibility = View.VISIBLE

                            if (quizQuest.data?.duration.isNullOrEmpty()) {
                                tvTimingQuizText.text = "See you @ 12PM"
                            } else {
                                if (quizQuest.data?.duration.equals("18")) {
                                    tvTimingQuizText.text = "See you @ 6PM"
                                } else {
                                    tvTimingQuizText.text = "See you @ 12PM"
                                }
                            }

                            /*If Quiz starts then notify you by Notification*/
                            tvQuizFailedText.text = "Oh oh.. \nYou just missed it."
                        } else if (quizQuest.data?.result.equals("closed", true)) {
                            btnQuizQuestValue.visibility = View.GONE
                            cvQuizQuesMsgtLayout.visibility = View.GONE
                            cvQuizQuestLayout.visibility = View.GONE
                            cvQuizTimerLayout.visibility = View.VISIBLE
                            //cvQuizTimerLayout.visibility = View.GONE
                            btnAllreayAns.visibility = View.GONE

                            if (quizQuest.data?.duration?.equals("12") ?: false) {
                                tvQuizFailedText.text = "See you @ 12PM"
                            } else if (quizQuest.data?.duration?.equals("18") ?: false) {
                                tvQuizFailedText.text = "See you @ 6PM"
                            } else {
                                val dtHour = Date()
                                val hour = dtHour.hours
                                if (hour >= 12)
                                    tvQuizFailedText.text = "See you @ 6PM"
                                else
                                    tvQuizFailedText.text = "See you @ 12PM"
                            }
                        } else if (quizQuest.data?.result.equals("answered", true)) {
                            //cvQuizTimerLayout.visibility = View.VISIBLE
                            btnQuizQuestValue.visibility = View.GONE
                            cvQuizQuesMsgtLayout.visibility = View.GONE
                            cvQuizQuestLayout.visibility = View.VISIBLE
                            cvQuizTimerLayout.visibility = View.GONE
                            btnAllreayAns.visibility = View.VISIBLE

                            tvQuizQuest.text = quizQuest.data?.question
                            quiz1.text = quizQuest.data?.option!!.a
                            quiz2.text = quizQuest.data?.option!!.b
                            quiz3.text = quizQuest.data?.option!!.c
                            quiz4.text = quizQuest.data?.option!!.d

                            if (quizQuest.data?.duration.isNullOrEmpty()) {
                                tvQuizAnswered.text =
                                    "Oops.....\n You just missed it.\nSee you @ 12PM"
                            } else {
                                if (quizQuest.data?.duration.equals("18")) {
                                    tvQuizAnswered.text =
                                        "Oops.....\n You just missed it.\nSee you @ 6PM"
                                } else {
                                    tvQuizAnswered.text =
                                        "Oops.....\n You just missed it.\nSee you @ 12PM"
                                }
                            }
                        } else {
                            tvTimingQuizText.visibility = View.GONE
                            val dtHour = Date()
                            val hour = dtHour.hours
                            if (hour >= 12)
                                tvQuizFailedText.text = "Oops.....\n" +
                                        " You just missed it.\n" +
                                        "See you @ 6PM"
                            else
                                tvQuizFailedText.text = "Oops.....\n" +
                                        " You just missed it.\n" +
                                        "See you @ 12PM"
                        }
                    }

                }else{

                    if(quizQuest.message.equals("Invalid Access!", true)){
                        val IntentLogin = Intent(this@QuizQuestPage, Login::class.java)
                        IntentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        maxPreference.clear()
                        startActivity(IntentLogin)
                        finish()
                    }else{
                        Toast.makeText(this@QuizQuestPage,
                            quizQuest.message, Toast.LENGTH_SHORT).show()
                    }
                }
                loadingDialog.dismiss()
            }
        })
    }

    //submit api call
    private fun submitQuizAnswerApi(){
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Checking your answer....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")
        System.out.println("quizid------------------------"+quizId)
        System.out.println("QuizAns-----------------------"+QuizAnswer)

        val call: Call<QuizAns> = retrofitconfig.endpoints.quizAns(maxPreference.UserMobileNum!!, maxPreference.UserToken!!, QuizAnswer, quizId, Constant.skey)
        call.enqueue(object : Callback<QuizAns> {
            override fun onFailure(call: Call<QuizAns>, t: Throwable) {
                Toast.makeText(this@QuizQuestPage,"Please check your Internet Connection", Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<QuizAns>, response: Response<QuizAns>) {
                quizAns = response.body()!!
                if(quizAns.status.equals("1")){
                    //maxPreference.UserAmountLimit = quizAnswerSubmit.wallet!!.limit
                    //maxPreference.UserNetAmount = quizAnswerSubmit.wallet!!.funds!!.available!!.amount
                    //maxPreference.UserKycValue = quizAnswerSubmit.kyc
                    //maxPreference.WalletError = quizAnswerSubmit.wallet_error

                    val bundle = Bundle()
                    val quizAnswerDialog = QuizAnswerDialog()
                    bundle.putString("quizImage", quizAns.data?.image)
                    bundle.putString("quizName", quizAns.data?.fname)
                    bundle.putString("quizLName", quizAns.data?.lname)
                    bundle.putString("quizCredit", quizAns.data?.credited)
                    bundle.putString("quizWinner", quizAns.data?.winner)
                    bundle.putString("quizAns", quizAns.data?.answer)
                    bundle.putString("quizMsg", quizAns.message)
                    quizAnswerDialog.arguments = bundle
                    quizAnswerDialog.isCancelable = false
                    quizAnswerDialog.setQuizCancelListener(this@QuizQuestPage)
                    quizAnswerDialog.show(supportFragmentManager, "Quiz Questionaire")
                }else{
                    if(quizAns.message.equals("Invalid Access!", true)){
                        val IntentLogin = Intent(this@QuizQuestPage, Login::class.java)
                        IntentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        maxPreference.clear()
                        startActivity(IntentLogin)
                        finish()
                    }else{
                        val quizOverDialog = QuizOverDialog()
                        quizOverDialog.isCancelable = false
                        quizOverDialog.setQuizCancelListener(this@QuizQuestPage)
                        quizOverDialog.show(supportFragmentManager, "Quiz Over")
                    }
                }
                loadingDialog.dismiss()
            }
        })
    }

    override fun onRestart() {
        super.onRestart()
        if (Util.compareTimeFrom("12:01") && Util.compareTimeTo("18:00")) {
            llTimerLayout.visibility = View.VISIBLE
            countDownStart(Util.getTodayDate())
        } else if (Util.compareTimeFrom("18:01") || Util.compareTimeTo("12:00")) {
            llTimerLayout.visibility = View.VISIBLE
            countDownStart(Util.getTomorrowDate())
        } else {
            llTimerLayout.visibility = View.GONE
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterNetworkChanges()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver)
        ha.removeCallbacksAndMessages(null)
        handler.removeCallbacksAndMessages(null)
        quizNoticeHandler.removeCallbacksAndMessages(null)
    }
}