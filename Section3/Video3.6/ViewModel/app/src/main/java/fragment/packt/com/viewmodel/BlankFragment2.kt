package fragment.packt.com.viewmodel

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragment2 : Fragment() {
    var model: SharedMessage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.let { ViewModelProviders.of(it).get(SharedMessage::class.java)}
        model!!.FragmentTwoMsg = "Hello Fragment 1"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_blank_fragment2, container, false)
        val myTextView: TextView = view.findViewById(R.id.txt_frg2)
        // Inflate the layout for this fragment
        myTextView.text = model!!.FragmentOneMsg
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Trace", "f2 Attached")


    }

    override fun onResume() {
        super.onResume()
        Log.d("Trace", "f2 Resumed")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Trace", "f2 stopped")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Trace", "f2 Paused")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Trace", "f2 Detached")

    }

}
