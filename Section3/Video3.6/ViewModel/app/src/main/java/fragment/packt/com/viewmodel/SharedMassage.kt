package fragment.packt.com.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log

/**
 * Created by ${Mona}
 */
class SharedMessage : ViewModel(){

    var FragmentOneMsg = ""
    var FragmentTwoMsg = ""

    override fun onCleared() {
        super.onCleared()
        Log.d("Trace","ViewModel Got Cleared")
    }
}