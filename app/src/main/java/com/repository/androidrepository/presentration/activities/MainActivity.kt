package com.repository.androidrepository.presentration.activities


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.repository.androidrepository.R
import com.repository.androidrepository.databinding.ActivityMainBinding
import com.repository.androidrepository.usecase.BottomNavBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val frameLayout = findViewById<View>(R.id.nav_host_fragment_activity_main) as FrameLayout

        val bottomNavBar: BottomNavBar.OnBottomNavigationListener =
            BottomNavBar.OnBottomNavigationListener {
                when (it.getItemId()) {

                    R.id.search_data -> {
                        navController.navigate(R.id.Repository_list_search)
                    }


                }
                NavigationUI.onNavDestinationSelected(it, navController)
                return@OnBottomNavigationListener true
            }

        val bottomNavView: BottomNavBar = findViewById(R.id.bottom_nav_view)
        bottomNavView.setBottomNavigationListener(bottomNavBar)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.Repository_view) {

                bottomNavView.visibility = View.GONE
                setMargins(frameLayout,0,0,0,0)
            }
            else{
                bottomNavView.visibility = View.VISIBLE
                setMargins(frameLayout,0,0,0,0)
            }
        }



    }

    private fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val p = view.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            view.requestLayout()
        }
    }



}
