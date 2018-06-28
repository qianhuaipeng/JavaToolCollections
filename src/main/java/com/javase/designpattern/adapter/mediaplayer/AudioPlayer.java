package com.javase.designpattern.adapter.mediaplayer;

/**
 * author: alan.peng
 * description:
 * date: create in 15:25 2018/3/26
 * modified By：
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdpater mediaAdpater;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file name: " + fileName);
        } else if ("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            mediaAdpater = new MediaAdpater(audioType);
            mediaAdpater.play(audioType,fileName);
        } else {
            System.out.println("Invalid media. " + audioType + "format not supported!");
        }
    }
}
