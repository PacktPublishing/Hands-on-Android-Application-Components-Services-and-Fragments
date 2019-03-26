package configurationchanges.packt.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

class MainActivity : AppCompatActivity() {

    var fragmentInstance: BlankFragment = BlankFragment()
    var fragmentInstance2: BlankFragment2 = BlankFragment2()

    var fragment1_Tag: String = "fragment1_Tag"
    var fragment2_Tag: String = "fragment2_Tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragmentInstance, fragment1_Tag)
                    .commit()
        }
    }

    fun RemoveClicked(view: View) {

        var fragment1: BlankFragment? = supportFragmentManager.findFragmentByTag(fragment1_Tag) as BlankFragment?
        var fragment2: BlankFragment2? = supportFragmentManager.findFragmentByTag(fragment2_Tag) as BlankFragment2?

        if (fragment2 != null && fragment2.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .remove(fragment2)
                    .commit()
        }
        if (fragment1 != null && fragment1.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .remove(fragment1)
                    .commit()
        }

    }

    fun FragmentClicked(view: View) {
        if (!fragmentInstance2.isAdded && !fragmentInstance.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance, fragment1_Tag)
                    .addToBackStack(null)
                    .commit()
        } else if (!fragmentInstance2.isAdded && fragmentInstance.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance2, fragment2_Tag)
                    .addToBackStack(null)
                    .commit()
        } else if (!fragmentInstance.isAdded && fragmentInstance2.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentInstance, fragment1_Tag)
                    .addToBackStack(null)
                    .commit()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
