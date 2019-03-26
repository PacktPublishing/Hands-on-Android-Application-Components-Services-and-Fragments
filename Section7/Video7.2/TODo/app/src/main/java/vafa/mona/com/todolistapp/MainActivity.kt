package vafa.mona.com.todolistapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AddNewTaskDialog.AddNewTaskDialogListener {


    override fun onSubmitClick(dialog: DialogFragment, mDsc: String, mReminder: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            addTaskDialog()
        }
    }

    fun addTaskDialog() {
        val mfragmentManager = supportFragmentManager
        val newFragment = AddNewTaskDialog.newInstance()
        newFragment.show(mfragmentManager, "newtask")
    }
}
