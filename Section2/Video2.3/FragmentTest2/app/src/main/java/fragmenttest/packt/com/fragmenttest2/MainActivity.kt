package fragmenttest.packt.com.fragmenttest2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    var fragmentInstance: BlankFragment = BlankFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(!fragmentInstance.isAdded) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragmentInstance, "FragmentTest2")
                    .commit()
        }
    }

}
