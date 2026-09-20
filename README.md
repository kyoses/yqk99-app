# yqk99 WebView App

把 `yqk99.app`（可配置）封装为一个 Android 原生 App。

## 功能

- WebView 加载网页，默认地址 `https://yqk99.app`
- App 内「设置」页面可修改 URL，保存到 SharedPreferences
- 顶部加载进度条
- 下拉刷新页面
- 返回键优先返回 WebView 历史上一页，无历史时退出
- 支持 JS、DOM Storage、文件下载、文件上传

## 编译步骤

1. 用 **Android Studio**（建议 Hedgehog | 2023.1.1 或更新版本）打开 `yqk99-app/` 目录
2. 等待 Gradle Sync 完成（首次会自动生成 `gradlew`、`gradle/wrapper/`）
3. 菜单 `Build → Build Bundle(s) / APK(s) → Build APK(s)`
4. 生成的 APK：`app/build/outputs/apk/debug/app-debug.apk`

把 APK 拷到手机点击安装即可（需开启「未知来源安装」）。

## 项目结构

```
yqk99-app/
├── app/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/yqk99/
│       │   ├── MainActivity.kt
│       │   └── SettingsActivity.kt
│       └── res/
│           ├── drawable/ic_launcher_foreground.xml
│           ├── layout/activity_main.xml
│           ├── layout/activity_settings.xml
│           ├── menu/menu_main.xml
│           ├── mipmap-anydpi-v26/ic_launcher.xml
│           ├── mipmap-anydpi-v26/ic_launcher_round.xml
│           └── values/colors.xml
│           └── values/strings.xml
│           └── values/themes.xml
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md
```

## 修改默认网址

打开 `app/src/main/res/values/strings.xml`：

```xml
<string name="default_url">https://yqk99.app</string>
```

把 URL 改为你想要的即可。第一次安装的默认地址会变化，已安装 App 内的设置页保存的值不受影响。