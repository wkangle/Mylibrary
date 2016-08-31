package kangle.mydialog.MyToast;

import android.content.Context;
import android.content.IntentFilter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import kangle.mydialog.R;


/**
 * 自定义吐司
 */
public class ToastUtils {


    private static Toast toast = null;
    private static TextView tv_text = null;

    public static void showMessage(String toastContent, Context context) {
        if (toast == null || tv_text == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            // 根据指定的布局文件创建一个具有层级关系的View对象
            View layout = inflater.inflate(R.layout.layout_toast, null);
            RelativeLayout root = (RelativeLayout) layout
                    .findViewById(R.id.toast_layout_root);
            root.getBackground().setAlpha(200);// 0~255透明度值
            tv_text = (TextView) layout.findViewById(R.id.text);
            toast = new Toast(context);
            // 设置Toast的位置
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            // 让Toast显示为我们自定义的样子
            toast.setView(layout);
        }
        tv_text.setText(toastContent);
        toast.show();
    }


}
