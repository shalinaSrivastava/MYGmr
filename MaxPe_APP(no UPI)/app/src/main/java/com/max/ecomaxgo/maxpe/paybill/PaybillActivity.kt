package com.max.ecomaxgo.maxpe.paybill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.dth.DthMainActivity
import com.max.ecomaxgo.maxpe.prepaid.MobilePrepaidActivity
import kotlinx.coroutines.newFixedThreadPoolContext

class PaybillActivity : AppCompatActivity() {

    private lateinit var ivImage: ImageView
    private lateinit var cardElectricity: CardView
    private lateinit var cardViewDTH: CardView
    private lateinit var cardViewGas: CardView
    private lateinit var cardViewWater: CardView
    private lateinit var cardMobileRecharge: CardView
    private lateinit var cardInsurance: CardView
    private lateinit var cardLpGas: CardView
    private lateinit var cardMunicipal: CardView
    private lateinit var cardCableTV: CardView
    private lateinit var cardFastag: CardView
    private lateinit var cardDebitCard: CardView
    private lateinit var cardSubscription: CardView
    private lateinit var cardMunicipalService: CardView
    private lateinit var cardLoanRepay: CardView
    private lateinit var cardHousing: CardView
    private lateinit var cardClub: CardView
    private lateinit var cardHospital: CardView
    private lateinit var cardLife: CardView
    private lateinit var cardLanline: CardView
    private lateinit var cardPostpaid: CardView
    private lateinit var cardBroadBand: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paybill)

        initeView()
    }
    private fun initeView(){
        ivImage = findViewById(R.id.ivImage)
        cardElectricity = findViewById(R.id.cardElectricity)
        cardViewDTH = findViewById(R.id.cardViewDTH)
       // cardViewGas = findViewById(R.id.cardViewGas)
        cardViewWater = findViewById(R.id.cardViewWater)
        cardMobileRecharge = findViewById(R.id.cardMobileRecharge)
        cardInsurance = findViewById(R.id.cardInsurance)
        cardLpGas = findViewById(R.id.cardLpGas)
        cardMunicipal = findViewById(R.id.cardMunicipal)
        cardCableTV = findViewById(R.id.cardCableTV)
        cardFastag = findViewById(R.id.cardFastag)
        cardDebitCard = findViewById(R.id.cardDebitCard)
        cardSubscription = findViewById(R.id.cardSubscription)
        cardMunicipalService = findViewById(R.id.cardMunicipalService)
        cardLoanRepay = findViewById(R.id.cardLoanRepay)
        cardHousing = findViewById(R.id.cardHousing)
        cardClub = findViewById(R.id.cardClub)
        cardHospital = findViewById(R.id.cardHospital)
        cardLife = findViewById(R.id.cardLife)
        cardLanline = findViewById(R.id.cardLanline)
        cardPostpaid = findViewById(R.id.cardPostpaid)
        cardBroadBand = findViewById(R.id.cardBroadBand)
        ivImage.setOnClickListener(View.OnClickListener { finish() })

        cardBroadBand.setOnClickListener(View.OnClickListener {
            val intentPostpaid = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentPostpaid.putExtra("category", "Broadband Postpaid")
            startActivity(intentPostpaid)
        })
        cardPostpaid.setOnClickListener(View.OnClickListener {
            val intentPostpaid = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentPostpaid.putExtra("category", "Mobile Postpaid")
            startActivity(intentPostpaid)
        })
        cardLanline.setOnClickListener(View.OnClickListener {
            val intentElectricity = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentElectricity.putExtra("category", "Landline Postpaid")
            startActivity(intentElectricity)
        })
        cardElectricity.setOnClickListener(View.OnClickListener {
            val intentElectricity = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentElectricity.putExtra("category", "Electricity")
            startActivity(intentElectricity)
        })
        cardViewDTH.setOnClickListener(View.OnClickListener {
            val intentDth = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentDth.putExtra("category", "DTH")
            startActivity(intentDth)
        })
     /*   cardViewGas.setOnClickListener(View.OnClickListener {
            val intentDth = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentDth.putExtra("category", "Gas")
            startActivity(intentDth)
        })*/

        cardViewWater.setOnClickListener(View.OnClickListener {
            val intentDth = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentDth.putExtra("category", "Water")
            startActivity(intentDth)
        })

        cardMobileRecharge.setOnClickListener(View.OnClickListener {
            val intentPrepaid = Intent(this@PaybillActivity, MobilePrepaidActivity::class.java)
            startActivity(intentPrepaid)
        })

        cardInsurance.setOnClickListener(View.OnClickListener {
            val intentDth = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentDth.putExtra("category", "Insurance")
            startActivity(intentDth)
        })

        cardLpGas.setOnClickListener(View.OnClickListener {
            val intentDth = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentDth.putExtra("category", "LPG Gas")
            startActivity(intentDth)
        })


        cardMunicipal.setOnClickListener(View.OnClickListener {
            val intentMunicipal = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentMunicipal.putExtra("category", "Municipal Taxes")
            startActivity(intentMunicipal)
        })

        cardCableTV.setOnClickListener(View.OnClickListener {
            val intentCableTv = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentCableTv.putExtra("category", "Cable TV")
            startActivity(intentCableTv)
        })

        cardFastag.setOnClickListener(View.OnClickListener {
            val intentFastag = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentFastag.putExtra("category", "Fastag")
            startActivity(intentFastag)
        })

        cardDebitCard.setOnClickListener(View.OnClickListener {
            val intentCard = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentCard.putExtra("category", "Credit Card")
            startActivity(intentCard)
        })

        cardSubscription.setOnClickListener(View.OnClickListener {
            val intentSub = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentSub.putExtra("category", "Subscription")
            startActivity(intentSub)
        })

        cardMunicipalService.setOnClickListener(View.OnClickListener {
            val intentMunicipal = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentMunicipal.putExtra("category", "Municipal Services")
            startActivity(intentMunicipal)
        })

        cardLoanRepay.setOnClickListener(View.OnClickListener {
            val intentLoan = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentLoan.putExtra("category", "Loan Repayment")
            startActivity(intentLoan)
        })

        cardHousing.setOnClickListener(View.OnClickListener {
            val intentHousing = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentHousing.putExtra("category", "Housing Society")
            startActivity(intentHousing)
        })

        cardClub.setOnClickListener(View.OnClickListener {
            val intentClub = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentClub.putExtra("category", "Clubs and Associations")
            startActivity(intentClub)
        })

        cardHospital.setOnClickListener(View.OnClickListener {
            val intentHospital = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentHospital.putExtra("category", "Hospital and Pathology")
            startActivity(intentHospital)
        })

        cardLife.setOnClickListener(View.OnClickListener {
            val intentLife = Intent(this@PaybillActivity, DthMainActivity::class.java)
            intentLife.putExtra("category", "Life Insurance")
            startActivity(intentLife)
        })
    }
}