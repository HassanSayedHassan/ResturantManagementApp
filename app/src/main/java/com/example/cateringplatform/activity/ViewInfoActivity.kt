package com.example.cateringplatform.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.cateringplatform.R
import kotlinx.android.synthetic.main.activity_view_info.*

class ViewInfoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_info)

        rl_back.setOnClickListener(View.OnClickListener {

            onBackPressed()
        })

        var name:String = intent.getStringExtra("Name")
        var status:Int = intent.getIntExtra("Status",-1)
        var startTime:String = intent.getStringExtra("StartTime")
        var endTime:String = intent.getStringExtra("EndTime")
        var minOrder:Int = intent.getIntExtra("MinimumOrder",-1)
        var deliVharge:Int = intent.getIntExtra("DeliveryCharge",-1)
        var cardDelivery:Int = intent.getIntExtra("CardDelivery",-1)
        var cashDelivery:Int = intent.getIntExtra("CashDelivery",-1)
        var cuisines:String = intent.getStringExtra("Cuisines")

        if (status==1){

            tv_status_info.text = "Open"
        } else{
            tv_status_info.text = "Closed"
        }

        tv_opening_hours.text=startTime+" - "+endTime
        tv_minimum_order_info.text= ""+minOrder+" SAR"
        tv_delivery_charge_info.text=""+deliVharge+" SAR"

        if (cashDelivery== 1 && cardDelivery == 1) {
            tv_payment_info.text = "Bank transfer, Card"
        } else if (cashDelivery == 1 && cardDelivery == 0) {
            tv_payment_info.text = "Bank transfer"
        } else if (cashDelivery== 0 && cardDelivery == 1) {
            tv_payment_info.text = "Card"
        } else {
            rl_payment.visibility = View.GONE
        }


        tv_resturant_name_info.text=name
        tv_cuisines_info.text=cuisines

    }
}