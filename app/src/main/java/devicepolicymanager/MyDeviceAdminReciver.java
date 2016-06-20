package devicepolicymanager;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.transility.tim.android.R;
import com.transility.tim.android.Utilities.Utility;

import java.util.zip.Inflater;

public class MyDeviceAdminReciver extends DeviceAdminReceiver {
    public static String MAHEVENT="action.com.app.tranisity.android";

    private static WindowManager  windowManager;
    private static LinearLayout wrapperView;
    private static  Button submitBtn;

    @Override
    public void onDisabled(Context context, Intent intent) {

        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onDisabled");

    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onEnabled");
    }



    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onDisableRequested");
        if (windowManager==null){
            windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        wrapperView=new LinearLayout(context);
        wrapperView.setOrientation(LinearLayout.VERTICAL);

            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams( WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        View masterScreen=inflater.inflate(R.layout.activity_main,wrapperView);

        windowManager.addView(wrapperView, localLayoutParams);

        submitBtn= (Button) masterScreen.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(onClickListener);

        return context.getString(R.string.textDisableTheDevieAdminApp);
    }


private View.OnClickListener onClickListener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        windowManager.removeViewImmediate(wrapperView);
    }
};
    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onPasswordChanged");

        DevicePolicyManager localDPM = (DevicePolicyManager) context
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName localComponent = new ComponentName(context,
                MyDeviceAdminReciver.class);
        localDPM.setPasswordExpirationTimeout(localComponent, 0L);
    }


    @Override
    public void onPasswordExpiring(Context context, Intent intent) {
        // This would require API 11 an above
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onPasswordExpiring");

        DevicePolicyManager localDPM = (DevicePolicyManager) context
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName localComponent = new ComponentName(context,
                MyDeviceAdminReciver.class);
        long expr = localDPM.getPasswordExpiration(localComponent);
        long delta = expr - System.currentTimeMillis();
        boolean expired = delta < 0L;
        if (expired) {
            localDPM.setPasswordExpirationTimeout(localComponent, 10000L);
            Intent passwordChangeIntent = new Intent(
                    DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
            passwordChangeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(passwordChangeIntent);
        }
    }

    @Override
    public void onPasswordFailed(Context context, Intent intent) {
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onPasswordFailed");
    }

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onPasswordSucceeded");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        super.onReceive(context, intent);
        Utility.logError(MyDeviceAdminReciver.class.getSimpleName(),"onReceive");

    }
}
