package week.six.L12.mediaPlayer;

public class Main {
    public static void main(String[] args) {
        OnlineVideo ov = new OnlineVideo("yox", "src");
        Playable p = ov;
        Downloadable d = ov;
        p.getDuration();
        p.play();
        d.download(ov.getFilePath());
        d.download(ov.getFilePath());
        ov.showInfo();
    }
}
