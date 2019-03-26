package fragment.packt.com.viewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {
    var fragmentInstance1 : BlankFragment = BlankFragment()
    var fragmentInstance2 : BlankFragment2 = BlankFragment2()
    var fragmentInstance3 : Fragment = Fragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager != null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragmentInstance1, "TAG!")
                    .addToBackStack(null)
                    .commit()
        }
    }

    fun ReplaceFragments(view: View){
        Log.d("Trace","Button Clicked")
        if (!fragmentInstance1.isAdded ){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance1 , "TAG!")
                    .addToBackStack(null)
                    .commit()
        }else if (!fragmentInstance2.isAdded ){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance2 , "TAG!")
                    .addToBackStack(null)
                    .commit()
        }
    }

    fun RemoveFragments(view: View){
        fragmentInstance3 = supportFragmentManager.findFragmentById(R.id.fragment_container) as Fragment
        Log.d("Trace","Fragment Remove Button Clicked")
        if (fragmentInstance3.isAdded ){
            Log.d("Trace","All Fragments Are Removed")
            supportFragmentManager.beginTransaction()
                    .remove(fragmentInstance3)
                    .commit()
        }
    }
}
