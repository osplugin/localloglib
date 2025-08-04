# LocalLogApp
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/com.github.osplugin/localloglib.svg)](https://jitpack.io/#com.github.osplugin/localloglib)

### 一、介绍
1. 这是一个基于EventBus的本地文件日志打印系统。
2. 日志打印过程使用子线程处理，不会阻塞主线程。
3. 每次需要打印时都会检查文件夹是否存在，因此软件运行时，删除打印目录后会重建而不会发生异常

### 二、工程引入工具包准备
**工程的build.gradle文件添加** 

```
allprojects {
    repositories {
        google()
        mavenCentral()

        //jitpack 仓库
        maven { url 'https://jitpack.io' }
    }
}
```

**APP的build.gradle文件添加** 
```
dependencies {
    ...
    implementation 'com.github.osplugin:localloglib:1.0.3'
    implementation 'org.greenrobot:eventbus:3.2.0'
}
```
### 三、使用

-  **注册打印日志监听，获取存储权限后初始化，避免异常** 

```
   //初始化参数为日志文件所在文件夹，不可为空，存放在 存储-Android-data-包名-files-logs文件下
   LocalLogSystem.init(getExternalFilesDir("").getAbsolutePath() + File.separator + "logs")
    //日志文件内容的编码，默认 utf-8
    .setCharset(Charset.forName("UTF-8"))
    //日志文件名称前缀，默认“Log”
    .setFileName("App")
    //日志文件后缀按时间生成日志文件，此为每小时一份文件
    .setLogTimeSection(LogTimeSectionEnum.YYYY_MM_DD)
    //打印文件的文件名后缀，默认 “log”
    .setFileSuffix("log")
    //级别与“文件名”的衔接符，级别不存在时无效
    .setLevelPrefix("-")
    //附加名与“级别”或“文件名”的衔接符，附加名不存在时无效
    .setAppendNamePrefix("-")
    //时间分段与“附加名”或“级别”或“文件名”的衔接符，时间分段不存在时无效
    .setDateTimePrefix("-")
    .setLocalLogFileAppendName(() -> {
        //附加数据此数据可以在运行后动态修改，为null、异常、均会按照""处理，例如登录后可以附加名字
        return "名字";
    })
    //完成初始化，并成为观察者，此时才会接收日志打印事件
    .complete();
```
-  **触发打印日志** 

```
     try {
        LocalLogPrintUtils.commonPrintf("这是一个普通级别日志: " + r);
        LocalLogPrintUtils.customPrintf("自定义", "这是一个自定义级别日志: " + r);
        LocalLogPrintUtils.debugPrintf("这是一个Debug级别日志: " + r);
        LocalLogPrintUtils.infoPrintf("这是一个Info级别日志: " + r);
        LocalLogPrintUtils.runtimePrintf("这是一个Runtime级别日志: " + r);

        throw new RuntimeException("这是一个测试异常");
    } catch (Exception e) {
        LocalLogPrintUtils.exceptionPrintf("这是一个Exception级别日志: " + r, e);
    }
```

### 注：不同的级别打印只是在日志文件名上附加相关字段标记


License
-------

    Copyright 2021 mjsoftking

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



