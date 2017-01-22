package com.marlonmafra.rxnotification.fcm;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.concurrent.Callable;

import rx.Observable;

import static com.marlonmafra.rxnotification.fcm.util.Preconditions.checkNotNull;

public class RxNotification {

    /**
     * Create a token on Google Cloud Message
     *
     * @return an Observable that emits the result.
     */
    @CheckResult
    @NonNull
    public static Observable<String> getToken() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return FirebaseInstanceId.getInstance().getToken();
            }
        });
    }

    /**
     * * Remove the Instance ID itself, including all associated tokens
     *
     * @return an Observable that emits the result.
     */
    @CheckResult
    @NonNull
    public static Observable<Void> removeInstance() {
        return Observable.fromCallable(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FirebaseInstanceId.getInstance().deleteInstanceId();
                return null;
            }
        });
    }
}
