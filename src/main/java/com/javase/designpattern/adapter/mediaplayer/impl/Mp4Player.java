package com.javase.designpattern.adapter.mediaplayer.impl;

import com.javase.designpattern.adapter.mediaplayer.AdvancedMediaPlayer;

/**
 * author: alan.peng
 * description:
 * date: create in 14:52 2018/3/26
 * modified By：
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么都不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 filename :" + fileName);
    }
}
