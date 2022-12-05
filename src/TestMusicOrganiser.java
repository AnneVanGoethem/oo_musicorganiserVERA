public class TestMusicOrganiser {
    public static void main(String[] args) {
        MusicOrganizer m = new MusicOrganizer();

        m.listAllTracks();
        System.out.println(m.getNumberOfTracks());
        //Track t = new Track("");
        m.stopPlaying();
        m.playTrack(9);

        //m.playTrack(1);



    }
}
