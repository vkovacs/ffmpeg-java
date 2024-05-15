package org.example;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.opencv.core.CvType.CV_8UC1;

public class Main {
    public static void main(String[] args) {
        var images = images();
        System.out.println(images);
    }

    private static List<byte[]> images() {
        var list = new ArrayList<byte[]>();

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
                    list.add(asByteArray(frame));
                }
                i++;

            } while (hasNextFrame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static byte[] asByteArray(Mat mat){
        byte[] b = new byte[mat.channels() * mat.cols() * mat.rows()];
        mat.data().get(b);
        return b;
    }
}