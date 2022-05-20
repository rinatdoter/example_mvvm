package kg.itc.examplemvvm.ui.weather

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.examplemvvm.R
import kg.itc.examplemvvm.data.models.Constants
import kg.itc.examplemvvm.databinding.FragmentWeatherBinding
import kg.itc.examplemvvm.domain.models.ForeCast
import kg.itc.examplemvvm.extensions.format
import kg.itc.examplemvvm.ui.base.BaseFragment
import kg.itc.examplemvvm.ui.weather.rv.DailyForeCastAdapter
import kg.tutorialapp.weather.ui.rv.HourlyForecastAdapter
import kotlin.math.roundToInt

@AndroidEntryPoint
class WeatherFragment: BaseFragment<WeatherVM, FragmentWeatherBinding>(
    WeatherVM::class.java,
    {
        FragmentWeatherBinding.inflate(it)
    }
) {


    private lateinit var dailyForeCastAdapter: DailyForeCastAdapter
    private lateinit var hourlyForecastAdapter: HourlyForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dailyForeCastAdapter = DailyForeCastAdapter()
        hourlyForecastAdapter = HourlyForecastAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupRecyclerViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        binding.tvRefresh.setOnClickListener {
            vm.fetchForeCast()
        }
    }

    private fun setupRecyclerViews(){
        binding.rvDailyForecast.adapter = dailyForeCastAdapter
        binding.rvHourlyForecast.adapter = hourlyForecastAdapter
    }


    private fun subscribeToLiveData() {
        vm.foreCast.observe(viewLifecycleOwner,  {
            it?.let {
                setValuesToViews(it)
                loadWeatherIcon(it)
                setDataToRecyclerViews(it)
            }
        })

    }

    private fun setDataToRecyclerViews(it: ForeCast) {
        it.daily?.let { dailyList ->
            dailyForeCastAdapter.setItems(dailyList)
        }

        it.hourly?.let { hourlyList ->
            hourlyForecastAdapter.setItems(hourlyList)
        }
    }

     override fun showLoading() {
        binding.progress.run {
            post {
               visibility = View.VISIBLE
            }
        }
    }

   override fun hideLoading(){
        binding.progress.run {
            post {
                visibility = View.GONE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setValuesToViews(it: ForeCast) {
        binding.run {
            tvTemperature.text = it.temperature
            tvDate.text = it.currentDate
            tvTempMax.text = it.tempMax
            tvTempMin.text = it.tempMin
            tvFeelsLike.text = it.feelsLike
            tvWeather.text = it.weatherDescription
            tvSunsrise.text = it.sunrise
            tvSunset.text = it.sunset
            tvHumidity.text = it.humidity + getString(R.string.percentage )
        }

    }

    private fun loadWeatherIcon(it: ForeCast) {
        it.current?.weather?.get(0)?.icon?.let { icon ->
            Glide.with(this)
                .load("${Constants.iconUri}${icon}${Constants.iconFormat}")
                .into(binding.ivWeatherIcon)
        }
    }

}