package org.example;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.opencv.core.CvType.CV_8UC1;

public class Main {
    public static void main(String[] args) throws Exception {
        int height = 240;
        int width = 320;

        Mat frame = new Mat(height, width, CV_8UC1);

        VideoCapture capture = new VideoCapture("C:\\TMP\\video\\sample_video_roof.mp4");

        if (capture.isOpened()) {
            capture.read(frame);
        }

        if (frame != null) {
            imwrite("C:\\TMP\\video\\cover.jpg", frame);
        }
    }
}