package kg.itc.examplemvvm.ui.weather.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.itc.examplemvvm.R
import kg.itc.examplemvvm.data.models.Constants
import kg.itc.examplemvvm.databinding.ItemDailyForecastBinding
import kg.itc.examplemvvm.domain.models.DailyForeCast
import kg.itc.examplemvvm.extensions.format
import kotlin.math.roundToInt

class DailyForeCastVH(private val binding: ItemDailyForecastBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DailyForeCast){
        binding.run {
            tvWeekday.text = item.date.format("dd/MM")
            item.probability?.let {
                tvPrecipitation.text = "${(it * 100).roundToInt()}%"
            }
            tvTempMax.text = item.temp?.max?.roundToInt()?.toString()
            tvMinTemp.text = item.temp?.min?.roundToInt()?.toString()


            Glide.with(itemView.context)
                .load("${Constants.iconUri}${item.weather?.get(0)?.icon}${Constants.iconFormat}")
                .into(ivWeatherIcon)

        }
    }


    companion object{
        fun create(parent: ViewGroup): DailyForeCastVH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_daily_forecast, parent, false)

            return DailyForeCastVH(ItemDailyForecastBinding.bind(view))
        }
    }

}