package si.um.feri.porampchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import si.um.feri.porampchart.databinding.ActivityMainBinding
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addHistogram()
    }

    fun createHistogramDataSet(binCount: Int, data: List<Float>, min: Float, binSize: Float): BarDataSet {
        val bins = IntArray(binCount)
        for (value in data) {
            val index = floor((value - min) / binSize).toInt().coerceAtMost(binCount - 1)
            bins[index]++
        }

        val entries = mutableListOf<BarEntry>()
        for (i in bins.indices) {
            entries.add(BarEntry(i.toFloat(), bins[i].toFloat()))
        }

        return BarDataSet(entries, "")
    }

    fun setValueFormatter(barChart: BarChart, binCount: Int, min: Float, binSize: Float) {
        barChart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                val index = value.toInt()
                if (index !in 0..<binCount) return ""

                val left = min + index * binSize
                return String.format("%.2f–", left)
            }
        }
    }

    fun addHistogram() {
        val barChart = binding.barChart

        val data = listOf(1.13f, 2.4f, 2.56f, 2.69f, 2.76f, 2.9f, 2.956f, 3.0f,
            3.0f, 3.007f, 3.1f, 3.3f, 3.4f, 3.419f, 4.0f)

        // Data prep
        val binCount = 8
        val min = data.minOrNull() ?: 0f
        val max = data.maxOrNull() ?: 0f
        val binSize = (max - min) / binCount

        val dataSet = createHistogramDataSet(binCount, data, min, binSize)
        dataSet.color = Color.BLUE
        dataSet.setDrawValues(false)

        val barData = BarData(dataSet)
        barData.barWidth = 0.9f

        barChart.data = barData

        //Graph settings
        barChart.apply {
            description.isEnabled = false
            axisRight.isEnabled = false
            legend.isEnabled = false
            isDoubleTapToZoomEnabled = false
        }

        setValueFormatter(barChart, binCount, min, binSize)

        barChart.xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            granularity = 1f
            setDrawGridLines(false)
            setDrawAxisLine(true)
        }

        barChart.axisLeft.apply {
            granularity = 1f
            axisMinimum = 0f
        }

        barChart.invalidate() //redraw chart
    }
}