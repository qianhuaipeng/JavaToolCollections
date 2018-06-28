package com.javase.designpattern.adapter.mediaplayer;

/**
 * author: alan.peng
 * description:
 * date: create in 15:33 2018/3/26
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","i miss you.mp3");
        audioPlayer.play("mp4","alone.mp4");
        audioPlayer.play("vlc","test.vlc");
        audioPlayer.play("avi","hhhh.avi");
    }
}
