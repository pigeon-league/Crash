package com.baymax.crash.yong.cameraaccessexception;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/1.
 */

public class CameraAccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_access);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("CameraAccessException只有在使用Camera2API(5.0及以上)时，才会出现，而" +
                "云闪付现在使用的还是老的CameraAPI。该异常会在相机设备不可用" +
                "或者相机设备断开连接时，继续使用相机设备就会出现。有以下几点建议：" +
                "1、在使用相机设备的时候，try-catch该异常；2、在相机设备断开连接，即onDisconnected回调" +
                "方法被调用时，调用CameraDevice的close方法关闭相机设备。");

        CheckBox checkBox = findViewById(R.id.checkbox);
        checkBox.setChecked(false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //AdminReciver.class就是DeviceAdminReceiver的子类
                    ComponentName adminReceiver = new ComponentName(CameraAccessActivity.this,
                            MyDeviceAdminReceiver.class);
                    //打开DevicePolicyManager管理器，授权页面
                    Intent intent = new Intent();
                    //授权页面Action -->  DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN
                    intent.setAction(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    //设置DEVICE_ADMIN，告诉系统申请管理者权限的Component/DeviceAdminReceiver
                    intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminReceiver);
                    startActivityForResult(intent, 1);
                }else {
                    DevicePolicyManager devicePolicyManager = (DevicePolicyManager)
                            getSystemService(Context.DEVICE_POLICY_SERVICE);
                    ComponentName adminReceiver = new ComponentName(CameraAccessActivity.this,
                            MyDeviceAdminReceiver.class);
                    if (devicePolicyManager.isAdminActive(adminReceiver)){
                        devicePolicyManager.setCameraDisabled(adminReceiver, false);
                        devicePolicyManager.removeActiveAdmin(adminReceiver);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        DevicePolicyManager devicePolicyManager = (DevicePolicyManager)
                getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName adminReceiver = new ComponentName(this, MyDeviceAdminReceiver.class);
        if (devicePolicyManager.isAdminActive(adminReceiver)){
            final TextView log = findViewById(R.id.tv_log);

            devicePolicyManager.setCameraDisabled(adminReceiver, true);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try {
                manager.openCamera("0", new CameraDevice.StateCallback() {
                    @Override
                    public void onOpened(CameraDevice camera) {
                    }

                    @Override
                    public void onDisconnected(CameraDevice camera) {
                    }

                    @Override
                    public void onError(CameraDevice camera, int error) {

                    }
                }, null);
            } catch (CameraAccessException e) {
                log.setText(Log.getStackTraceString(e.fillInStackTrace()));
            }
        }
    }
}
