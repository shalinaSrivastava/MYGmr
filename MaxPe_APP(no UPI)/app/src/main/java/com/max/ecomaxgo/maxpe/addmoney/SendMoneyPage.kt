package com.max.ecomaxgo.maxpe.addmoney

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SendMoneyPage : AppCompatActivity() {

    private lateinit var imgBackAddMoney: ImageView
    private lateinit var edtMobNumber: EditText
    private lateinit var imgGetContacts: ImageView
    private lateinit var btnSendMoney: Button
    private lateinit var maxPreference: MaxSharedPreference

    private lateinit var tvAvailableAmount: TextView
    private lateinit var tvFundTransferLimit: TextView
    private lateinit var edtSendAmount: EditText
    lateinit var sendAmountAmount: TransferWallet
    lateinit var mob_number: String
    lateinit var userToken: String

    companion object {
        const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
        const val PICK_CONTACT = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money_page)
        initViews()

        maxPreference =
            MaxSharedPreference(this@SendMoneyPage)

        mob_number = maxPreference.UserMobileNum.toString()
        userToken = maxPreference.UserToken.toString()
        if (intent.getStringExtra("fromPage").equals("Scanner", true)) {
            edtMobNumber.setText(intent.getStringExtra("mobNum"))
        }

        imgBackAddMoney.setOnClickListener { finish() }
        val amount = maxPreference.AddMoneyAmountToWallet
        tvAvailableAmount.text = "MaxPe Balance ₹ " + amount
//        val afterDecimalValue = amount!!.substring(amount.indexOf(".")).substring(1)
//        Log.e("value after decimal", " :: $afterDecimalValue")
//
//        val dotValuetoInt = afterDecimalValue.toInt()
//        Log.e("valeu", " :: ${dotValuetoInt}")
//
//        if (dotValuetoInt == 0){
//            if(amount.startsWith("0.")){
//                tvAvailableAmount.text = "Available Balance ₹ 0"
//            }else{
//                val floatVal = amount.toDouble()
//                tvAvailableAmount.text = "Available Balance ₹ ${floatVal.toLong()}"
//            }
//        }else{
//            tvAvailableAmount.text = "Available Balance ₹ ${amount}"
//        }
//        tvFundTransferLimit.text = "Fund Transfer Limit ₹ ${maxPreference.WalletFundTranserLimit}"

    }

    private fun initViews() {
        imgBackAddMoney = findViewById(R.id.imgBackAddMoney)
        edtMobNumber = findViewById(R.id.edtMobNumber)
        imgGetContacts = findViewById(R.id.imgGetContacts)
        btnSendMoney = findViewById(R.id.btnSendMoney)
        tvAvailableAmount = findViewById(R.id.tvAvailableAmount)
        edtSendAmount = findViewById(R.id.edtSendAmount)
        tvFundTransferLimit = findViewById(R.id.tvFundTransferLimit)

        btnSendMoney.setOnClickListener(View.OnClickListener {
            val mobNum = edtMobNumber.text.toString()
            if(mobNum.equals(mob_number)){
                Toast.makeText(this@SendMoneyPage, "You don't send money on your own Number", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty(edtSendAmount.text.toString())) {
                Toast.makeText(this@SendMoneyPage, "Please enter amount to pay", Toast.LENGTH_SHORT)
                    .show()
            }else if((edtSendAmount.text.toString().toDouble()).toInt() <= 0) {
                Toast.makeText(this@SendMoneyPage, "Please send valid amount", Toast.LENGTH_SHORT)
                    .show()
            }else if (TextUtils.isEmpty(mobNum)){
                Toast.makeText(this@SendMoneyPage, "Please enter Mobile Number", Toast.LENGTH_SHORT).show()
            }else if (mobNum.length < 10){
                Toast.makeText(this@SendMoneyPage, "Please enter valid Mobile Number", Toast.LENGTH_SHORT).show()
            }
            else{
                transWalletTo(mob_number, edtSendAmount.text.toString(), edtMobNumber.text.toString())
            }
        })

        imgGetContacts.setOnClickListener(View.OnClickListener {
            loadContacts()
        })
    }

    private fun transWalletTo(mob_no: String, amount: String, sendMobNo: String) {
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Send Money....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")
        val call: Call<TransferWallet> =
            retrofitconfig.endpoints.sendMoneyWalletToWallet(
                Constant.skey,
                mob_no,
                userToken,
                amount,
                sendMobNo
            )
        call.enqueue(object : Callback<TransferWallet> {
            override fun onResponse(call: Call<TransferWallet>, response: Response<TransferWallet>) {
                sendAmountAmount = response.body()!!
                Log.e("login response ", " :: ${response.body()}")
                if (sendAmountAmount.status.equals("1")) {
                    loadingDialog.dismiss()
                    Toast.makeText(this@SendMoneyPage, sendAmountAmount.message, Toast.LENGTH_LONG)
                        .show()
                    tvAvailableAmount.text = "Available Balance ₹ " + sendAmountAmount.data!!.wallet!!.amount

                    val intent = Intent(this@SendMoneyPage, SendSuccessfulyActivity::class.java)
                    intent.putExtra("recharge_no", sendAmountAmount.data!!.sent_to)
                    intent.putExtra("message", sendAmountAmount.message)
                    intent.putExtra("amount", amount)
                    startActivity(intent)
                    finish()
                } else if (sendAmountAmount.status.equals("0")) {
                    loadingDialog.dismiss()
                    Toast.makeText(this@SendMoneyPage, sendAmountAmount.message, Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<TransferWallet>, t: Throwable) {
                loadingDialog.dismiss()
            }
        })
    }

    //get contact function call
    private fun loadContacts() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
            //callback onRequestPermissionsResult
        } else {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent,
                PICK_CONTACT
            )
            // number.setText(builder.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                val contactData = data!!.data
                var numbers = ""
                val cursor = contentResolver.query(contactData!!, null, null, null, null);
                cursor!!.moveToFirst()
                val hasPhone =
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                val contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                if (hasPhone.equals("1")) {
                    val phones = getContentResolver().query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                + " = " + contactId, null, null
                    )

                    while (phones!!.moveToNext()) {
                        numbers = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace("[-() ]", "")
                    }

                    if (numbers.startsWith("+")) {
                        if (numbers.length == 13) {
                            val str_getMOBILE = numbers . substring (3)
                            edtMobNumber.setText(str_getMOBILE);
                        } else if (numbers.length == 14) {
                            val str_getMOBILE = numbers . substring (4)
                            edtMobNumber.setText(str_getMOBILE.replace(Regex("[()\\-\\s]"), ""));
                        }
                        else if (numbers.length == 15) {
                            val str_getMOBILE = numbers . substring (4)
                            edtMobNumber.setText(str_getMOBILE.replace(Regex("[()\\-\\s]"), ""));
                        }
                        else if (numbers.length == 16) {
                            val str_getMOBILE = numbers . substring (4)
                            edtMobNumber.setText(str_getMOBILE.replace(Regex("[()\\-\\s]"), ""));
                        }
                    } else {
                        if (numbers.startsWith("0")){
                            val numVal = numbers.substring(1)
                            edtMobNumber.setText(numVal.replace(Regex("[()\\-\\s]"), ""))
                        }else{
                            if(numbers.length ==11){
                                edtMobNumber.setText(numbers.replace(Regex("[()\\-\\s]"), ""))
                            }else if(numbers.length ==12){
                                edtMobNumber.setText(numbers.replace(Regex("[()\\-\\s]"), ""))
                            }else{
                                edtMobNumber.setText(numbers)
                            }
                        }
                    }

                    Log.e("number val", " :: $numbers")
//                        val input = numbers.replace(Regex("[()\\-\\s]"), "")

                    phones.close()

                } else {
                    Toast.makeText(getApplicationContext(), "This contact has no phone number", Toast.LENGTH_LONG)
                        .show();
                }
                cursor.close();
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                //  toast("Permission must be granted in order to display contacts information")
            }
        }
    }
}