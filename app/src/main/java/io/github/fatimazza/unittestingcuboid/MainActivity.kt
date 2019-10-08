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

    override fun onClick(view: View) {
        val height = etHeight.text.toString().trim()
        val length = etLength.text.toString().trim()
        val width = etWidth.text.toString().trim()

        when {
            height.isEmpty() -> etHeight.error = getString(R.string.empty_field)
            length.isEmpty() -> etLength.error = getString(R.string.empty_field)
            width.isEmpty() -> etWidth.error = getString(R.string.empty_field)
            else -> {
                val h = height.toDouble()
                val l = length.toDouble()
                val w = width.toDouble()
                when {
                    view.id == R.id.btn_calculate_circumference -> {
                        tvResult.text = mainViewModel.getCircumference().toString()
                        hideCalculationButton()
                    }
                    view.id == R.id.btn_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        hideCalculationButton()
                    }
                    view.id == R.id.btn_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        hideCalculationButton()
                    }
                    view.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        showCalculationButton()
                    }
                }
            }
        }
    }

    private fun showCalculationButton() {
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnCalculateVolume.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun hideCalculationButton() {
        btnCalculateCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnCalculateVolume.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}
