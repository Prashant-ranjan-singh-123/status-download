package com.appzeto.status.interfaces;

public interface VideoDownloader {

//    String createDirectory();

    String getVideoId(String link);

    void DownloadVideo();
}
