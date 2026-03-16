package week.six.L12.mediaPlayer;

public class OnlineVideo extends MediaFile implements Downloadable {
    private double downloadProgress;

    public OnlineVideo(String title, String filePath) {
        super(title, filePath);
        this.downloadProgress = 0;
    }

    @Override
    public void download(String url) {
        System.out.println("Downloading from: " + url);
        this.downloadProgress = 1;
    }

    @Override
    public double getDownloadProgress() {
        return downloadProgress;
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + getTitle());
    }

    @Override
    public void pause() {
        System.out.println("Video paused: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Video stopped: " + getTitle());
    }

    @Override
    public double getDuration() {
        return 120.0;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
