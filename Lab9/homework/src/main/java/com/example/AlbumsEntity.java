package main.java.com.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "albums", schema = "public", catalog = "albums")
@NamedQueries({
        @NamedQuery(name = "Albums.findAll", query = "select e from AlbumsEntity e order by e.title"),
        //@NamedQuery(name = "Albums.findByArtist", query = "select e from AlbumsEntity e where e.artistid = :artist"),
        @NamedQuery(name = "Albums.findById", query = "select e from AlbumsEntity e where e.id = :id"),
})
public class AlbumsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "release_year")
    private String releaseYear;

    @Basic
    @Column(name = "title")
    private String title;

/*    @Basic
    @Column(name = "genreid")
    private Integer genreid;*/

    @ManyToOne
    /**
     * an album can have only one artist but an artist can be associated with multiple albums
     * */
    @JoinColumn(name = "artistid")
    private ArtistEntity artist;

    @OneToOne
    /**
     * an album can belong to multiple genres and a genre can be associated with multiple albums
     */
    /*@JoinTable(
            name = "genres",
            joinColumns = @JoinColumn(name = "albumid"),
            inverseJoinColumns = @JoinColumn(name = "genreid")
    )*/
    @JoinColumn(name = "genreid")
    private GenreEntity genres;

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }

    public GenreEntity getGenres() {
        return genres;
    }

    public void setGenres(GenreEntity genres) {
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }*/

    /*public Integer getGenreid() {
        return genreid;
    }

    public void setGenreid(Integer genreid) {
        this.genreid = genreid;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumsEntity that = (AlbumsEntity) o;

        if (id != that.id) return false;
        //if (artistid != that.artistid) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        //result = (31 * result + artistid);
        //result = (31 * result + genreid);
        return result;
    }

    @Override
    public String toString() {
        return "AlbumsEntity{" +
                "id=" + id +
                ", releaseyear='" + releaseYear + '\'' +
                ", title='" + title + '\'' +
                //", artistid='" + artistid + '\'' +
                //", genreid='" + genreid + '\'' +
                '}';
    }
}
