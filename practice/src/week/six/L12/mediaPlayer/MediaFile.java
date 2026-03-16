package week.six.L12.mediaPlayer;

public abstract class MediaFile implements Playable {
    private String title;
    private String filePath;

    public MediaFile(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void stop();
    public abstract double getDuration();
}
