package com.example.wufy

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.wufy.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvAdapter:PopularAdapter
    private lateinit var dataList:ArrayList<Recipe>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        binding.search.setOnClickListener {
            startActivity(Intent(this,SearchActivity::class.java))
        }
        binding.america.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","America")
            intent.putExtra("CATEGORY","America")
            startActivity(intent)
        }
        binding.australia.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Australia")
            intent.putExtra("CATEGORY","Australia")
            startActivity(intent)
        }
        binding.china.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","China")
            intent.putExtra("CATEGORY","China")
            startActivity(intent)

        }
        binding.egypt.setOnClickListener {
            var intent = Intent(this@HomeActivity, CategoryActivity::class.java)
            intent.putExtra("TITTLE", "Egypt")
            intent.putExtra("CATEGORY", "Egypt")
            startActivity(intent)
        }
        binding.england.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","England")
            intent.putExtra("CATEGORY","England")
            startActivity(intent)
        }
        binding.france.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","France")
            intent.putExtra("CATEGORY","France")
            startActivity(intent)
        }
        binding.india.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","India")
            intent.putExtra("CATEGORY","India")
            startActivity(intent)
        }
        binding.iran.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Iran")
            intent.putExtra("CATEGORY","Iran")
            startActivity(intent)
        }
        binding.italy.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Italy")
            intent.putExtra("CATEGORY","Italy")
            startActivity(intent)
        }
        binding.japan.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Japan")
            intent.putExtra("CATEGORY","Japan")
            startActivity(intent)
        }
        binding.mexico.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Mexico")
            intent.putExtra("CATEGORY","Mexico")
            startActivity(intent)
        }
        binding.russia.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Russia")
            intent.putExtra("CATEGORY","Russia")
            startActivity(intent)
        }
        binding.rwanda.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Rwanda")
            intent.putExtra("CATEGORY","Rwanda")
            startActivity(intent)
        }
        binding.spain.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Spain")
            intent.putExtra("CATEGORY","Spain")
            startActivity(intent)
        }
        binding.turkey.setOnClickListener {
            var intent=Intent(this@HomeActivity,CategoryActivity::class.java)
            intent.putExtra("TITTLE","Turkey")
            intent.putExtra("CATEGORY","Turkey")
            startActivity(intent)
        }
        binding.more.setOnClickListener {
            var dialog=Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.bottom_sheet)
            dialog.show()
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.BOTTOM)
        }
    }

    private fun setUpRecyclerView() {
        dataList= ArrayList()

        binding.rvPopular.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var db=Room.databaseBuilder(this@HomeActivity,AppDatabase::class.java,"db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()
        var daoObject=db.getDao()
        var recipes=daoObject.getAll()
        for (i in recipes!!.indices){
            if (recipes[i]!!.category.contains("Popular")){
                dataList.add(recipes[i]!!)
            }
            rvAdapter=PopularAdapter(dataList,this)
            binding.rvPopular.adapter=rvAdapter

        }
    }
}