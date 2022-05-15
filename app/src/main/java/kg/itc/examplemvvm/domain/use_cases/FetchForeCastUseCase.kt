package kg.itc.examplemvvm.domain.use_cases

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kg.itc.examplemvvm.data.repo.ForeCastRepo
import kg.itc.examplemvvm.domain.models.ForeCast
import kg.itc.examplemvvm.extensions.toForeCast
import javax.inject.Inject

class FetchForeCastUseCase @Inject constructor(
    private val foreCastRepo: ForeCastRepo
) {

    operator fun invoke(): Single<ForeCast> {
        return foreCastRepo.getForeCast()
            .map {
                it.toForeCast()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}