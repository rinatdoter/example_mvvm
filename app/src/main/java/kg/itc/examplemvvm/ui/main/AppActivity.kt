package kg.itc.examplemvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.examplemvvm.R
import kg.itc.examplemvvm.databinding.ActivityMainBinding
import kg.itc.examplemvvm.extensions.showToast
import kg.itc.examplemvvm.ui.base.BaseActivity
import kg.itc.examplemvvm.ui.base.BaseEvent

@AndroidEntryPoint
class AppActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            setInitFragment(MainFragment())
        }
    }

    private fun setInitFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }


}