package com.shoucheng.imagestory.toast;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Administrator on 17-8-16.
 */

public class ToastUtil {

    public static void snackBar(View view, String info) {
        Snackbar.make(view, info, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
