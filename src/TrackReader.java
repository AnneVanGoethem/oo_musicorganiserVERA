import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * A helper class for our music application. This class can read files from the file system
 * from a given folder with a specified suffix. It will interpret the file name as artist/
 * track title information.
 * <p>
 * It is expected that file names of music tracks follow a standard format of artist name
 * and track name, separated by a dash. For example: TheBeatles-HereComesTheSun.mp3
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.03.27
 */
public class TrackReader {
    public TrackReader() {
    }

    /**
     * Read music files from the given library folder with the given suffix.
     *
     * @param folder The folder to look for files.
     * @param suffix The suffix of the audio type.
     * @return ArrayList of Track objects
     */
    public ArrayList<Track> readTracks(String folder, final String suffix) {
        final File[] audioFiles = readFilenamesInFolder(folder, suffix);
        final ArrayList<Track> tracks = new ArrayList<>();
        // Put all the matching files into an array so that they can be added in the MusicOrganizer.
        for (File file : audioFiles) {
            final Track trackDetails = decodeDetails(file);
            tracks.add(trackDetails);
        }
        return tracks;
    }

    /**
     * Read all files with given suffix in given folder
     *
     * @param folder The folder to look for files.
     * @param suffix The suffix of the audio type.
     * @return array of File objects
     */
    private File[] readFilenamesInFolder(String folder, String suffix) {
        final File audioFolder = new File(folder);
        final FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(suffix);
            }
        };
        final File[] audioFiles = audioFolder.listFiles(filter);
        return audioFiles;
    }

    /**
     * Try to decode details of the artist and the title from the file name.
     * It is assumed that the details are in the form: artist-title.mp3
     *
     * @param file The track file.
     * @return A Track containing the details.
     */
    private Track decodeDetails(File file) {
        // The information needed.
        String artist = "unknown";
        String title = "unknown";

        // Look for artist and title in the name of the file.
        String filename = file.getName();
        String filenameWithoutSuffix = filename.replaceAll("\\..*", "");
        String[] filenameParts = filenameWithoutSuffix.split("-");

        if (filenameParts.length == 2) {
            artist = filenameParts[0];
            title = filenameParts[1];
        }
        return new Track(artist, title, file.getPath());
    }
}
