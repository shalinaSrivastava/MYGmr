package com.max.ecomaxgo.maxpe.view

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.ApiInterface.GetSelectIntentListener
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.fragment.TakePhotoFromCamORGallerySheet
import com.max.ecomaxgo.maxpe.model.Profile
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import com.theartofdev.edmodo.cropper.CropImage
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.lang.Exception

class UserProifle : AppCompatActivity(), View.OnClickListener,
    GetSelectIntentListener {
    private lateinit var llMinKycData: LinearLayout
    private lateinit var llKycCompleted: LinearLayout
    private lateinit var tvMyQrCode: TextView
    private lateinit var tvValidFullKyc: TextView
    private lateinit var imgBackProfile: ImageView
    private lateinit var tvProfileName: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var tvUserMob: TextView
    private lateinit var btnFullKyc: Button
    private lateinit var imgAddProfile: ImageView
    private lateinit var imgUserProfile: CircleImageView
    private lateinit var tvPersonalDetails: TextView
    private lateinit var tvMyAddress: TextView

    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var updateProfilePicResponse : Profile

    private val CAMERA_PERMISSION = 10004
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_proifle)
        initViews()
        maxPreference =
            MaxSharedPreference(this@UserProifle)

        //profile image displaying
        val profileImage = maxPreference.UserProfileImg
        System.out.println("profileImage----------------------------"+profileImage)
        Glide.with(this)
            .load(profileImage)
            .centerCrop()
            .placeholder(R.drawable.default_maxpe_profile)
            .into(imgUserProfile)

        tvUserMob.text = maxPreference.UserMobileNum
//----------------------------------------

    }

    private fun initViews() {
        imgBackProfile = findViewById(R.id.imgBackProfile)
        tvProfileName = findViewById(R.id.tvProfileName)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        tvUserMob = findViewById(R.id.tvUserMob)
        tvMyQrCode = findViewById(R.id.tvMyQrCode)
        tvValidFullKyc = findViewById(R.id.tvValidFullKyc)

        imgAddProfile = findViewById(R.id.imgAddProfile)
        tvMyAddress = findViewById(R.id.tvMyAddress)
        tvPersonalDetails = findViewById(R.id.tvPersonalDetails)
        btnFullKyc = findViewById(R.id.btnFullKyc)
        imgUserProfile = findViewById(R.id.imgUserProfile)

        llKycCompleted = findViewById(R.id.llKycCompleted)
        llMinKycData = findViewById(R.id.llMinKycData)

        imgAddProfile.setOnClickListener(View.OnClickListener {
            getPhotoSheet()
        })

        imgBackProfile.setOnClickListener(View.OnClickListener { finish() })
    }

    private fun getPhotoSheet(){
        val photoDialogFragment =
            TakePhotoFromCamORGallerySheet()
        photoDialogFragment.setPhotoFromListener(this)
        photoDialogFragment.show(supportFragmentManager, "Photo Sheet Dialog")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    override fun getValue(photoFrom: String) {
        if(photoFrom.equals("gallery")){
            takePictureFromGallery()
        }else if(photoFrom.equals("camera")){
            askPermissions()
        }else{
            //profileImageUpdate("")
            //imgUserProfile.setImageBitmap(null)
            //imgUserProfile.setImageResource(R.drawable.personicon)
        }
    }

    fun captureImage() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, 2005)
        }
    }

    private fun takePictureFromGallery(){
        try {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, 2007)
        } catch (e: Exception) {
            Toast.makeText(this@UserProifle, "Image Size is too large", Toast.LENGTH_SHORT).show()
        }
    }
    private lateinit var b: Bitmap
    private var mCameraFileName:String ?= null
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            2007 -> if (null != data && resultCode == Activity.RESULT_OK) {
                try {
                    val imageUri = data.data
                    Log.e("image uri", " :: $imageUri")
                    Glide.with(this)
                        .load(imageUri)
                        .centerCrop()
                        .placeholder(R.drawable.default_maxpe_profile)
                        .into(imgUserProfile)


                    // start cropping activity for pre-acquired image saved on the device
                    CropImage.activity(imageUri)
                        .start(this)

                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                    Toast.makeText(this@UserProifle, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
            2005 ->{

                if(data !=  null && resultCode == Activity.RESULT_OK){
                    val bitmap = data!!.extras?.get("data") as Bitmap
                    SaveImage(bitmap)
                }
            }
            else -> {
                if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                    val result = CropImage.getActivityResult(data)
                    if (resultCode == RESULT_OK) {
                        val resultUri = result.uri
                        val imageStream = contentResolver.openInputStream(resultUri!!)
                        b = BitmapFactory.decodeStream(imageStream)
                        imgUserProfile.setImageBitmap(b)
                        val baos = ByteArrayOutputStream()
                        b.compress(Bitmap.CompressFormat.JPEG, 60, baos)
                        val b2 = baos.toByteArray()

                        encoded = Base64.encodeToString(b2, Base64.DEFAULT)
                        profileImageUpdate(encoded!!)
                    } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                        val error = result.error
                        Log.e("crop error :: ", "$error")
                    }
                }
            }
        }
    }

    var encoded:String?=null
    private fun SaveImage(finalBitmap: Bitmap) {
        val root = Environment.getExternalStorageDirectory().toString()
        val myDir = File(root + "/Ecomaxgo/Camera")
        myDir.mkdirs()

        val username = maxPreference.MaxUserName!!.replace(" ", "_")
        val fname = username+"_qr" +".jpg";
        val file = File (myDir, fname)
        if (file.exists()) {
            file.delete ()
            Log.e("save bitmap ", " :: file exist")
        }
        Log.e("bitmap dir", " :: $myDir")
        Log.e("bitmap file", " :: $file")
        maxPreference.SaveQRBitmapPathRegister = file.toString()

        val byteArrayOutputStream = ByteArrayOutputStream()
        finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        encoded = Base64.encodeToString(byteArray, Base64.DEFAULT)

        Log.e("base64 string", " :: $encoded")
//        userimg.setImageBitmap(finalBitmap)

        CropImage.activity(Uri.fromFile(file))
            .start(this)
        try {
            val out = FileOutputStream(file)
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.flush()
            out.close()
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

    private fun profileImageUpdate(imageVal : String) {

        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Uploading image....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")

        val call : Call<Profile> = retrofitconfig.endpoints.uploadsProImage(Constant.skey, maxPreference.UserMobileNum.toString(),
            maxPreference.UserToken!!, imageVal)
        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                updateProfilePicResponse=response.body()!!

                if(updateProfilePicResponse.status.equals("1")){
                    loadingDialog.dismiss()
                    Toast.makeText(this@UserProifle,"Uploads Successfully",Toast.LENGTH_SHORT).show()
                    System.out.println("message---------------------"+updateProfilePicResponse.message)

                    System.out.println("imageUrl----------------"+updateProfilePicResponse.data?.image?.url)

                    maxPreference.UserProfileImg = updateProfilePicResponse.data?.image?.url
                    Glide.with(this@UserProifle)
                        .load(updateProfilePicResponse.data?.image?.url)
                        .centerCrop()
                        .placeholder(R.drawable.default_maxpe_profile)
                        .into(imgUserProfile)

                }else{

                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Toast.makeText(this@UserProifle,updateProfilePicResponse.message,Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
            }

        })
    }

    private fun askPermissions() {

        val permissionCheckStorage = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        val permissionCheckCamera = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )
        // we already asked for permisson & Permission granted, call camera intent
        if (permissionCheckStorage == PackageManager.PERMISSION_GRANTED && permissionCheckCamera == PackageManager.PERMISSION_GRANTED) {

            Log.e("check permission"," :: Permission Granted !!")
            captureImage()

        } //asking permission for the first time
        else if (permissionCheckStorage != PackageManager.PERMISSION_GRANTED && permissionCheckCamera != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                2001
            )

        } else {
            // Permission denied, so request permission

            // if camera request is denied
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("You need to give permission to take pictures in order to work this feature.")
                builder.setNegativeButton(
                    "CANCEL"
                ) { dialogInterface, i -> dialogInterface.dismiss() }
                builder.setPositiveButton("GIVE PERMISSION"
                ) { dialogInterface, i ->
                    dialogInterface.dismiss()

                    // Show permission request popup
                    ActivityCompat.requestPermissions(
                        this@UserProifle,
                        arrayOf(Manifest.permission.CAMERA),
                        2003
                    )
                }
                builder.show()

            }   // if storage request is denied
            else if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                val builder = androidx.appcompat.app.AlertDialog.Builder(this)
                builder.setMessage("You need to give permission to access storage in order to work this feature.")
                builder.setNegativeButton(
                    "CANCEL"
                ) { dialogInterface, i -> dialogInterface.dismiss() }
                builder.setPositiveButton("GIVE PERMISSION", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        dialogInterface.dismiss()

                        // Show permission request popup
                        ActivityCompat.requestPermissions(
                            this@UserProifle,
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            2002
                        )
                    }
                })
                builder.show()

            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            2003 -> if (grantResults.size > 0 && permissions[0] == Manifest.permission.CAMERA) {
                // check whether camera permission granted or not.
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

//                    Toast.makeText(this@Signup, "Please allow Camera Permission to capture Profile pic", Toast.LENGTH_SHORT).show()
                    //launchCamera()
                }
            }
            CAMERA_PERMISSION -> if (grantResults.size > 0 && permissions[0] == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                // check whether storage permission granted or not.
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

//                    launchCamera()
//                    Toast.makeText(this@Signup, "Please allow Storage Permission to show Profile pic", Toast.LENGTH_SHORT).show()
                }
            }
            2001 -> if (grantResults.size > 0 && permissions[0] == Manifest.permission.CAMERA && permissions[1] == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                // check whether All permission granted or not.
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                    launchCamera()
                    captureImage()
                }
            }
            else -> {
            }
        }
    }

}