<img width="100" src="./img/RxNotification_icon.png" />

RxNotification
===============

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxNotification-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3546)

Easy way to register, remove and manage notifications using RxJava

Target platforms
---

- API level 14 or later

Latest version
---

- Version 1.1.0  (MAY. 19, 2016)

Usage
---

In order to use the library, there are 3 different options:

**1. Gradle dependency** (recommended)

 - 	Add the following to your `build.gradle`:
 ```gradle
repositories {
	    jcenter()
}

dependencies {
	   compile 'com.marlonmafra.rxnotification:rx-notification-fcm:1.0.0'
}
```

**2. Maven**
- Add the following to your `pom.xml`:

 ```xml
<dependency>
        <groupId>com.marlonmafra.rxnotification</groupId>
        <artifactId>rx-notification-fcm</artifactId>
        <version>1.1.0</version>
        <type>pom</type>
</dependency>
```

**3. Ivy**

 ```xml
<dependency org='com.marlonmafra.rxnotification' name='rx-notification' rev='1.1.0'/>
```

# Sample usage

Getting a token

```java
  RxNotification.getToken(getApplicationContext(), R.string.gcm_regId)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String token) {
                      //Send token to back-end
                    }
                });
```

Removing a token

```java
RxNotification.removeToken(this, R.string.gcm_regId)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Void mVoid) {
                    }
                });
```

Removing instance. All tokens will be removed

```java
RxNotification.removeInstance(this)
.               subscribeOn(Schedulers.io())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Void mVoid) {
                    }
                });
```

Verify whether the Google play Service is update/installed or not

```java
        try {
            RxNotificationUtil.verifyGooglePlayService(this);
            //Register token
        } catch (DeviceUnsupportedException e) {
            //Do Whatever you want
        } catch (GooglePlayServicesOutDatedException e) {
            //Do Whatever you want
        } catch (GooglePlayServicesNotInstalledException e) {
            //Do Whatever you want
        } catch (UnknownErrorException e) {
            //Do Whatever you want
        }
```

If you want you can extends the class RxGcmService. This class will help you to identify whether the app is running or not.

```java
public class GCMService extends RxGcmService {

    @Override
    public void onMessageReceived(String from, Bundle data, boolean isAppRunning) {
        // Do whatever you want here
    }
}
```

Remember that you need to put these code on AndroidManifest.xml

```xml

   <uses-permission android:name="android.permission.WAKE_LOCK" />

    <permission
        android:name="<your-package>.permission.C2D_MESSAGE"
        android:protectionLevel="signature" />
    <uses-permission android:name="<your-package>.permission.C2D_MESSAGE" />
    
    
    <application ....>

        <receiver
            android:name="com.google.android.gms.gcm.GcmReceiver"
            android:exported="true"
            android:permission="com.google.android.c2dm.permission.SEND">
            <intent-filter>
                <action android:name="com.google.android.c2dm.intent.RECEIVE" />
                <category android:name="com.example.pucamafra.rxnotification" />
            </intent-filter>
        </receiver>

        <service
            android:name="com.marlonmafra.rxnotification.sample.GCMService"
            android:exported="false">
            <intent-filter>
                <action android:name="com.google.android.c2dm.intent.RECEIVE" />
            </intent-filter>
        </service>

    </application>
}
```

For more details, take a look on sample module.


License
---

	Copyright (c) 2016 Marlon Mafra

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

