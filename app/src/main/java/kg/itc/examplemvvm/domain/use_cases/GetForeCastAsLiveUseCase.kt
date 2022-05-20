package kg.itc.examplemvvm.domain.use_cases

import kg.itc.examplemvvm.data.repo.ForeCastRepo
import javax.inject.Inject

class GetForeCastAsLiveUseCase @Inject constructor(
    private val foreCastRepo: ForeCastRepo
) {

}