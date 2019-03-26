package vafa.mona.com.todolistapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AddNewTaskDialog.AddNewTaskDialogListener {

    var taskItems: ArrayList<String> = ArrayList()
    var mlistView: ListView? = null
    var mAdapter: ArrayAdapter<String>? = null

    override fun onSubmitClick(dialog: DialogFragment, mDsc: String) {
        taskItems.add(mDsc)
        mAdapter?.notifyDataSetChanged()
        startService()
    }

    private fun loadListView() {
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskItems)
        mlistView?.adapter = mAdapter
    }

    fun startService() {
        var intent = Intent(this, MyForegroundService::class.java)
        startService(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mlistView = findViewById(R.id.main_listview)
        loadListView()
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
