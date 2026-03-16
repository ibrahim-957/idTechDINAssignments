package week.six.L12.mediaPlayer;

public interface Playable {
    void play();
    void pause();
    void stop();
    double getDuration();

    default void showInfo(){
        System.out.println("This is a playable media file");
    }
}
