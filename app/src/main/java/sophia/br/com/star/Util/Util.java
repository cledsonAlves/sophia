package sophia.br.com.star.Util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by cledson.alves on 12/09/2017.
 */

public class Util {


    public static void animateFragment(final View view) {

        AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setDuration(250);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {

                AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
                fadeIn.setDuration(250);
                view.startAnimation(fadeIn);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(fadeOut);
    }


}
