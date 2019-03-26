package fragmentservices.packt.com.setarguments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_blank, container, false)
        val myTextView : TextView = view.findViewById(R.id.txt_fragment_main)
        // Inflate the layout for this fragment
        val myBundle :Bundle? = arguments
        myTextView.text = myBundle?.getString("Key_Value")
        return view
    }


}
