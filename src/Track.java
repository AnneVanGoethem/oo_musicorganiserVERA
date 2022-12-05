/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;

    public Track(String artist, String title, String filename) {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    public Track(String filename) {
        this.artist = "unknown";
        this.title = "unknown";
        this.filename = filename;
    }
    public String getArtist()
    {
        return artist;
    }
    public String getTitle()
    {
        return title;
    }
    public String getFilename()
    {
        return filename;
    }
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ")";
    }

    
}
