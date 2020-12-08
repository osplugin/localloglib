package com.mjsoftking.locallogapp;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mjsoftking.locallogapp.databinding.ActivityMainBinding;
import com.mjsoftking.localloglib.LocalLogSystem;
import com.mjsoftking.localloglib.enumerate.LogTimeSectionEnum;
import com.mjsoftking.localloglib.event.LogCommonEvent;
import com.mjsoftking.localloglib.event.LogCustomEvent;
import com.mjsoftking.localloglib.event.LogDebugEvent;
import com.mjsoftking.localloglib.event.LogExceptionEvent;
import com.mjsoftking.localloglib.event.LogInfoEvent;
import com.mjsoftking.localloglib.event.LogRuntimeEvent;
import com.mjsoftking.localloglib.util.FolderUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.nio.charset.Charset;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClick(this);

        initPermissions();
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.text) {
//
//        }
        if (v.equals(binding.text)) {
            Random random = new Random();
            int r = random.nextInt(10000);

            try {
                EventBus.getDefault().post(new LogCommonEvent("这是一个普通级别日志: " + r));
                EventBus.getDefault().post(new LogCustomEvent("自定义", "这是一个自定义级别日志: " + r));
                EventBus.getDefault().post(new LogDebugEvent("这是一个Debug级别日志: " + r));
                EventBus.getDefault().post(new LogInfoEvent("这是一个Info级别日志: " + r));
                EventBus.getDefault().post(new LogRuntimeEvent("这是一个Runtime级别日志: " + r));

                throw new RuntimeException("这是一个测试异常");
            } catch (Exception e) {
                EventBus.getDefault().post(new LogExceptionEvent("这是一个Exception级别日志: " + r, e));
            }
        }
    }

    private void initPermissions() {
        CompositeDisposable disposable = new CompositeDisposable();
        new RxPermissions(this).request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                //io 线程运行
                .subscribeOn(Schedulers.io())
                //主线程返回
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@Nullable Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(@Nullable Boolean aBoolean) {
                        if (aBoolean) {
                            //todo 初始化日志系统，不可主动调用 printf 方法
                            //初始化参数为日志文件所在文件夹，不可为空
                            LocalLogSystem.init(FolderUtil.getSDRoot() + "AppLocalLogTest")
                                    //日志文件内容的编码，默认 utf-8
                                    .setCharset(Charset.forName("UTF-8"))
                                    //日志文件名成前缀，默认“Log”
                                    .setFileName("App")
                                    //日志文件后缀按时间生成日志文件，此列为每小时一份
                                    .setLogTimeSection(LogTimeSectionEnum.YYYY_MM_DD_HH)
                                    //完成初始化，并成为观察者，此时才会接收日志打印事件
                                    .complete();
                        } else {
                            //未授权
                        }
                    }

                    @Override
                    public void onError(@Nullable Throwable e) {
                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                    }
                });
    }
}