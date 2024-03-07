package com.max.ecomaxgo.maxpe.fragment

import android.R.attr
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.WebViewactivity
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.Profile
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import com.max.ecomaxgo.maxpe.view.LogoutDialog
import com.theartofdev.edmodo.cropper.CropImage
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_complaint.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream


class ProfileFragment : Fragment() {

    private var mActivity: Activity?= null
    private lateinit var tvlogout: TextView
    private lateinit var views : View
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var tvUserMob: TextView
    private  lateinit var tvPersonalDetails: TextView
    private lateinit var imgAddProfile: ImageView
    private lateinit var tvTearmCondion: TextView
    private lateinit var tvProfileName:TextView

    private lateinit var tvUserNameUpdate: TextView

    private lateinit var imgUserProfile: CircleImageView
    private lateinit var b: Bitmap
    var encoded:String?=null
    private lateinit var updateProfilePicResponse : Profile
    lateinit var isNewDialog: IsNewDialog


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_profile, container, false)
        maxPreference = MaxSharedPreference(requireContext())
        initView()

        val profileImage = maxPreference.UserProfileImg
        System.out.println("profileImage----------------------------"+profileImage)
        Glide.with(this)
            .load(profileImage)
            .centerCrop()
            .placeholder(R.drawable.default_maxpe_profile)
            .into(imgUserProfile)
        return views
    }

    private fun initView(){
        tvlogout = views.findViewById(R.id.tvlogout)
        tvTearmCondion = views.findViewById(R.id.tvTearmCondion)
        tvUserNameUpdate=views.findViewById(R.id.tvUserNameUpdate)
        tvPersonalDetails=views.findViewById(R.id.tvPersonalDetails)
        imgAddProfile = views.findViewById(R.id.imgAddProfile)
        tvUserMob = views.findViewById(R.id.tvUserMob)
        imgUserProfile = views.findViewById(R.id.imgUserProfile)
        tvProfileName= views.findViewById(R.id.tvProfileName)
        tvUserMob.setText(maxPreference.UserMobileNum)
        tvProfileName.setText(maxPreference.UserFName+" "+maxPreference.UserLName)

        tvlogout.setOnClickListener(View.OnClickListener {
            val logoutDialog = LogoutDialog()
            logoutDialog.isCancelable = false
            logoutDialog.show(parentFragmentManager, "")
        })
        tvPersonalDetails.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ProfileDetailActivity::class.java)
            startActivity(intent)
        })

        imgAddProfile.setOnClickListener(View.OnClickListener {
            CropImage.activity()
                .start(requireContext(), this);
        })

       tvTearmCondion.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, WebViewactivity::class.java)
            intent.putExtra("url","https://maxpe.in/term.html")
            intent.putExtra("title","Terms & Condition")
            startActivity(intent)
        })
        isNewDialog = IsNewDialog()
        tvUserNameUpdate.setOnClickListener(View.OnClickListener {
            isNewDialog.show(parentFragmentManager, "")
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode === RESULT_OK) {
                val resultUri: Uri = result.uri
                System.out.println("uri---------------------"+resultUri)
                imgUserProfile.setImageURI(resultUri)

                val imageStream = context?.contentResolver?.openInputStream(resultUri!!)
                b = BitmapFactory.decodeStream(imageStream)
                //imgUserProfile.setImageBitmap(b)
                val baos = ByteArrayOutputStream()
                b.compress(Bitmap.CompressFormat.JPEG, 60, baos)
                val b2 = baos.toByteArray()

                encoded = Base64.encodeToString(b2, Base64.DEFAULT)
                profileImageUpdate(encoded!!)
            } else if (resultCode === CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }
    }

    private fun profileImageUpdate(imageVal : String) {

        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Uploading image....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(parentFragmentManager, "Loading Dialog")

        val call : Call<Profile> = retrofitconfig.endpoints.uploadsProImage(
            Constant.skey, maxPreference.UserMobileNum.toString(),
            maxPreference.UserToken!!, imageVal)
        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                updateProfilePicResponse=response.body()!!

                if(updateProfilePicResponse.status.equals("1")){
                    loadingDialog.dismiss()
                    Toast.makeText(context,"Uploads Successfully", Toast.LENGTH_SHORT).show()
                    System.out.println("message---------------------"+updateProfilePicResponse.message)

                    System.out.println("imageUrl----------------"+updateProfilePicResponse.data?.image?.url)

                    maxPreference.UserProfileImg = updateProfilePicResponse.data?.image?.url
                    Glide.with(this@ProfileFragment)
                        .load(updateProfilePicResponse.data?.image?.url)
                        .centerCrop()
                        .placeholder(R.drawable.default_maxpe_profile)
                        .into(imgUserProfile)

                }else{

                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Toast.makeText(context, updateProfilePicResponse.message, Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
            }

        })
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
            btnSubmit.setText("Update")
            dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            tvSkip.setOnClickListener {
                dismiss()
                maxUserPrefs.UserIsNew = "false"
            }

                 editFName.setText(maxUserPrefs.UserFName)
                 editLName.setText(maxUserPrefs.UserLName)
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