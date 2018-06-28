package com.javase.designpattern.adapter.mediaplayer.impl;

import com.javase.designpattern.adapter.mediaplayer.AdvancedMediaPlayer;
import com.javase.designpattern.adapter.mediaplayer.MediaPlayer;

/**
 * author: alan.peng
 * description:
 * date: create in 14:51 2018/3/26
 * modified By：
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc fileName :" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
