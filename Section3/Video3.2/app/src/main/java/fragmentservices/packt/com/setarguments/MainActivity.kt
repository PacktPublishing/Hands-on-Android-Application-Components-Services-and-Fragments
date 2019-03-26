package fragmentservices.packt.com.setarguments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var fragmentInstance : BlankFragment = BlankFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ArgumentToPass : Bundle = Bundle()
        ArgumentToPass.putString("Key_Value","Passing Argument")
        if (supportFragmentManager != null){
            fragmentInstance.arguments = ArgumentToPass
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragmentInstance,"Tag")
                    .commit()
        }
    }
}
