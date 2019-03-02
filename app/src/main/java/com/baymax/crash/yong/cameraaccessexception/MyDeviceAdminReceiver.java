package com.baymax.crash.yong.cameraaccessexception;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by cugyong on 2019/3/1.
 */

public class MyDeviceAdminReceiver extends DeviceAdminReceiver {

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Toast.makeText(context, "设备管理器：已激活", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Toast.makeText(context, "设备管理器：未激活", Toast.LENGTH_SHORT).show();
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return "这是一个可选的消息，警告有关禁止用户的请求";
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        super.onPasswordChanged(context, intent);
        Toast.makeText(context, "设备管理；密码已经改变", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordFailed(Context context, Intent intent) {
        super.onPasswordFailed(context, intent);
        Toast.makeText(context, "设备管理；改变密码失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        super.onPasswordSucceeded(context, intent);
        Toast.makeText(context, "设备管理；改变密码成功", Toast.LENGTH_SHORT).show();
    }
}
