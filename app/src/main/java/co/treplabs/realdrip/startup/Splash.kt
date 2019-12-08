package co.treplabs.realdrip.startup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import co.treplabs.realdrip.MainActivity
import co.treplabs.realdrip.R
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        beginSplashAnimation()

        //end splash after 5 seconds
        Handler().postDelayed( {
            startActivity(Intent(this@Splash, MainActivity::class.java))
            overridePendingTransition(R.anim.enter, R.anim.exit)
            finish()
        }, 5000)
    }

    private fun beginSplashAnimation() {
        tintImage.startAnimation(AnimationUtils.loadAnimation(this@Splash, R.anim.splash_anim))
    }
}
