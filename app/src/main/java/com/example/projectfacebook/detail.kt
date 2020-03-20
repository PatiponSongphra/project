package com.example.projectfacebook

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide


class detail : Fragment() {

    private var image:String ?= null

    fun newInstance(url: String): detail {
        val detail = detail()
        val bundle = Bundle()
        bundle.putString("image", url)
        detail.setArguments(bundle)
        return detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle != null){
            this.image = bundle.getString("image").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_detail, container, false)
        var image_view :ImageView = view.findViewById(R.id.img)
        Glide.with(activity!!.baseContext).load(image).into(image_view)

        val dia: Button = view.findViewById(R.id.button)
        dia.setOnClickListener{
            val builder: AlertDialog.Builder =  AlertDialog.Builder(this.context)
            builder.setMessage("Download Now")

            builder.setNegativeButton("Yes",
                DialogInterface.OnClickListener{ dialog, id ->
                    Toast.makeText(this.context,"Thank You", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                })

            builder.setPositiveButton("No",
                DialogInterface.OnClickListener{ dialog, id ->
                    Toast.makeText(this.context,"Thank You", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                })
            builder.show();

        }
        return view
    }


}
