package fragmenttest.packt.com.addremovefragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var fragmentInstance: BlankFragment =  BlankFragment()
    var fragmentInstance2: BlankFragment2 =  BlankFragment2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragmentInstance, "fragmentTest2")
                    .addToBackStack(null)
                    .commit()
        }
    }
    fun FragmentClicked(view: View){
        if(!fragmentInstance2.isAdded){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance2, "fragmentTest2")
                    .addToBackStack(null)
                    .commit()
        }else{
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance, "fragmentTest2")
                    .addToBackStack(null)
                    .commit()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}




