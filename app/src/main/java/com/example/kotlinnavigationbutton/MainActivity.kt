package com.example.kotlinnavigationbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kotlinnavigationbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding
    private val homeFragment=HomeFragment()
    private val profileFragment=ProfileFragment()
    private val studentFragment=StudentFragment()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        replaceFragment(homeFragment)

        binding.nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> {
                    replaceFragment(homeFragment)
                }

                R.id.menuProfile ->{
                    replaceFragment(profileFragment)
                }

                R.id.menuSchool -> {
                    replaceFragment(studentFragment)
                }
            }
            true
        }


    }

    private fun replaceFragment(fragment:Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment).commit()

        }

    }






}