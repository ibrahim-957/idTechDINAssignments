package week.six.L12.mediaPlayer;

public interface Downloadable {
    void download(String url);
    double getDownloadProgress();

    default void showInfo(){
        System.out.println("This is a downloadable file");
    }
}
