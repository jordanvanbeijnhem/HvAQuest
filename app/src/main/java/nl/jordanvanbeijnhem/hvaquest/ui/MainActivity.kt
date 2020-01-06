package nl.jordanvanbeijnhem.hvaquest.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import nl.jordanvanbeijnhem.hvaquest.R
import nl.jordanvanbeijnhem.hvaquest.ui.viewmodels.QuestionsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViewModel()
        initNavigation()
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.navHostFragment)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(QuestionsViewModel::class.java)
        viewModel.getQuestions()
    }


    override fun onBackPressed() {
        val navController = findNavController(R.id.navHostFragment)
        if (navController.currentDestination!!.id == R.id.questionFragment) {
            viewModel.previousQuestion()
        }

        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> {
                onBackPressed()
                true
            }
        }
    }
}
