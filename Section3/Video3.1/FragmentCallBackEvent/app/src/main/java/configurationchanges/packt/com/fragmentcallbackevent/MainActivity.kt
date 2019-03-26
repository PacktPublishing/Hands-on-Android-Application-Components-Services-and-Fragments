package configurationchanges.packt.com.fragmentcallbackevent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BlankFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(someText: String) {
        txt_main.text = someText
    }


    var fragmentInstance : BlankFragment = BlankFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager != null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragmentInstance,"Tag")
                    .commit()
        }
    }
}
