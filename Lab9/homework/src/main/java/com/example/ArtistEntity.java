package main.java.com.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artist", schema = "public", catalog = "albums")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll", query = "select e from main.java.com.example.ArtistEntity e order by e.name"),
        @NamedQuery(name = "Artist.findByName", query = "select e from main.java.com.example.ArtistEntity e where e.name = :name"),
        @NamedQuery(name="Artist.findById", query = "select e from main.java.com.example.ArtistEntity e where e.id = :id")
})
public class ArtistEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    /**
     * an album can have only one artist but an artist can be associated with multiple albums
     * */
    private List<AlbumsEntity> albums;


    public ArtistEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlbumsEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumsEntity> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
