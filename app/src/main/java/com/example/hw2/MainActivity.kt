package com.example.hw2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw2.base.BaseActivity
import com.example.hw2.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        const val maASMEMeaning = "key"
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        val launcherData =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                    val data =
                        result.data?.getStringExtra(ActivitySelectedMeaningEt.EXTRA_DATA_NAME)
                    binding.textEt.setText(data)
                }
            }

        binding.clickBtn.setOnClickListener {
            if (binding.textEt.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@MainActivity, ActivitySelectedMeaningEt::class.java).apply {
                    putExtra(maASMEMeaning, binding.textEt.text.toString())
                    launcherData.launch(this)
                }
            }
        }
    }

}