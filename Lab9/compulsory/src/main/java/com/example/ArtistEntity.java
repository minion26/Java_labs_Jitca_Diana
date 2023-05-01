package main.java.com.example;

import jakarta.persistence.*;

import java.io.Serializable;

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

    public ArtistEntity(String test) {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistEntity that = (ArtistEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
