package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0; // 현재 제일 긴 문자열의 길이

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) { // 더 긴 문자열이 추가되면
            // 최대 문자 수 갱신 - columns에는 항상 최대 문자 수 담기게 됨
            columns = msg.length();
        }
        // 제일 긴 문자에 맞춰서 나머지 문자열의 오른쪽 끝에 공백을 채운다
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        // 현재 추가된 모든 문자열에 대해서 for루프를 돌림
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            int padding = columns - line.length();
            if (padding > 0) { // 현재 문자열이 제일 긴 문자열보다 짧으면
                body.set(row, line + spaces(padding));
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}
