package configurationchanges.packt.com.fragmentfactorymethod

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var fragmentInstance : BlankFragment2 = BlankFragment2.newInstance("Massage to factory method")

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
