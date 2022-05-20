package kg.itc.examplemvvm.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.itc.examplemvvm.domain.models.ForeCast
import kg.itc.examplemvvm.domain.use_cases.FetchForeCastUseCase
import kg.itc.examplemvvm.domain.use_cases.GetForeCastAsLiveUseCase
import kg.itc.examplemvvm.ui.base.BaseVM
import javax.inject.Inject

@HiltViewModel
class WeatherVM @Inject constructor(
    private val fetchForeCastUseCase: FetchForeCastUseCase,
) : BaseVM() {

    private val _foreCast = MutableLiveData<ForeCast>()
    val foreCast: LiveData<ForeCast>
        get() = _foreCast


    init {
        fetchForeCast()
    }

    fun fetchForeCast() {
        showLoading()
        disposable.add(
            fetchForeCastUseCase()
                .doOnDispose{hideLoading()}
                .subscribe({
                           _foreCast.value = it
                }, this::handleError)
        )
    }
}