# Google Play Referrer API Sample

* https://developer.android.com/google/play/installreferrer/library.html
* https://android-developers.googleblog.com/2017/11/google-play-referrer-api-track-and.html
* http://blog.techium.jp/entry/2017/11/28/100000_1
* API works with the Play Store app from version 8.3.73 and later for all developers.

## InstallReferrerClientImpl

```java
  // Version 8.3.73 - U_MR_Release
  private static final int PLAY_STORE_MIN_APP_VER = 80837300;

  private static final String SERVICE_PACKAGE_NAME = "com.android.vending";
  private static final String SERVICE_NAME =
      "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
  private static final String SERVICE_ACTION_NAME =
      "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
```