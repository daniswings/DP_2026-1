package ch02.A2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("newfile.txt");
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// ch02 > A2 > file.txt 위치에 둔 채로 run할 시 No such file or directory 오류
// 따라서 file.txt 위치를 DP_2026-1 바로 아래, src와 같은 위치에 둬야 newfile.txt is created로 정상 처리됨