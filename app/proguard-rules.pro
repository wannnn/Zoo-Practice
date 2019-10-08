# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 代码混淆壓缩比，在0~7之间，默認為5，一般不做修改
-optimizationpasses 5

# 混合时不使用大小寫混合，混合后的類名为小寫
-dontusemixedcaseclassnames

# 指定不去忽略非公共庫的類
-dontskipnonpubliclibraryclasses

# 這句話能夠使我們的項目混淆後產生映射文件
# 包含有類名->混淆後類名的映射關係
-verbose

# 指定不去忽略非公共庫的類成員
-dontskipnonpubliclibraryclassmembers

# 不做預校驗，preverify是proguard的四個步驟之一，Android不需要preverify，去掉這一步能夠加快混淆速度。
-dontpreverify

# 保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses

# 避免混淆簽章
-keepattributes Signature

# 拋出異常時保​​留代碼行號
-keepattributes SourceFile,LineNumberTable

# 指定混淆是採用的算法，後面的參數是一個過濾器
# 這個過濾器是谷歌推薦的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*

#############################################
#
# Android開發中一些需要保留的公共部分
#
#############################################
# 保留我們使用的四大組件，自定義的Application等等這些類不被混淆
# 因為這些子類都有可能被外部調用
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService

# 保留support下的所有類及其內部類
-keep class android.support.** {*;}

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

# 保留R下面的资源
-keep class **.R$* {*;}

# 保留在Activity中的方法參數是view的方法，
# 這樣以來我們在layout中寫的onClick就不會被影響
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

# 保留枚舉類不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保留我們自定義控件（繼承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public (android.content.Context);
    public (android.content.Context, android.util.AttributeSet);
    public (android.content.Context, android.util.AttributeSet, int);
}

# 保留Parcelable序列化類不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# 保留Serializable序列化的類不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient ;
    !private ;
    !private ;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

# webView處理
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

#------------處理第三方套件--------------
# Facebook
-keep class com.facebook.** {*;}
-keep interface com.facebook.** {*;}
-keep enum com.facebook.** {*;}

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# Gson
-dontwarn com.google.gson.**
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# OkHttp
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

#android-async-http
-dontwarn com.loopj.android.http.**
-keep class com.loopj.android.http.**{*;}

#brightcove
-dontwarn com.brightcove.**
-keep class com.brightcove.** {*;}

#comscore
-keep class com.comscore.** { *; }
-dontwarn com.comscore.**

#ad
-keep public class com.google.android.gms.ads.** {
   public *;
}
-keep public class com.google.ads.** {
   public *;
}

#Crashlytics
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# Required to preserve the Flurry SDK
-keep class com.flurry.** { *; }
-dontwarn com.flurry.**
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepclasseswithmembers class * {
    public (android.content.Context, android.util.AttributeSet, int);
}