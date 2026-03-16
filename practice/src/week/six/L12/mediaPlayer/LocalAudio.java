package week.six.L12.mediaPlayer;

public class LocalAudio extends MediaFile{
    public LocalAudio(String title, String filePath) {
        super(title, filePath);
    }

    @Override
    public void play() {
        System.out.println("Playing audio: " + getTitle());
    }

    @Override
    public void pause() {
        System.out.println("Audio paused: " + getTitle());
    }

    @Override
    public void stop() {
        System.out.println("Audio stopped: " + getTitle());
    }

    @Override
    public double getDuration() {
        return 210.0;
    }

}
