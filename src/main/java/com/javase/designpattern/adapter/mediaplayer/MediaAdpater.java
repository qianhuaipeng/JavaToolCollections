package com.javase.designpattern.adapter.mediaplayer;

import com.javase.designpattern.adapter.mediaplayer.impl.Mp4Player;
import com.javase.designpattern.adapter.mediaplayer.impl.VlcPlayer;

/**
 * author: alan.peng
 * description: 适配器
 * date: create in 14:54 2018/3/26
 * modified By：
 */
public class MediaAdpater implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdpater(String audioType){
        if ("vlc".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = new VlcPlayer();
        } else if("mp4".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
