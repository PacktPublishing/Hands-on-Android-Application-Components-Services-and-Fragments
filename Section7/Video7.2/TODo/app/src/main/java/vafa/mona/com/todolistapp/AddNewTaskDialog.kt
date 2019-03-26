package vafa.mona.com.todolistapp

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.dialog_fragment.*


/**
 * Created by ${Mona}
 */


class AddNewTaskDialog : DialogFragment() {

    interface AddNewTaskDialogListener {
        fun onSubmitClick(dialog: DialogFragment, mDsc: String,mReminder : Int)
    }
    var newTaskDialogListener: AddNewTaskDialogListener? = null


    companion object {
        fun newInstance(): AddNewTaskDialog {

            val newTaskDialogFragment = AddNewTaskDialog()
            val args = Bundle()
           // args.putInt("dialog_title")
            newTaskDialogFragment.arguments = args
            return newTaskDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val rootView =
            activity!!.layoutInflater.inflate(R.layout.dialog_fragment, null)
        val mTask_dsc = rootView.findViewById<EditText>(R.id.edt_task_dsc)
        val mReminder = rootView.findViewById<EditText>(R.id.edt_reminder)

        builder.setView(rootView)
            .setPositiveButton("submit") { dialog, id ->
                newTaskDialogListener?.onSubmitClick(this,mTask_dsc.text.toString(),mReminder.text.toString().toInt() )
            }
        return builder.create()
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            newTaskDialogListener = activity as AddNewTaskDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement AddNewTaskDialogListener")
        }

    }


}