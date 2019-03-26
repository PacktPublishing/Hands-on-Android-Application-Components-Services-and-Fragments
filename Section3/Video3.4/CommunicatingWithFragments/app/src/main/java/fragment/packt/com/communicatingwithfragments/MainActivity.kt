package fragment.packt.com.communicatingwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(),BlankFragment.OnFragmentInteractionListener , BlankFragment2.OnFragmentInteractionListener2 {
    var fragmentInstance1 : BlankFragment = BlankFragment()
    var fragmentInstance2 : BlankFragment2 = BlankFragment2()
    var msgFromFrg1 : String? = null
    var msgFromFrg2 : String? = null

    override fun onFragmentInteraction(textFromFrg: String) {
        msgFromFrg1 = textFromFrg
        Log.d("Trace","Fragment1 Data Recieved")
    }

    override fun onFragmentInteraction2(textFromFrg2: String) {
        msgFromFrg2 = textFromFrg2
        Log.d("Trace","Fragment2 Data Recieved")
    }

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
          fragmentInstance1 = BlankFragment.newInstance(msgFromFrg2)
          Log.d("Trace","an instance of Fragment1 is created")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance1 , "TAG!")
                    .addToBackStack(null)
                    .commit()
        }else if (!fragmentInstance2.isAdded ){
           fragmentInstance2 = BlankFragment2.newInstance(msgFromFrg1)
            Log.d("Trace","an instance of Fragment2 is created")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance2 , "TAG!")
                    .addToBackStack(null)
                    .commit()
        }
    }
}
