package kg.itc.examplemvvm.ui.main

import kg.itc.examplemvvm.databinding.FragmentMainBinding
import kg.itc.examplemvvm.ui.base.BaseFragment

class MainFragment: BaseFragment<MainFragmentVM, FragmentMainBinding>(
    MainFragmentVM::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
) {


    fun example(){

    }
}