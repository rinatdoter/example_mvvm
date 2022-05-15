package kg.itc.examplemvvm.data.repo

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kg.itc.examplemvvm.data.models.ForeCastDto
import kg.itc.examplemvvm.data.network.ForeCastApi
import javax.inject.Inject

class ForeCastRepo @Inject constructor(
    private val foreCastApi: ForeCastApi
) {

    fun getForeCast(): Single<ForeCastDto> {
        return foreCastApi.fetchWeather()
            .subscribeOn(Schedulers.io())
    }
}