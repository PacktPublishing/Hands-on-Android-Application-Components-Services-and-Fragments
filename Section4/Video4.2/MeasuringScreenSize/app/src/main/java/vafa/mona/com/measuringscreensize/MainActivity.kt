package vafa.mona.com.measuringscreensize

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MeasureScreen()
    }
    fun MeasureScreen(){
        var Width : Float
        var Height : Float
        val dimension : Display = this.windowManager.defaultDisplay
        val metrics : DisplayMetrics = DisplayMetrics()
        val density : Float = this.resources.displayMetrics.density
        dimension.getMetrics(metrics)

        Width = metrics.widthPixels / density
        Height = metrics.heightPixels / density

        Toast.makeText(this,"width: $Width, height: $Height",Toast.LENGTH_LONG).show()
   }
    
}
