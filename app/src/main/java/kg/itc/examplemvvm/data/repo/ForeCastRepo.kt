package kg.itc.examplemvvm.data.repo

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kg.itc.examplemvvm.data.models.ForeCastDto
import kg.itc.examplemvvm.data.network.ForeCastApi
import kg.itc.examplemvvm.data.storage.ForeCastDao
import javax.inject.Inject

class ForeCastRepo @Inject constructor(
    private val foreCastApi: ForeCastApi,
    private val foreCastDao: ForeCastDao
) {

    fun getForeCastFromApi(): Single<ForeCastDto> {
        return foreCastApi.fetchWeather()
            .subscribeOn(Schedulers.io())
    }

    fun getForeCastAsLiveData() = foreCastDao.getAll()
}