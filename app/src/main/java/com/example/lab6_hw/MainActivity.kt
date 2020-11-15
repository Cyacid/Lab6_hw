package com.example.lab6_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    class Data(_photo: Int, _name: String){
        var photo : Int = _photo
        var name : String = _name
    }

    class  MyAdapter : BaseAdapter{
        private var data : Array<Data>
        private var view : Int

        constructor(view: Int, data: Array<Data>) {
            this.data = data
            this.view = view
        }

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(p0: Int): Any {
            return data[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val ConvertView = LayoutInflater.from(parent?.context).inflate(view, parent, false)
            val name: TextView = ConvertView.findViewById(R.id.name)
            name.text = data[position].name
            val imageView: ImageView = ConvertView.findViewById(R.id.imageView)
            imageView.setImageResource(data[position].photo)
            return ConvertView

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transNameArray : Array<String> = arrayOf("腳踏車","機車","汽車","巴士")
        val transPhotoIdArray : Array<Int> = arrayOf(R.drawable.trans1,R.drawable.trans2
            ,R.drawable.trans3,R.drawable.trans4)
        val transData : Array<Data>  =  Array(transNameArray.size){Data(0,"A")}

        for (i : Int in  transNameArray.indices){
            transData[i].name = transNameArray[i]
            transData[i].photo = transPhotoIdArray[i]
        }
        val transAdapter =  MyAdapter(R.layout.trans_list,transData)
        val spinner : Spinner = findViewById(R.id.spinner)
        spinner.adapter = transAdapter

        val messageArray : Array<String> = arrayOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6")

        val messageAdapter : ArrayAdapter<String> =  ArrayAdapter(this,
            android.R.layout.simple_list_item_1,messageArray)
        val listView : ListView = findViewById(R.id.listView)
        listView.adapter =messageAdapter

        val cubeeNameArray : Array<String> = arrayOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        val cubeePhotoIdArray : Array<Int> = arrayOf(R.drawable.cubee1,R.drawable.cubee2,
            R.drawable.cubee3,R.drawable.cubee4,R.drawable.cubee5,R.drawable.cubee6,
            R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10)
        val cubeeData : Array<Data>  =  Array(cubeeNameArray.size){Data(0,"A")}

        for (i : Int in  cubeeNameArray.indices){
            cubeeData[i].name = cubeeNameArray[i]
            cubeeData[i].photo = cubeePhotoIdArray[i]
        }

        val cubeeAdapter =  MyAdapter(R.layout.cubee_list,cubeeData)

        val gridView : GridView  = findViewById(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3


    }
}
