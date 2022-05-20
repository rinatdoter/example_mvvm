package kg.itc.examplemvvm.ui.base

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import kg.itc.examplemvvm.R
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
open class BaseVM @Inject constructor() : ViewModel() {

    @Inject
    lateinit var resources: Resources


    protected val disposable by lazy {
        CompositeDisposable()
    }

    protected val _event by lazy {
        MutableLiveData<BaseEvent>()
    }
    val event: LiveData<BaseEvent>
    get() = _event

    protected val _errorMessage by lazy {
        MutableLiveData<String>()
    }
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _isLoading by lazy {
        MutableLiveData(false)
    }
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    protected fun showLoading(){
        _isLoading.value = true
    }

    protected fun hideLoading(){
        _isLoading.value = false
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()

    }

    protected open fun handleError(e: Throwable){
        _errorMessage.value = when(e){
            is HttpException -> e.message() ?: e.code().toString()
            is SocketTimeoutException -> resources.getString(R.string.timeout)
            is UnknownHostException -> resources.getString(R.string.no_internet)
            else -> resources.getString(R.string.unknown_exception)
        }
    }
}