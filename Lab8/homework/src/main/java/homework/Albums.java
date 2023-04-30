package homework;

public class Albums
{
    private int id;
    private String name;
    private int artistId;
    private int releaseYear;

    public Albums(String name, int artistId, int releaseYear)
    {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public Albums(int id, String name, int artistId, int releaseYear)
    {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public Albums()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getArtistId()
    {
        return artistId;
    }

    public void setArtistId(int artistId)
    {
        this.artistId = artistId;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
}
