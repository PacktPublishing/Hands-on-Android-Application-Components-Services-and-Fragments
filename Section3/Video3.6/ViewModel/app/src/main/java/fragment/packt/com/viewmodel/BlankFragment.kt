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

class BlankFragment : Fragment() {
    var model : SharedMessage? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.let { ViewModelProviders.of(it).get(SharedMessage::class.java)}
        model!!.FragmentOneMsg = "Hello Fragment 2"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_blank, container, false)
        val myTextView: TextView = view.findViewById(R.id.txt_frg)
        // Inflate the layout for this fragment
        myTextView.text = model!!.FragmentTwoMsg
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Trace","f1 Attached")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Trace","f1 Detached")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Trace","f1 Resumed")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Trace","f1 stopped")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Trace","f1 Paused")
    }

}
