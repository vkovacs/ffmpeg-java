package org.example;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.opencv.highgui.HighGui;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.opencv.core.CvType.CV_8UC1;

public class Main {
    public static void main(String[] args) {
        try (VideoCapture capture = new VideoCapture("C:\\TMP\\video\\sample_video_roof.mp4")) {
            var width = capture.get(3);
            var height = capture.get(4);
            Mat frame = new Mat(height, width, CV_8UC1);

            int i = 0;

            boolean hasNextFrame;
            do {
                hasNextFrame = capture.read(frame);
                if (!frame.empty()) {
                    imwrite("C:\\TMP\\video\\cover-%s.jpg".formatted(String.format("%04d", i)), frame);
                }
                i++;

            } while (hasNextFrame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}