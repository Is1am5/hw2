package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.trimmedLength
import com.example.a2hwkotlin16.databinding.ActivitySelectedMeaningEtBinding
import com.example.hw2.base.BaseActivity
import com.example.hw2.databinding.ActivitySelectedMeaningEtBinding

class ActivitySelectedMeaningEt : BaseActivity<ActivitySelectedMeaningEtBinding>() {

    companion object {

        const val EXTRA_DATA_NAME = "extra_data_name"
        const val maASMEMeaning = "key"
    }

    override fun inflateViewBinding(): ActivitySelectedMeaningEtBinding {
        return ActivitySelectedMeaningEtBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        val desc = intent.getStringExtra(maASMEMeaning)
        binding.textEt.setText(desc)

        binding.clickBtn.setOnClickListener {
            val data = binding.textEt.text.trimmedLength().toString()

            if (data.isEmpty()) {
                Toast.makeText(this@ActivitySelectedMeaningEt, getString(R.string.toast),
                    Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@ActivitySelectedMeaningEt, MainActivity::class.java).apply {
                    putExtra(EXTRA_DATA_NAME , data)
                    setResult(RESULT_OK , this)
                    finish()
                }
            }
        }
    }
}