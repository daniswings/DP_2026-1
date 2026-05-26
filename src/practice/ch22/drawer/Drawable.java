package practice.ch22.drawer;

// 그리기 대상
// 그림이 그려지는 영역인 draw canvas는 이 drawable을 구현하면 됨
public interface Drawable {
    public abstract void draw(int x, int y);
}
