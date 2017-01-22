package com.marlonmafra.rxnotification.fcm.sample;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class GCMService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.d("RxNotificationFCM", "Receiving notification");
    }

}
