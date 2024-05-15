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

        try (VideoCapture capture = new VideoCapture("C:\\TMP\\video\\sample_video_roof.mp4")) {
            int i = 0;
            var hasNextFrame = capture.read(frame);
            while (hasNextFrame) {
                if (!frame.empty()) {
                    imwrite("C:\\TMP\\video\\cover-%s.jpg".formatted(String.format("%04d", i)), frame);
                }

                hasNextFrame = capture.read(frame);
            }
            if (!frame.empty()) {
                imwrite("C:\\TMP\\video\\cover-%s.jpg".formatted(String.format("%04d", i)), frame);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}