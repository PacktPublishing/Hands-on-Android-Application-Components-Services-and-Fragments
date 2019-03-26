package fragments.packt.com.factoryfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var fragmentInstance : BlankFragment = BlankFragment.newInstance("message to factory fragment")

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
