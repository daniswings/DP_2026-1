package ch11.Sample;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");

        // 디렉터리 4개 만듦
        // Directory rootdir = new Directory("root");
        Entry root = new Directory("root");  // 업캐스팅은 자동으로 일어나므로 우리가 따로 신경써줄 필요 전혀 x
        // root의 타입은 entry지만 실제로는 디렉토리가 들어가 있으니 add를 선언할 수 있는 것 아닌가?
        // 없으므로 rootdir.add();에 빨간줄 뜸 -> (Directory)root.add(bin);, 즉 자식의 타입으로 형변환 해주면 add 메소드 사용 가능
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");

        // 루트 디렉터리 밑에 3개의 디렉터리를 추가

        // Entry 타입을 Directory 타입으로, 즉 부모 타입을 자식 타입으로 형변환하는 다운캐스팅
        ((Directory)rootdir).add(bindir); // . 연산자가 타입캐스팅 연산자보다 우선순위가 높다 -> 따라서 (Directory)root에 괄호 씌워져야 함
        rootdir.add(tmpdir);
        rootdir.add(usrdir);


        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));

        rootdir.printList();
        System.out.println();

        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");

        usrdir.add(youngjin);
        usrdir.add(gildong);
        usrdir.add(dojun);

        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));

        gildong.add(new File("memo.tex", 300));

        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));
        
        rootdir.printList();
    }
}
