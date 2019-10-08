package io.github.fatimazza.unittestingcuboid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val etHeight: EditText
        get() = edt_height

    private val etLength: EditText
        get() = edt_length

    private val etWidth: EditText
        get() = edt_width

    private val tvResult: TextView
        get() = tv_result

    private val btnCalculateCircumference: Button
        get() = btn_calculate_circumference

    private val btnCalculateSurfaceArea: Button
        get() = btn_calculate_surface_area

    private val btnCalculateVolume: Button
        get() = btn_calculate_volume

    private val btnSave: Button
        get() = btn_save

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewAndListener()
    }

    private fun initViewAndListener() {
        mainViewModel = MainViewModel(CuboidModel())
        btnCalculateCircumference.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
