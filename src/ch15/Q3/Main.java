package ch15.Q3;

public class Main {
    public static void main(String[] args) {
        String html = """
        <!DOCTYPE html>
        <html>
            <head>
                <title>Welcome!</title>
            </head>
            <body>
                <h1 style="text-align: center">Hello, world!</h1>
            </body>
        </html>
        """;
        // \" 사용할 필요 x
        // 마지막 """;를 한 탭 앞으로 땡기면 그게 기준이 되어 모든 줄 한 칸씩 탭 뒤로 밀림
        System.out.print(html);
    }
}
