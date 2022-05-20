package kg.itc.examplemvvm.ui.weather.rv

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.itc.examplemvvm.data.models.Constants
import kg.itc.examplemvvm.databinding.ItemHourlyForecastBinding
import kg.itc.examplemvvm.domain.models.HourlyForeCast
import kg.itc.examplemvvm.extensions.format
import kotlin.math.roundToInt

class HourlyForecastVH(private val binding: ItemHourlyForecastBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HourlyForeCast){

        binding.run {
            tvTime.text = item.date.format("HH:mm")

            item.probability?.let {
                tvPrecipitation.text = "${(it *100).roundToInt()} %"
            }
            tvTemp.text = item.temp?.roundToInt().toString()
            Glide.with(itemView.context)
                .load("${Constants.iconUri}${item.weather?.get(0)?.icon}${Constants.iconFormat}")
                .into(ivWeatherIcon)
        }
    }
}