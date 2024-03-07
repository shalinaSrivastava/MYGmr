package com.max.ecomaxgo.maxpe.quiz

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.facebook.CallbackManager
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareButton
import com.facebook.share.widget.ShareDialog
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.quiz.model.QuizCancelListener
import de.hdodenhof.circleimageview.CircleImageView

class QuizAnswerDialog : DialogFragment() {
    internal lateinit var view : View
    private lateinit var maxUserPrefs : MaxSharedPreference
    private lateinit var imgUserProfilewEL: CircleImageView
    private lateinit var tvWelcomeMsg: TextView

    private lateinit var tvQuiztryHint: TextView
    private lateinit var tvWinAmountQuiz: TextView
    private lateinit var tvAnswerText: TextView
    private lateinit var tvQuizTryText: TextView
    private lateinit var ImgQuizAnsd: ImageView
    private lateinit var imgCloseQuizDialog: ImageView
    private lateinit var cvQuizWinnerLayout: CardView
    private lateinit var cvQuizAnsLayout: CardView
    private lateinit var linearOne: LinearLayout

    private lateinit var callbackMangager: CallbackManager
    private lateinit var shareDialog: ShareDialog
    private lateinit var shareButton: ShareButton

    private lateinit var relativeTwo: RelativeLayout
    private lateinit var relativeThree: RelativeLayout
    private lateinit var relativeOne: RelativeLayout

    private var answer = ""
    private var winner = ""
    private var  mActivity: Activity?= null

    fun shareContentWithFB(){
        val content = ShareLinkContent.Builder()
            .setContentUrl(Uri.parse("https://developers.facebook.com"))
            .build()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }

    private var quizCancelListener: QuizCancelListener?= null

    fun setQuizCancelListener(quizCancelListener:QuizCancelListener){
        this.quizCancelListener = quizCancelListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.answer_dialog, container, false)
        //view = inflater.inflate(R.layout.quiz_answer_dialog_layout, container, false)
        initViews()

        maxUserPrefs = MaxSharedPreference(requireContext())
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        winner = requireArguments().getString("quizWinner")!!
        answer = requireArguments().getString("quizAns")!!
//        tvAmountCredit.text = "₹ ${arguments!!.getString("quizCredit")}"
//        tvWinnerQuiz.text = arguments!!.getString("quizWinner")

        imgCloseQuizDialog.setOnClickListener {
            //dismissAllowingStateLoss()
            quizCancelListener?.quizClose(true)
            activity?.finish()
        }
        if(winner.toBoolean()){

            relativeThree.visibility = View.GONE
            relativeTwo.visibility = View.VISIBLE
            //cvQuizAnsLayout.visibility = View.GONE
            //cvQuizWinnerLayout.visibility = View.VISIBLE


            Glide
                 .with(requireContext())
                 .load(requireArguments().getString("quizImage"))
                 .centerCrop()
                 .placeholder(R.drawable.aa)
                 .into(imgUserProfilewEL)
            var fname = "${requireArguments().getString("quizName")}"
            var lName = "${requireArguments().getString("quizLName")}"
            tvWelcomeMsg.text = ""+fname+" "+lName
            //tvWelcomeMsg.text = "${requireArguments().getString("quizName")}"

            //tvWelcomeMsg.text = "Congratulation ${requireArguments().getString("quizName")} !! \nYou win Quiz"
            tvWinAmountQuiz.text = "₹ ${requireArguments().getString("quizCredit")}"

        }else{

            //cvQuizAnsLayout.visibility = View.VISIBLE
            //cvQuizWinnerLayout.visibility = View.GONE


            relativeTwo.visibility = View.GONE
            relativeThree.visibility = View.VISIBLE

            if(answer.toBoolean()){
                relativeOne.background = null
                linearOne.setBackgroundColor(resources.getColor(R.color.purple_200))
                tvQuiztryHint.visibility = View.VISIBLE
                imgUserProfilewEL.setImageResource(R.drawable.check01)
                tvAnswerText.text = "Correct !!"
                tvQuizTryText.text = "You are close to win. Better luck next time !!"
                tvQuizTryText.setTextColor(Color.BLACK)
                tvAnswerText.setTextColor(Color.WHITE)
                tvQuiztryHint.setTextColor(Color.BLACK)

            }else{
                relativeOne.background = null
                linearOne.setBackgroundColor(Color.RED)
                tvQuiztryHint.visibility = View.GONE
                imgUserProfilewEL.setImageResource(R.drawable.fail)
                tvAnswerText.text = "Wrong !!"
                tvQuizTryText.text = "Better luck next time"
                tvAnswerText.setTextColor(Color.WHITE)
                tvQuizTryText.setTextColor(Color.BLACK)

                //tvAnswerText.setTextColor(resources.getColor(R.color.red))
            }
        }

//        shareButton.setOnClickListener {
//
//            val shareLinkContent = ShareLinkContent.Builder()
//                .setQuote("This is Maxpe Quiz Page..")
//                .setContentUrl(Uri.parse("https://youtube.com")).build()
//
//            if(shareDialog.canShow(shareLinkContent)){
//                shareDialog.show(shareLinkContent)
//            }
//        }
        return view
    }

    private fun initViews(){
        imgUserProfilewEL = view.findViewById(R.id.ivProfile)
        tvWelcomeMsg = view.findViewById(R.id.tvWelcomeMsg)
        relativeTwo = view.findViewById(R.id.relativeTwo)
        relativeThree = view.findViewById(R.id.relativeThree)

        tvQuiztryHint = view.findViewById(R.id.tvQuiztryHint)
        tvWinAmountQuiz = view.findViewById(R.id.tvWinAmountQuiz)
        tvAnswerText = view.findViewById(R.id.tvAnswerText)
        tvQuizTryText = view.findViewById(R.id.tvQuizTryText)
        relativeOne = view.findViewById(R.id.relativeOne)
        //ImgQuizAnsd = view.findViewById(R.id.ImgQuizAnsd)
        imgCloseQuizDialog = view.findViewById(R.id.imgCloseQuizDialog)
        linearOne = view.findViewById(R.id.linearOne)
        //cvQuizWinnerLayout = view.findViewById(R.id.cvQuizWinnerLayout)
        //cvQuizAnsLayout = view.findViewById(R.id.cvQuizAnsLayout)

        //facebook views here....
//        shareButton = view.findViewById(R.id.fbShareContent)
        //shareDialog = ShareDialog(mActivity)
        callbackMangager = CallbackManager.Factory.create()
    }
}